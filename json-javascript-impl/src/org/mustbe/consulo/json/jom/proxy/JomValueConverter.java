package org.mustbe.consulo.json.jom.proxy;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredReadAction;
import org.mustbe.consulo.json.jom.JomElement;
import org.mustbe.consulo.json.jom.proxy.impl.JomBooleanValue;
import org.mustbe.consulo.json.jom.proxy.impl.JomCollectionValue;
import org.mustbe.consulo.json.jom.proxy.impl.JomMapConverter;
import org.mustbe.consulo.json.jom.proxy.impl.JomNullableNumberValue;
import org.mustbe.consulo.json.jom.proxy.impl.JomNumberValue;
import org.mustbe.consulo.json.jom.proxy.impl.JomStringConverter;
import com.intellij.lang.javascript.psi.JSArrayLiteralExpression;
import com.intellij.lang.javascript.psi.JSExpression;
import com.intellij.lang.javascript.psi.JSObjectLiteralExpression;
import com.intellij.psi.PsiElement;
import com.intellij.util.containers.ArrayListSet;

/**
 * @author VISTALL
 * @since 13.11.2015
 */
public class JomValueConverter
{
	public interface Converter<T>
	{
		T getDefaultValue();

		@RequiredReadAction
		T parseValue(@NotNull Class type, @NotNull Type genericType, @NotNull PsiElement value) throws JomBadValueExpressionException;
	}

	private static Map<Class, Converter> ourDefaultConverters = new HashMap<Class, Converter>();

	static
	{
		// primitives
		ourDefaultConverters.put(byte.class, new JomNumberValue<Byte>(Byte.class));
		ourDefaultConverters.put(short.class, new JomNumberValue<Short>(Short.class));
		ourDefaultConverters.put(int.class, new JomNumberValue<Integer>(Integer.class));
		ourDefaultConverters.put(long.class, new JomNumberValue<Long>(Long.class));
		ourDefaultConverters.put(float.class, new JomNumberValue<Float>(Float.class));
		ourDefaultConverters.put(double.class, new JomNumberValue<Double>(Double.class));
		ourDefaultConverters.put(boolean.class, new JomBooleanValue(Boolean.FALSE));

		// primitive wrappers
		ourDefaultConverters.put(Byte.class, new JomNullableNumberValue<Byte>(Byte.class));
		ourDefaultConverters.put(Short.class, new JomNullableNumberValue<Short>(Short.class));
		ourDefaultConverters.put(Integer.class, new JomNullableNumberValue<Integer>(Integer.class));
		ourDefaultConverters.put(Long.class, new JomNullableNumberValue<Long>(Long.class));
		ourDefaultConverters.put(Float.class, new JomNullableNumberValue<Float>(Float.class));
		ourDefaultConverters.put(Double.class, new JomNullableNumberValue<Double>(Double.class));
		ourDefaultConverters.put(Boolean.class, new JomBooleanValue(null));

		ourDefaultConverters.put(String.class, new JomStringConverter());

		// collections
		ourDefaultConverters.put(Map.class, new JomMapConverter());
		ourDefaultConverters.put(Collection.class, new JomCollectionValue<Collection>(ArrayList.class));
		ourDefaultConverters.put(List.class, new JomCollectionValue<List>(ArrayList.class));
		ourDefaultConverters.put(Set.class, new JomCollectionValue<Set>(ArrayListSet.class));
	}

	@RequiredReadAction
	@SuppressWarnings("unchecked")
	public static Object convertToObject(@NotNull Class type, @NotNull Type genericType, @Nullable JSExpression value) throws JomBadValueExpressionException
	{
		if(value == null)
		{
			throw new JomBadValueExpressionException("No value for property");
		}

		JomValueConverter.Converter converter = JomValueConverter.ourDefaultConverters.get(type);
		if(converter != null)
		{
			return converter.parseValue(type, genericType, value);
		}

		if(type.isArray())
		{
			if(value instanceof JSArrayLiteralExpression)
			{
				Class componentType = type.getComponentType();

				JSExpression[] expressions = ((JSArrayLiteralExpression) value).getExpressions();

				List list = new ArrayList(expressions.length);
				for(JSExpression expression : expressions)
				{
					try
					{
						Object o = JomValueConverter.convertToObject(componentType, componentType, expression);
						list.add(o);
					}
					catch(JomBadValueExpressionException e)
					{
						// we dont interest in bad value
					}
				}

				return list.toArray((Object[]) Array.newInstance(componentType, list.size()));
			}
		}

		if(JomElement.class.isAssignableFrom(type))
		{
			return JomProxyInvocationHandler.createProxy(type, value instanceof JSObjectLiteralExpression ? (JSObjectLiteralExpression) value : null);
		}

		throw new UnsupportedOperationException("Unsupported type: " + genericType);
	}

	@Nullable
	public static Object getDefaultValueForType(@NotNull Class type)
	{
		JomValueConverter.Converter converter = JomValueConverter.ourDefaultConverters.get(type);
		if(converter != null)
		{
			return converter.getDefaultValue();
		}

		if(type.isArray())
		{
			return Array.newInstance(type.getComponentType(), 0);
		}

		if(JomElement.class.isAssignableFrom(type))
		{
			return null;
		}

		throw new UnsupportedOperationException("Unsupported type: " + type);
	}
}
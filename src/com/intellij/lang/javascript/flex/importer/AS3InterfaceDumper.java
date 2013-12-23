package com.intellij.lang.javascript.flex.importer;

import gnu.trove.THashSet;

import java.util.Arrays;
import java.util.Set;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Maxim.Mossienko
 *         Date: Oct 20, 2008
 *         Time: 7:02:29 PM
 */
class AS3InterfaceDumper extends AbstractDumpProcessor
{
	private int memberCount;
	private boolean isInterface;

	@Override
	public void dumpStat(@NotNull final String stat)
	{
	}

	@Override
	public void dumpToplevelAnonymousMethod(final @NotNull Abc abc, final @NotNull MethodInfo m)
	{
	}

	@Override
	public void dumpTopLevelTraits(final Abc abc, final @NotNull Traits t, final String indent)
	{
		t.dump(abc, indent, "", this);
	}

	@Override
	public boolean doDumpMember(final @NotNull MemberInfo memberInfo)
	{
		if(memberInfo.name == null)
		{
			return false;
		}
		if(memberInfo.name.name != null && memberInfo.name.name.indexOf(Abc.$CINIT) >= 0)
		{
			return false;
		}
		return true;
	}

	@Override
	public void appendMethodSeparator()
	{
		append((++memberCount % 5) == 0 ? "\n" : "");
	}

	@Override
	public void appendFieldSeparator()
	{
		appendMethodSeparator();
	}

	@Override
	public String getAbcInSwfIndent()
	{
		return "";
	}

	@Override
	public void processValue(final Multiname typeName, final Object valueObject)
	{
		append(" = ");
		append(getValueRepr(valueObject));
	}

	protected static String getValueRepr(Object valueObject)
	{
		if(valueObject == null)
		{
			return null;
		}
		@NonNls String value = valueObject.toString();
		char ch;

		if(needsQuoting(value))
		{
			boolean doQoute = true;

			if(value.indexOf('.') != -1)
			{
				try
				{
					Double.parseDouble(value);
					doQoute = false;
				}
				catch(NumberFormatException ex)
				{
				}
			}
			else if(value.length() > 0 && (Character.isDigit(ch = value.charAt(0)) || (ch == '-' && value.length() > 1 && Character.isDigit(value.charAt(1)
			))))
			{
				try
				{
					Integer.parseInt(value);
					doQoute = false;
				}
				catch(NumberFormatException ex)
				{
				}
			}

			if(doQoute)
			{
				value = "\"" + quote(value) + "\"";
			}
		}
		return value;
	}

	private static
	@NonNls
	Set<String> doNotNeedQoting = new THashSet<String>(Arrays.asList("null", "NaN", "undefined", "true", "false", "Infinity", "-Infinity"));

	private static boolean needsQuoting(final String value)
	{
		return !doNotNeedQoting.contains(value);
	}

	@Override
	public boolean doDumpMetaData(final @NotNull MetaData md)
	{
		return md.name.indexOf("__") == -1;
	}

	@Override
	public void processParameter(@NotNull String name, @Nullable Multiname type, String parentName, @Nullable Multiname value, boolean rest)
	{
		if(rest)
		{
			append("... ");
			append(name);
		}
		else
		{
			append(name);
			append(":");
			processMultinameAsPackageName(type, parentName, true);
			if(value != null)
			{
				processValue(type, value);
			}
		}
	}

	@Override
	public boolean doStarTypeDumpInExtends()
	{
		return false;
	}

	@Override
	public boolean doStarMetaAttrNameDump()
	{
		return false;
	}

	@Override
	public void setProcessingInterface(final boolean anInterface)
	{
		isInterface = anInterface;
	}

	@Override
	public void hasError(@NotNull final String error)
	{
		sb.append("/*" + error + "*/");
	}

	@Override
	public void processMultinameAsPackageName(Multiname name, String parentName, boolean verbose)
	{
		append(getMultinameAsPackageName(name, parentName, verbose));
	}

	protected static String getMultinameAsPackageName(Multiname name, String parentName, boolean verbose)
	{
		if(name.hasNotEmptyNs())
		{
			if(name.hasNamespace() || (!verbose && parentName != null &&
					(parentName.equals(name.nsset[0].replaceAll(":", "::"))) || (parentName != null && parentName.equals(name.toString()))))
			{
				return name.name;
			}

			return name.nsset[0] + "." + name.name;
		}

		return name.toString();
	}

	@Override
	protected String appendModifiers(MemberInfo member, String attr)
	{
		@NonNls String s = attr;

		s += "native ";
		boolean hasNs = false;
		if(member.name != null && member.name.hasNotEmptyNs() && member.name.hasNamespace())
		{
			hasNs = true;
			s += member.name.getNsName() + " ";
		}

		if(s.indexOf("private") == -1 && !hasNs && !isInterface)
		{
			@NonNls String parentName;

			if(member.isPublic ||
					member.name.nsset[0].length() == 0 ||
					(member.parentTraits != null && ((parentName = member.parentTraits.name.toString()).equals(member.name.toString()) || parentName.startsWith
							("script"))))
			{
				s += "public ";
			}
			else
			{
				s += "protected ";
			}
		}

		if(member.isFinal)
		{
			s += "final ";
		}
		if(member.isOverride)
		{
			s += "override ";
		}
		return s;
	}

	@Override
	public void processFunction(MethodInfo methodInfo, boolean referenceNameRequested, Abc abc, String indent, String attr)
	{
		super.processFunction(methodInfo, referenceNameRequested, abc, indent, attr);
		append(";\n");
	}

	@Override
	public void processVariable(SlotInfo info, String indent, String attr)
	{
		super.processVariable(info, indent, attr);
		append(";\n");
	}

	@Override
	protected boolean dumpRestParameter()
	{
		return true;
	}
}

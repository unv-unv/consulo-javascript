package com.intellij.lang.javascript.types;

import java.io.IOException;

import com.intellij.lang.javascript.psi.JSParameter;
import com.intellij.lang.javascript.psi.JSStubElementType;
import com.intellij.lang.javascript.psi.stubs.JSParameterStub;
import com.intellij.lang.javascript.psi.stubs.impl.JSParameterStubImpl;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;

/**
 * @author Maxim.Mossienko
 *         Date: Mar 25, 2008
 *         Time: 10:30:07 PM
 */
public class JSParameterElementType extends JSStubElementType<JSParameterStub, JSParameter>
{
	private static final JSStubGenerator<JSParameterStub, JSParameter> ourStubGenerator = new JSStubGenerator<JSParameterStub, JSParameter>()
	{
		@Override
		public JSParameterStub newInstance(final StubInputStream dataStream, final StubElement parentStub, final JSStubElementType<JSParameterStub,
				JSParameter> elementType) throws IOException
		{
			return new JSParameterStubImpl(dataStream, parentStub, elementType);
		}

		@Override
		public JSParameterStub newInstance(final JSParameter psi, final StubElement parentStub, final JSStubElementType<JSParameterStub,
				JSParameter> elementType)
		{
			return new JSParameterStubImpl(psi, parentStub, elementType);
		}
	};

	public JSParameterElementType()
	{
		super("FORMAL_PARAMETER", ourStubGenerator);
	}
}

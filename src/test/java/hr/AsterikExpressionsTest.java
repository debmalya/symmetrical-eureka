package hr;

import org.junit.Assert;
import org.junit.Test;

public class AsterikExpressionsTest {

	@Test
	public void testEvaluateExpressions() {
		Assert.assertEquals("Syntax Error", AsterikExpressions.evaluateExpressions("3***4"));
		Assert.assertEquals("960", AsterikExpressions.evaluateExpressions("3*2**3**2*5"));
		Assert.assertEquals("Syntax Error", AsterikExpressions.evaluateExpressions("*3*2**3**2*5"));
		Assert.assertEquals("Syntax Error", AsterikExpressions.evaluateExpressions("3*2**3**2*5*"));
		Assert.assertEquals("Syntax Error", AsterikExpressions.evaluateExpressions("3*2***3**2*5*"));
	}

}

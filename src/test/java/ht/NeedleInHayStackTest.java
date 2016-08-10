package ht;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NeedleInHayStackTest {

	@Test
	public void testNeedleInHayStack() {
		List<String> actual = NeedleInHayStack.needleInHayStack("na", "banananobano", 2);
		Assert.assertArrayEquals(new String[]{"2","4"}, actual.toArray(new String[0]));
		
		actual = NeedleInHayStack.needleInHayStack("foobar", "foo", 6);
		Assert.assertArrayEquals(new String[]{""}, actual.toArray(new String[0]));
		
		actual = NeedleInHayStack.needleInHayStack("foobarfoo", "barfoobarfoobarfoobarfoobarfoo", 9);
		Assert.assertArrayEquals(new String[]{"3","9","15","21"}, actual.toArray(new String[0]));
	}

}

package ht;

import static org.junit.Assert.*;

import org.junit.Test;

public class NeedleInHayStackTest {

	@Test
	public void testNeedleInHayStack() {
		NeedleInHayStack.needleInHayStack("na", "banananobano", 2);
		NeedleInHayStack.needleInHayStack("foobar", "foo", 6);
		NeedleInHayStack.needleInHayStack("foobarfoo", "barfoobarfoobarfoobarfoobarfoo", 9);
	}

}

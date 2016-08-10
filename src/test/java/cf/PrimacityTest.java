package cf;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class PrimacityTest {

	@Test
	public void testGetPrimeFactors() {
		Primacity p = new Primacity();
		Set<Integer> actual = p.getPrimeFactors(10);
		Set<Integer> expected = new HashSet<>();
		expected.add(2);
		expected.add(5);
		Assert.assertEquals(expected, actual);

		actual = p.getPrimeFactors(12);
		expected = new HashSet<>();
		expected.add(2);
		expected.add(3);
		Assert.assertEquals(expected, actual);
		
		actual = p.getPrimeFactors(15);
		expected = new HashSet<>();
		expected.add(3);
		expected.add(5);
		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void testLuckyAndPrime2(){
		Primacity p = new Primacity();
		int actual = p.luckyandprime2(5, 15, 2);
		Assert.assertEquals(5, actual);
		
		actual = p.luckyandprime2(2, 10, 1);
		Assert.assertEquals(7, actual);
	}

}

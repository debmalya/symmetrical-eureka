package hr;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PresidentialGalaTest {

	@Test
	public void testConnect() {
		int[] population = new int[] { 8, 5, 2, 5, 3 };
		PresidentialGala gala = new PresidentialGala(5, 6, population);
		PresidentialGala.connect(1, 2);
		PresidentialGala.connect(1, 5);
		PresidentialGala.connect(2, 5);
		PresidentialGala.connect(2, 3);
		PresidentialGala.connect(2, 4);
		PresidentialGala.connect(3, 4);

		Assert.assertTrue(PresidentialGala.isConnected(1, 2));
		Assert.assertTrue(PresidentialGala.isConnected(1, 3));
		Assert.assertFalse(PresidentialGala.isConnected(1, 4));
		Assert.assertTrue(PresidentialGala.isConnected(1, 5));

		Assert.assertTrue(PresidentialGala.isConnected(2, 1));
		Assert.assertTrue(PresidentialGala.isConnected(2, 3));
		Assert.assertTrue(PresidentialGala.isConnected(2, 4));
		Assert.assertTrue(PresidentialGala.isConnected(2, 5));

		Assert.assertFalse(PresidentialGala.isConnected(3, 1));
		Assert.assertTrue(PresidentialGala.isConnected(3, 2));
		Assert.assertTrue(PresidentialGala.isConnected(3, 4));
		Assert.assertFalse(PresidentialGala.isConnected(3, 3));
		Assert.assertTrue(PresidentialGala.isConnected(3, 5));

		Assert.assertFalse(PresidentialGala.isConnected(4, 1));
		Assert.assertTrue(PresidentialGala.isConnected(4, 2));
		Assert.assertTrue(PresidentialGala.isConnected(4, 3));
		Assert.assertFalse(PresidentialGala.isConnected(4, 4));
		Assert.assertTrue(PresidentialGala.isConnected(4, 5));

		Assert.assertTrue(PresidentialGala.isConnected(5, 1));
		Assert.assertTrue(PresidentialGala.isConnected(5, 2));
		Assert.assertTrue(PresidentialGala.isConnected(5, 3));
		Assert.assertFalse(PresidentialGala.isConnected(5, 4));
		Assert.assertFalse(PresidentialGala.isConnected(5, 5));
		
		long[] v = PresidentialGala.getCityWiseMaxPopulation();
		Arrays.sort(v);
		Assert.assertEquals(13, v[v.length - 1]);
	}
	
	@Test
	public void testConnect1() {
		int[] population = new int[] { 8, 5, 2, 3, 5 };
		PresidentialGala gala = new PresidentialGala(5, 6, population);
		PresidentialGala.connect(3, 4);

		long[] v = PresidentialGala.getCityWiseMaxPopulation();
		Arrays.sort(v);
		Assert.assertEquals(21, v[v.length - 1]);


	}

	@Test
	public void testExample2(){
		int[] population = new int[] { 8, 6, 4, 6, 7, 3, 10, 2, 3, 8 };
		PresidentialGala gala = new PresidentialGala(10, 15, population);
		
		
		PresidentialGala.connect(2, 1);
		PresidentialGala.connect(3, 1);
		PresidentialGala.connect(4, 2);
		PresidentialGala.connect(5, 1);
		PresidentialGala.connect(6, 4);
		PresidentialGala.connect(7, 6);
		PresidentialGala.connect(8, 1);
	    PresidentialGala.connect(9, 2);
		PresidentialGala.connect(10, 1);
		PresidentialGala.connect(7, 1);
		PresidentialGala.connect(10, 3);
		PresidentialGala.connect(1, 6);
		PresidentialGala.connect(8, 6);
		PresidentialGala.connect(1, 7);
		PresidentialGala.connect(3, 5);
		
			
		long[] v = PresidentialGala.getCityWiseMaxPopulation();
		Arrays.sort(v);
		Assert.assertEquals(36, v[v.length - 1]);
		
		
	}

	private long[] printPopulaion() {
		long[] v;
		v = PresidentialGala.getCityWiseMaxPopulation();
		System.out.println(Arrays.toString(v));
		return v;
	}
	
	@Test
	public void testExample3(){
		int[] population = new int[] { 3, 1, 7, 2, 6, 6, 5, 8, 7, 6 };
		PresidentialGala gala = new PresidentialGala(10, 14, population);
		
		PresidentialGala.connect(2, 1);
		PresidentialGala.connect(3, 2);
		PresidentialGala.connect(4, 1);
		PresidentialGala.connect(5, 4);
		PresidentialGala.connect(6, 3);
		PresidentialGala.connect(7, 5);
		PresidentialGala.connect(8, 2);
		PresidentialGala.connect(9, 3);
		PresidentialGala.connect(10, 8);
		PresidentialGala.connect(8, 1);
		PresidentialGala.connect(5, 6);
		PresidentialGala.connect(6, 5);
		PresidentialGala.connect(5, 3);
		PresidentialGala.connect(9, 6);
		
		long[] v = PresidentialGala.getCityWiseMaxPopulation();
		Arrays.sort(v);
		Assert.assertEquals(22, v[v.length - 1]);
		
		
	}
}

package codility;



import org.junit.Assert;
import org.junit.Test;


public class NiceliumTest {

	@Test
	public void testSolution() {
		boolean[] arr = new boolean[]{true,false,false,false};
		Assert.assertEquals(4, Nicelium.solution(arr));
		
		arr = new boolean[]{true,false,false,true};
		Assert.assertEquals(7, Nicelium.solution(arr));
		
		arr = new boolean[]{true,false,false,true,false};
		Assert.assertEquals(11, Nicelium.solution(arr));
		
		arr = new boolean[]{true};
		Assert.assertEquals(1, Nicelium.solution(arr));
		
		arr = new boolean[]{true,true,true};
		Assert.assertEquals(6, Nicelium.solution(arr));
		
		arr = new boolean[20];
		for (int i = 0; i < 20; i++){
			arr[i] = true;
		}
		Assert.assertEquals(210, Nicelium.solution(arr));
		
		arr = new boolean[]{true,true,false,false,false};
		Assert.assertEquals(9, Nicelium.solution(arr));
		
	}

}

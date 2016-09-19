/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hr;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class GravityTreeTest {

	/**
	 * Test method for {@link hr.GravityTree#createTree(int[])}.
	 */
	@Test
	public void testCreateTree() {
		
		Map<Integer, List<Integer>> gravityMap = GravityTree.createTree(new int[]{1,2,2,4});
		Assert.assertNotNull(gravityMap);
		Assert.assertTrue(gravityMap.get(1).contains(2));
		Assert.assertTrue(gravityMap.get(2).contains(3));
		Assert.assertTrue(gravityMap.get(2).contains(4));
		Assert.assertTrue(gravityMap.get(4).contains(5));
		System.out.println(gravityMap);
		System.out.println(GravityTree.getChildMap());
		
		int actual = GravityTree.getResult(gravityMap,2,1);
		Assert.assertEquals(7, actual);
		System.out.println(gravityMap);
		System.out.println(GravityTree.getChildMap());
		
		actual = GravityTree.getResult(gravityMap,1,4);
		Assert.assertEquals(13, actual);
		System.out.println(gravityMap);
		System.out.println(GravityTree.getChildMap());
		
		gravityMap = GravityTree.createTree(new int[]{1,2,2,4,5});
		actual = GravityTree.getResult(gravityMap,1,4);
		Assert.assertEquals(29, actual);
		System.out.println(gravityMap);
		System.out.println(GravityTree.getChildMap());
		
		gravityMap = GravityTree.createTree(new int[]{1,2,2,4,5,6});
		actual = GravityTree.getResult(gravityMap,1,4);
		Assert.assertEquals(54, actual);
		System.out.println(gravityMap);
		System.out.println(GravityTree.getChildMap());
	}

}

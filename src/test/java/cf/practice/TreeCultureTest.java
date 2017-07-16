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
package cf.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class TreeCultureTest {
	
	TreeCulture tc = new TreeCulture();
	Tree<Integer> t = new Tree<>(4);
	
	@Before
	public void setUP() {
		t.left = new Tree<>(1);
		t.left.left = new Tree<>(-2);
		t.left.left.right = new Tree<>(3);
		
		t.right = new Tree<>(3);
		t.right.left = new Tree<>(1);
		t.right.right=new Tree<>(2);
		t.right.right.right = new Tree<>(-3);
		t.right.right.left = new Tree<>(-2);
	}
	
 
	/**
	 * Test method for {@link cf.practice.TreeCulture#hasPathWithGivenSum(cf.practice.Tree, int)}.
	 */
	@Test
	public void testHasPathWithGivenSum() {
		
		Assert.assertTrue(tc.hasPathWithGivenSum(t, 7));
		
		t = new Tree<>(8);
		t.right = new Tree<>(3);
		Assert.assertTrue(tc.hasPathWithGivenSum(t, 11));
		
		t = null;
		Assert.assertTrue(tc.hasPathWithGivenSum(t, 0));
		
		t = null;
		Assert.assertFalse(tc.hasPathWithGivenSum(t, 1));
		
		t = new Tree<>(5);
		Assert.assertTrue(tc.hasPathWithGivenSum(t, 5));
		
		t = new Tree<>(8);
		t.right = new Tree<>(3);
		Assert.assertFalse(tc.hasPathWithGivenSum(t, 8));
	
	}
	
	@Test
	public void testSumTree() {
		t = new Tree<>(8);
		t.right = new Tree<>(3);
		Assert.assertEquals(11,tc.sumTree(t));
		
		t.left = new Tree<>(4);
		Assert.assertEquals(15,tc.sumTree(t));
		
		t = t.left;
		Assert.assertEquals(4,tc.sumTree(t));
	}

}

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
package hr.cracking.coding.interview;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class IsThisBinarySearchTreeTest {
	
	private static Node root = new Node();
	
	
	@BeforeClass
	public static void setUp(){
		root.data = 3;
		root.left = new Node();
		root.left.data = 5;
	}

	/**
	 * Test method for {@link hr.cracking.coding.interview.IsThisBinarySearchTree#checkBST(hr.cracking.coding.interview.Node)}.
	 */
	@Test
	public void testCheckBST() {
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
		root.right = new Node();
		root.right.data = 2;
		
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
		root = new Node();
		root.data = 3;
		root.left= new Node();
		root.left.data = 2;
		
		root.right = new Node();
		root.right.data = 5;
		Assert.assertTrue(IsThisBinarySearchTree.checkBST(root));
		
		root.left.left = new Node();
		root.left.left.data = 4;
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
		root = new Node();
		root.data = 2;
		root.left = new Node();
		root.left.data = 2;
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
		root = new Node();
		root.data = 2;
		root.left = new Node();
		root.left.data = 1;
		Assert.assertTrue(IsThisBinarySearchTree.checkBST(root));
		
		root = new Node();
		root.data = 2;
		root.left = new Node();
		root.left.data = 1;
		root.left.left = new Node();
		root.left.left.data = 1;
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
		root = new Node();
		root.data = 2;
		root.left = new Node();
		root.left.data = 1;
		root.right = new Node();
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
		root = new Node();
		root.data = 2;
		root.left = new Node();
		root.left.data = 1;
		root.right = new Node();
		root.right.data = 2;
		Assert.assertFalse(IsThisBinarySearchTree.checkBST(root));
		
	}
	
	@Test
	public void testRandomTree() {
		root = new Node();
		root.data = (int)Math.random()*1000;
	}
	

}

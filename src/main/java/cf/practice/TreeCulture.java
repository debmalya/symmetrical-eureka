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

/**
 * @author debmalyajash
 *
 */
public class TreeCulture {

	/**
	 * Given a binary tree t and an integer s, determine whether there is a root
	 * to leaf path in t such that the sum of vertex values equals s.
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * t = { "value": 4, "left": { "value": 1, "left": { "value": -2, "left":
	 * null, "right": { "value": 3, "left": null, "right": null } }, "right":
	 * null }, "right": { "value": 3, "left": { "value": 1, "left": null,
	 * "right": null }, "right": { "value": 2, "left": { "value": -2, "left":
	 * null, "right": null }, "right": { "value": -3, "left": null, "right":
	 * null } } } } and s = 7, the output should be hasPathWithGivenSum(t, s) =
	 * true.
	 * 
	 * This is what this tree looks like:
	 * 
	 * 4 / \ 1 3 / / \ -2 1 2 \ / \ 3 -2 -3 Path 4 -> 3 -> 2 -> -2 gives us 7,
	 * the required sum.
	 * 
	 * For
	 * 
	 * t = { "value": 4, "left": { "value": 1, "left": { "value": -2, "left":
	 * null, "right": { "value": 3, "left": null, "right": null } }, "right":
	 * null }, "right": { "value": 3, "left": { "value": 1, "left": null,
	 * "right": null }, "right": { "value": 2, "left": { "value": -4, "left":
	 * null, "right": null }, "right": { "value": -3, "left": null, "right":
	 * null } } } } and s = 7, the output should be hasPathWithGivenSum(t, s) =
	 * false.
	 * 
	 * This is what this tree looks like:
	 * 
	 * 4 / \ 1 3 / / \ -2 1 2 \ / \ 3 -4 -3 There is no path from root to leaf
	 * with the given sum 7.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] tree.integer t
	 * 
	 * A binary tree of integers.
	 * 
	 * Guaranteed constraints: 0 ≤ tree size ≤ 5 · 104, -1000 ≤ node value ≤
	 * 1000.
	 * 
	 * [input] integer s
	 * 
	 * An integer.
	 * 
	 * Guaranteed constraints: -4000 ≤ s ≤ 4000.
	 * 
	 * [output] boolean
	 * 
	 * Return true if there is a path from root to leaf in t such that the sum
	 * of node values in it is equal to s, otherwise return false.
	 * 
	 * @param t
	 * @param s
	 * @return
	 */
	boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
		if (t == null) {
			return s == 0;
		}

		s -= t.value;
		if (t.left != null && t.right != null) {
			return hasPathWithGivenSum(t.left, s) || hasPathWithGivenSum(t.right, s);
		} else if (t.left != null) {
			return hasPathWithGivenSum(t.left, s);
		}
		return hasPathWithGivenSum(t.right, s);
	}

	/**
	 * Given a binary tree t, determine whether it is symmetric around its
	 * center, i.e. each side mirrors the other.
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * t = { "value": 1, "left": { "value": 2, "left": { "value": 3, "left":
	 * null, "right": null }, "right": { "value": 4, "left": null, "right": null
	 * } }, "right": { "value": 2, "left": { "value": 4, "left": null, "right":
	 * null }, "right": { "value": 3, "left": null, "right": null } } } the
	 * output should be isTreeSymmetric(t) = true.
	 * 
	 * Here's what the tree in this example looks like:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 As you can see, it is symmetric.
	 * 
	 * For
	 * 
	 * t = { "value": 1, "left": { "value": 2, "left": null, "right": { "value":
	 * 3, "left": null, "right": null } }, "right": { "value": 2, "left": null,
	 * "right": { "value": 3, "left": null, "right": null } } } the output
	 * should be isTreeSymmetric(t) = false.
	 * 
	 * Here's what the tree in this example looks like:
	 * 
	 * 1 / \ 2 2 \ \ 3 3 As you can see, it is not symmetric.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] tree.integer t
	 * 
	 * A binary tree of integers.
	 * 
	 * Guaranteed constraints: 0 ≤ tree size < 5 · 104, -1000 ≤ node value ≤
	 * 1000.
	 * 
	 * [output] boolean
	 * 
	 * Return true if t is symmetric and false otherwise.
	 * 
	 * 
	 * @param t
	 * @return
	 */
	boolean isTreeSymmetric(Tree<Integer> t) {
		if (t == null) {
			return true;
		}
		if (t != null && ((t.left == null && t.right != null) || (t.left != null && t.right == null))) {
			return false;
		}
		return sumTree(t.left) == sumTree(t.right);
	}
	boolean isTreeSymmetric0(Tree<Integer> t) {
		if (t == null) {
			return true;
		}
		if (t != null && ((t.left == null && t.right != null) || (t.left != null && t.right == null))) {
			return false;
		}
		return isTreeSymmetric(t.left) && isTreeSymmetric(t.right);
	}
	
	/**
	 * 
	 * @param t - Binary Tree whose sum will be calculated.
	 * @return sum of binary tree.
	 */
	public int sumTree(Tree<Integer> t) {
		if (t != null ) {
			return t.value + (t.left != null  ? sumTree(t.left) : 0) + (t.right != null ? sumTree(t.right) : 0);
		} 
		return 0;
	}

}

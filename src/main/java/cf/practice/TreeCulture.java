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

import java.util.Stack;

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
		}else if (t.right == null) {
			return hasPathWithGivenSum(t.left, s);
		}
		return hasPathWithGivenSum(t.right, s);
	}

	boolean hasPathWithGivenSum0(Tree<Integer> t, int s) {
		if (t == null && s == 0) {
			return true;
		} else if (t == null && s != 0) {
			return false;
		} else if (t.value == s && t.left == null && t.right == null) {
			return true;
		}
		return hasPathWithGivenSum(t, s, 0);

	}

	/**
	 * 
	 * @param t
	 *            - tree root
	 * @param s
	 *            - sum to be checked
	 * @param level
	 *            - at which level. This level is added to check the sum is not
	 *            obtained at root level.
	 * @return
	 */
	boolean hasPathWithGivenSum(Tree<Integer> t, int s, int level) {
		if (t != null) {
			return hasPathWithGivenSum(t.left, s - t.value, level++)
					|| hasPathWithGivenSum(t.right, s - t.value, level++);
		} else {
			return s == 0 && level > 1;
		}
	}
}

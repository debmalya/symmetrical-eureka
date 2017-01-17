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

/**
 * @author debmalyajash
 *
 */
public class IsThisBinarySearchTree {

	public static boolean checkBST(Node root) {
		if (root != null) {
			if (root.left != null && root.right != null) {
				if (root.data <= root.left.data || root.data >= root.right.data) {
					return false;
				}
				return checkBST(root.left) && checkBST(root.right);
			} else if (root.left != null) {
				if (root.data <= root.left.data) {
					return false;
				}
				return checkBST(root.left);
			} else if (root.right != null) {
				if (root.data >= root.right.data) {
					return false;
				}
				return checkBST(root.right);
			}
		}
		return true;
	}

}

/**
 * Copyright 2015-2017 Debmalya Jash
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
package amazed;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class NodeTest {

	static Node node = new Node();

	@BeforeClass
	public static void setUp() {
		node.data = 4;
		Node.Insert( node, 2 );
		Node.Insert( node, 7 );
		Node.Insert( node, 1 );
		Node.Insert( node, 3 );
		Node.Insert( node, 6 );
	}

	/**
	 * Test method for {@link amazed.Node#Insert(amazed.Node, int)}.
	 */
	@Test
	public void testInsert() {
		
	}

	/**
	 * Test method for {@link amazed.Node#lca(amazed.Node, int, int)}.
	 */
	@Test
	public void testLca() {
		Assert.assertEquals( 4, Node.lca(node,1,7).data);
		Assert.assertEquals( 4, Node.lca(node,7,1).data);
		Assert.assertEquals( 2, Node.lca(node,3,1).data);
		Assert.assertEquals( 2, Node.lca(node,1,3).data);
	}

}

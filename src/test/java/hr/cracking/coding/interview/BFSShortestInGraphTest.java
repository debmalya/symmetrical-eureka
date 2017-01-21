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


import hr.cracking.coding.interview.BFSShortestInGraph.Graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class BFSShortestInGraphTest {

	@Test
	public final void testAddToGraph() {
		Graph graph = new Graph(4, 2);
		graph.connect(0, 1);
		graph.connect(0, 2);
		Assert.assertEquals("6 6 -1", graph.getDistanceFromNode(0));
		Assert.assertEquals("6 12 -1", graph.getDistanceFromNode(1));
		Assert.assertEquals("6 12 -1", graph.getDistanceFromNode(2));
		Assert.assertEquals("-1 -1 -1", graph.getDistanceFromNode(3));
	}
	
	@Test
	public final void testShortestReach(){
		Graph graph = new Graph(4, 2);
		graph.connect(0, 1);
		graph.connect(0, 2);
		Assert.assertArrayEquals(new int[]{0,6,6,-1}, graph.shortestReach(0));
		Assert.assertArrayEquals(new int[]{6,0,12,-1}, graph.shortestReach(1));
		Assert.assertArrayEquals(new int[]{6,12,0,-1}, graph.shortestReach(2));
		Assert.assertArrayEquals(new int[]{-1,-1,-1,0}, graph.shortestReach(3));
	}

}

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
import org.junit.Test;

import hr.cracking.coding.interview.BFSShortestReachInGraph.Graph;

/**
 * @author debmalyajash
 *
 */
public class BFSShortestReachInGraphTest {

	/**
	 * Test method for
	 * {@link hr.cracking.coding.interview.BFSShortestReachInGraph#getShortestDistance(boolean[][], int)}
	 * .
	 */
	

	@Test
	public void testAdd() {
		Graph graph = new Graph(4);
		graph.connect(0, 1);
		graph.connect(0, 2);
		Assert.assertTrue(graph.adjacencyList.get(0).contains(1));
		Assert.assertTrue(graph.adjacencyList.get(1).contains(0));
		Assert.assertFalse(graph.adjacencyList.get(3).contains(1));

		Assert.assertTrue(graph.adjacencyList.get(0).contains(2));
		Assert.assertTrue(graph.adjacencyList.get(2).contains(0));
		Assert.assertFalse(graph.adjacencyList.get(2).contains(3));

		Assert.assertFalse(graph.adjacencyList.get(3).contains(2));
		Assert.assertFalse(graph.adjacencyList.get(3).contains(0));
		Assert.assertFalse(graph.adjacencyList.get(3).contains(1));

	}

	@Test
	public void testShortestDistance() {
		Graph graph = new Graph(4);
		graph.connect(0, 1);
		graph.connect(0, 2);
		int[] distances = new int[] { 0, 6, 6, -1 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(0));

		graph = new Graph(4);
		graph.connect(0, 1);
		graph.connect(1, 3);
		distances = new int[] { 0, 6, -1, 12 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(0));
		
		graph = new Graph(4);
		graph.connect(0, 1);
		graph.connect(1, 2);
		distances = new int[] { 0, 6, 12, -1 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(0));
		
		graph = new Graph(4);
		graph.connect(0, 1);
		graph.connect(1, 2);
		graph.connect(2, 3);
		distances = new int[] { 0, 6, 12, 18 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(0));
		
		graph = new Graph(4);
		graph.connect(0, 1);
		graph.connect(2, 3);
		distances = new int[] { 0, 6, -1, -1 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(0));
		distances = new int[] { 6, 0, -1, -1 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(1));
		distances = new int[] { -1, -1, 0, 6 };
		Assert.assertArrayEquals(distances, graph.getShortestDistance(2));

	}

}

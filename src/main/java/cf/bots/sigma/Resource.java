package cf.bots.sigma;

import java.util.ArrayList;
import java.util.List;

/**
 * A new data resource was recently added to the network, and your job is to
 * establish a connection between it and Two Sigma's server. Due to security
 * reasons, all connections in Two Sigma's network are unidirectional (i.e. only
 * have a one-way connection), and no data can be stored on any node of the
 * network. This means that every second the amount of data a node receives
 * should be equal to the amount of data it forwards. The only exceptions to
 * this rule are resource and server, since the former only sends data while the
 * latter only receives it.
 * 
 * Unfortunately, some segments of the network are slower than is ideal due to
 * limitations with legacy telecommunication operators around the world. This
 * complicates finding the optimal route through the network significantly,
 * which is why your help is required.
 * 
 * Find a route between the resource and the server that maximizes the amount of
 * data downloaded in a second, and return this maximum value.
 * 
 * @author debmalyajash
 *
 */
public class Resource {

	/**
	 * For resource = 4, server = 5 and
	 * 
	 * network = [[0, 2, 4, 8, 0, 0], [0, 0, 0, 9, 0, 0], [0, 0, 0, 0, 0, 10],
	 * [0, 0, 6, 0, 0, 10], [10, 10, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]] the output
	 * should be dataRoute(resource, server, network) = 19.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Resource res = new Resource();
		res.dataRoute(4, 5, new int[][] { { 0, 2, 4, 8, 0, 0 }, { 0, 0, 0, 9, 0, 0 }, { 0, 0, 0, 0, 0, 10 },
				{ 0, 0, 6, 0, 0, 10 }, { 10, 10, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } });

	}

	/**
	 * 
	 * @param resource
	 *            - A 0-based index of the resource node. Constraints: 0 ≤
	 *            resource ≤ 15.
	 * @param server
	 *            - A 0-based index of the server node.
	 * 
	 *            Constraints: 0 ≤ server ≤ 15, server ≠ resource.
	 * @param network
	 *            - A square matrix of non-zero elements. network[i][j]
	 *            corresponds to the maximum amount of data that can be
	 *            transfered from the ith to the jth node in one second, in
	 *            megabytes.
	 * 
	 *            Note that although all connections go only one way, there can
	 *            be two routes between two nodes a and b, one transferring data
	 *            from a to b and another one from b to a.
	 * 
	 *            Constraints: 2 ≤ network.length ≤ 15, network[i].length =
	 *            network.length, 0 ≤ network[i][j] ≤ 10**5, network[i][i] = 0.
	 * 
	 * 
	 * @return - The maximum amount of data that can be transferred in one
	 *         second, in megabytes.
	 */
	int dataRoute(int resource, int server, int[][] network) {

		// Except resource / server , row / column for others total row[i] =
		// total col[i]
		int minRowActiveCount = Integer.MAX_VALUE;
		int minRowIndex = 0;
		int min = 0;
		for (int row = 0; row < network.length; row++) {
			int rowCount = 0;
			int sum = 0;
			for (int col = 0; col < network.length; col++) {
				if (network[row][col] != 0) {
					rowCount++;
					sum += network[row][col];
				}
			}
			if (rowCount < minRowActiveCount && rowCount != 0) {
				minRowActiveCount = rowCount;
				minRowIndex = row;
				min = sum;
			}
		}

		int minColIndex = -9;
		for (int col = 0; col < network.length; col++) {
			int rowCount = 0;
			int sum = 0;
			for (int row = 0; row < network.length; row++) {
				if (network[row][col] != 0) {
					rowCount++;
					sum += network[row][col];
				}
			}
			if (rowCount < minRowActiveCount && rowCount != 0) {
				minRowActiveCount = rowCount;
				minColIndex = col;
				min = sum;
			}
		}

		if (minColIndex > -9) {
			// Column wise
		} else {
			// Row wise
			// Have to make sum of total column value equal to minimum row
			// value.
			makeMinimum(network, minRowIndex, true, min);
		}
		return 0;
	}

	/**
	 * 
	 * @param network
	 * @param minRowIndex
	 * @param isRow
	 * @param maxPossibleFrequency
	 */
	private void makeMinimum(int[][] network, int minRowIndex, boolean isRow, int maxPossibleFrequency) {
		if (isRow) {
			// have to neutralize column
			for (int row = 0; row < network.length; row++) {

			}
		} else {
			// have to neutralize row.
		}

	}

	/**
	 * 
	 * @param network
	 *            details
	 * @param node
	 *            source of transmission.
	 * @param receivingStrength
	 *            other than resource and server everybody should send and
	 *            receive same strength can not store anything.
	 * 
	 *            For server and resource this value will be -1.
	 */
	public void getNextLayer(int[][] network, int node, int receivingStrength, int from) {
		for (int i = 0; i < network.length; i++) {
			if (network[node][i] != 0) {
				if (receivingStrength != -1) {
					// cannot store any thing
					normalize(network, i, receivingStrength, from);
				}
				getNextLayer(network, i, network[node][i], node);
			}
		}
	}

	/**
	 * Normalize the node so that whatever it receive will transmit.
	 * 
	 * @param network
	 *            details
	 * @param receivingStrength
	 * @param from
	 *            - coming from which node
	 */
	public void normalize(int[][] network, int node, int receivingStrength, int from) {
		int transmittingStrength = 0;
		List<Integer> indexes = new ArrayList<Integer>();
		int activeNodeCount = 0;
		for (int i = 0; i < network.length; i++) {
			if (network[node][i] > 0) {
				transmittingStrength += network[node][i];
				indexes.add(i);
				activeNodeCount++;
			}
		}

		if (transmittingStrength > receivingStrength) {
			for (int i = 0; i < indexes.size(); i++) {
				if (transmittingStrength - network[node][indexes.get(i)] == receivingStrength) {
					network[node][indexes.get(i)] = 0;
					break;
				}
			}
		}

		if (receivingStrength > transmittingStrength) {
			if (activeNodeCount == 1) {
				network[from][node] = transmittingStrength;
			}
		}
	}

}

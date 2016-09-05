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
		int maxPossibleSpeed = res.dataRoute(4, 5, new int[][] { { 0, 2, 4, 8, 0, 0 }, { 0, 0, 0, 9, 0, 0 },
				{ 0, 0, 0, 0, 0, 10 }, { 0, 0, 6, 0, 0, 10 }, { 10, 10, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } });
		System.out.println(maxPossibleSpeed);

		maxPossibleSpeed = res.dataRoute(2, 5,
				new int[][] { { 0, 0, 0, 0, 2, 0, 998, 0, 0, 0, 0 }, { 1000, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0 },
						{ 0, 1239, 0, 1111, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 587, 439, 0, 0 },
						{ 0, 0, 0, 0, 0, 1001, 3, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 239 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 890, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 2, 0, 485, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 932 },
						{ 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0 } });

		System.out.println(maxPossibleSpeed);
		
		maxPossibleSpeed = res.dataRoute(0, 3,
				new int[][]{{0,1000,1000,0}, 
				            {0,0,1000,1}, 
				            {0,1,0,1000}, 
				            {0,0,0,0}});
		System.out.println(maxPossibleSpeed);
		
		maxPossibleSpeed = res.dataRoute(0, 3,
				new int[][]{{0,7,5,0}, 
				            {0,0,2,5}, 
				            {0,1,0,4}, 
				            {0,0,0,0}});
		System.out.println(maxPossibleSpeed);
		
		maxPossibleSpeed = res.dataRoute(0, 3,
				new int[][]{{0,7,5,0,0}, 
				            {0,0,2,3,0}, 
				            {0,1,0,4,1}, 
				            {0,0,0,0,0},
				            {0,0,0,2,0}});
		System.out.println(maxPossibleSpeed);

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
	public int dataRoute(int resource, int server, int[][] network) {

		// Except resource / server, After balancing, for others row / column
		// total of row[i] =
		// total of column[i]
		int noOfNodes = network.length;
		int[] outgoingSpeed = new int[noOfNodes];
		int[] incomingSpeed = new int[noOfNodes];

		calculateInOut(network, outgoingSpeed, incomingSpeed);

		// Balance the resource node, maximum possible outgoing speed is maximum
		// possible download speed of the server. As in between nodes cannot
		// store anything.
		int maxResourceSpeed = 0;
		for (int col = 0; col < network.length; col++) {
			if (network[resource][col] != 0) {
				// Have some connectivity
				// Check maximum possible outgoing speed from resource to
				// node(col)
				//
				maxResourceSpeed += Math.min(outgoingSpeed[col], network[resource][col]);
			}
		}
		
		int maxServerSpeed = 0;
		for (int row = 0; row < network.length; row++){
			if (network[row][server] != 0){
				maxServerSpeed += Math.min(incomingSpeed[row], network[row][server]);
			}
		}

		return Math.min(maxResourceSpeed, maxServerSpeed);
	}

	/**
	 * During network balancing, incoming and outgoing speed will be modified
	 * for the nodes. Transfer speed between nodes will change. This method will
	 * recalculate the incoming and outgoing speed.
	 * 
	 * @param network
	 *            array.
	 * @param outgoingSpeed
	 *            maximum possible outgoing speed of the node.
	 * @param incomingSpeed
	 *            - maximum possible incoming speed.
	 */
	public void calculateInOut(int[][] network, int[] outgoingSpeed, int[] incomingSpeed) {
		for (int row = 0; row < network.length; row++) {
			for (int col = 0; col < network.length; col++) {
				outgoingSpeed[row] += network[row][col];
				incomingSpeed[col] += network[row][col];
			}
		}
	}

	
}

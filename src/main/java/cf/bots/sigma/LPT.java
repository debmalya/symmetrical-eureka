package cf.bots.sigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Two Sigma engineers process large amounts of data every day, much more than
 * any single server could possibly handle. Their solution is to use collections
 * of servers, or server farms, to handle the massive computational load.
 * Maintaining the server farms can get quite expensive, and because each server
 * farm is simultaneously used by a number of different engineers, making sure
 * that the servers handle their backlogs efficiently is critical.
 * 
 * Your goal is to optimally distribute a list of jobs between servers within
 * the same farm. Since this problem cannot be solved in polynomial time, you
 * want to implement an approximate solution using the Longest Processing Time
 * (LPT) algorithm. This approach sorts the jobs by their associated processing
 * times in descending order and then assigns them to the server that's going to
 * become available next. If two operations have the same processing time the
 * one with the smaller index is listed first. If there are several servers with
 * the same availability time, then the algorithm assigns the job to the server
 * with the smallest index.
 * 
 * Given a list of job processing times, determine how the LPT algorithm will
 * distribute the jobs between the servers within the farm.
 * 
 * Example
 * 
 * For jobs = [15, 30, 15, 5, 10] and servers = 3, the output should be
 * 
 * serverFarm(jobs, servers) = [[1], [0, 4], [2, 3]] job with index 1 goes to
 * the server with index 0; job with index 0 goes to server 1; job with index 2
 * goes to server 2; server 1 is going to be available next, since it got the
 * job with the shortest processing time (15). Thus job 4 goes to server 1;
 * finally, job 3 goes to server 2. Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.integer jobs
 * 
 * Unsorted array of positive integers representing the processing times of the
 * given jobs.
 * 
 * Constraints: 0 ≤ jobs.length ≤ 100, 1 ≤ jobs[i] ≤ 1000.
 * 
 * [input] integer servers
 * 
 * Constraints: 1 ≤ servers ≤ 20.
 * 
 * [output] array.array.integer
 * 
 * Array consisting of job indices grouped by which server they were run on. The
 * ith row should contain 0-based indices of the jobs that were run on the ith
 * server in the order of processing.
 * 
 * 
 * @author debmalyajash
 *
 */
public class LPT {

	public static void main(String[] args) {
		LPT lpt = new LPT();
		int[][] r = lpt.serverFarm(new int[] { 15, 30, 15, 5, 10 }, 3);

		for (int i = 0; i < r.length; i++) {
			System.out.println(Arrays.toString(r[i]));
		}

	}

	int[][] serverFarm(int[] jobs, int servers) {
		boolean[] b = new boolean[jobs.length];
		// get the longest job.
		int[] allocation = new int[servers];
		int jobsAllocted = 0;
		int jobIndex = -1;
		int serverIndex = 0;
		List<Integer>[] serv = new ArrayList[servers];
		while (jobsAllocted < jobs.length) {
			// get next longest duration job.
			int m = 0;
			jobIndex = -1;

			for (int i = 0; i < jobs.length; i++) {
				if (!b[i] && jobs[i] > m) {
					m = jobs[i];
					jobIndex = i;
				}
			}

			b[jobIndex] = true;
			if (serv[serverIndex % servers] == null) {
				serv[serverIndex % servers] = new ArrayList<Integer>();
			}
			serv[serverIndex].add(jobIndex);
			allocation[serverIndex % servers] += jobs[jobIndex];

			jobsAllocted++;
			if (jobsAllocted >= servers) {
				// server that's going to become available next.
				int min = Integer.MAX_VALUE;
				for (int a = 0; a < servers; a++){
					if (allocation[a] < min){
						min = allocation[a];
						serverIndex = a;
					}
				}
			} else {
				serverIndex++;
			}
		}

		int[][] r = new int[servers][];

		for (int i = 0; i < servers; i++) {
			r[i] = new int[0];
			if (serv[i] != null) {
				r[i] = new int[serv[i].size()];
				for (int j = 0; j < serv[i].size(); j++) {
					r[i][j] = serv[i].get(j);
				}
			}

		}
		return r;

	}

	int[][] serverFarm0(int[] jobs, int servers) {
		Arrays.sort(jobs);
		List<List<Integer>> sa = new ArrayList<>(servers);

		int count = 0;
		for (int i = jobs.length - 1; i > -1; i--, count++) {
			int si = count % servers;
			if (count >= servers) {
				// have to start in the reverse order of server.
				si = servers - si - 1;
			}
			List<Integer> each = null;
			if (sa.size() > si) {
				each = sa.get(si);
			} else {
				each = new ArrayList<>();
			}

			each.add(si);
			if (sa.size() > si) {
				sa.set(si, each);
			} else {
				sa.add(each);
			}
		}

		int[][] r = new int[servers][];
		for (int i = 0; i < sa.size(); i++) {
			r[i] = new int[sa.get(i).size()];
			for (int j = 0; j < sa.get(i).size(); j++) {
				r[i][j] = sa.get(i).get(j);
			}
		}
		return r;

	}
}

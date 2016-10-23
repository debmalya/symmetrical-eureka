package hr;

import java.util.Arrays;
import java.util.Scanner;

public class PresidentialGala {

	private static boolean[][] neighbors;

	private static int[] population;

	private static long[] cityWiseMaxPopulation;

	public static long[] getCityWiseMaxPopulation() {
		return cityWiseMaxPopulation;
	}

	// private static City[] cities;

	/**
	 * In a country with n cities (1 to n) , connected by m bidirectional roads.
	 * It is possible to travel any city from other city. Two cities are
	 * considered to be neighbors if there is a road directly connecting them.
	 * 
	 * The country's President is hosting a gala and wants to make sure it goes
	 * off without a hitch while inviting as many citizens as possible. To
	 * mitigate the risk of any conflict between party guests, she wants to be
	 * sure to not invite people from neighboring cities due to their
	 * deep-seated dislike of one another.
	 * 
	 * Given a map of the country, help the President choose a set of cities to
	 * invite to the gala such that nobody from neighboring cities is invited
	 * and the number of attendees is maximal. Print the maximum possible number
	 * of invited guests as your answer.
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains two space-separated integers describing
			// the
			// respective values of n (the number of cities) and m (the number
			// of
			// roads connecting the cities).
			int n = in.nextInt();
			int m = in.nextInt();
			neighbors = new boolean[n][n];

			// The second line contains space-separated integers describing the
			// respective populations of each city (i.e.,p(i) , where is the
			// population of city (i) ).
			population = new int[n];

			long totalPopulation = 0;
			for (int i = 0; i < n; i++) {
				population[i] = in.nextInt();
				totalPopulation += population[i];
			}

			cityWiseMaxPopulation = new long[n];
			for (int i = 0; i < n; i++) {
				cityWiseMaxPopulation[i] = totalPopulation;
			}

			// Each line of the subsequent lines contains two space-separated
			// integers, u and v, describing an undirected road directly
			// connecting cities u and v.

			for (int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				connect(u, v);

			}

			Arrays.sort(cityWiseMaxPopulation);
			System.out.println(cityWiseMaxPopulation[cityWiseMaxPopulation.length - 1]);
		}

	}

	public static void connect(int u, int v) {

		if (!neighbors[u - 1][v - 1]) {
			cityWiseMaxPopulation[u - 1] -= population[v - 1];
			neighbors[u - 1][v - 1] = true;
		}

		if (!neighbors[v - 1][u - 1]) {
			cityWiseMaxPopulation[v - 1] -= population[u - 1];
			neighbors[v - 1][u - 1] = true;
		}

		for (int row = 0; row < neighbors.length; row++) {
			if (!neighbors[row][u - 1] && !neighbors[row][v - 1]) {
				if (population[u - 1] < population[v - 1]) {
					cityWiseMaxPopulation[row] -= population[u - 1];
					neighbors[row][u - 1] = true;

				} else {
					cityWiseMaxPopulation[row] -= population[v - 1];
					neighbors[row][v - 1] = true;
				}
			}
		}

	}

	public static boolean isConnected(int u, int v) {
		return neighbors[u - 1][v - 1];
	}

	public PresidentialGala(int numberOfCities, int numberOfConnections, int[] cityPopulations) {
		neighbors = new boolean[numberOfCities][numberOfCities];
		population = new int[numberOfCities];
		cityWiseMaxPopulation = new long[numberOfCities];

		long totalPopulation = 0;

		for (int cityIndex = 0; cityIndex < numberOfCities; cityIndex++) {
			population[cityIndex] = cityPopulations[cityIndex];
			totalPopulation += cityPopulations[cityIndex];
		}

		for (int i = 0; i < numberOfCities; i++) {
			cityWiseMaxPopulation[i] = totalPopulation;
		}

	}

}

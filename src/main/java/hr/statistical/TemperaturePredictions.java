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
package hr.statistical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a record containing the maximum and minimum monthly temperatures at a
 * particular station. The record shows the temperature information for each
 * month in a data range from January 1908 to March 2012; however, some of the
 * temperature values have been blanked out! Estimate and print the missing
 * values.
 * 
 * @author debmalyajash
 *
 */
public class TemperaturePredictions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains an integer,N , denoting the number of
			// rows of data in the input file.
			int n = in.nextInt();

			// The second line contains the header for the tab-separated
			// file; this line can be ignored, and is simply there to make
			// the test case easier to read.
			in.nextLine();

			List<String[]> recordList = new ArrayList<>();
			List<Integer> missingRowList = new ArrayList<>();
			Map<String,List<double[]>> monthTemperatureMap = new HashMap<>();
			for (int i = 0; i < n; i++) {

				// The subsequent N lines each describe the respective
				// year,month, maximum temperature, and minimum temperature
				// data as a row of tab-separated values.
				String[] eachLineValues = in.nextLine().split("\t");

				// In some of the rows, The or temperature field has been
				// blanked out and replaced by: Missing_1, Missing_2, etc.
				boolean isMissing = false;
				if (eachLineValues[2].contains("Missing") || eachLineValues[3].contains("Missing")){
					isMissing = true;
				} else {
					List<double[]> monthValues = monthTemperatureMap.get(eachLineValues[1]);
					if (monthValues == null) {
						monthValues = new ArrayList<>();
					}
					double[] minMax = new double[2];
					minMax[0] = Double.parseDouble(eachLineValues[2]);
					minMax[1] = Double.parseDouble(eachLineValues[3]);
					monthValues.add(minMax);
					
					monthTemperatureMap.put(eachLineValues[1],monthValues);
				}
				
				
				if (isMissing){
					missingRowList.add(i);
				}
				recordList.add(eachLineValues);
			}
			
			for (int i = 0; i < missingRowList.size(); i++){
				String[] missingValues = recordList.get(missingRowList.get(i));
				List<double[]> monthValues = monthTemperatureMap.get(missingValues[1]);
				int index = missingValues[2].contains("Missing") ? 0 : 1;
				
				double total = 0.00d;
				int count = 0;
				for (double[] eachReading: monthValues){
					total += eachReading[index];
					count++;
				}
				System.out.println((total/count));
			}
		}
	}

}

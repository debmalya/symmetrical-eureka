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
package hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author debmalyajash
 *
 */
public class ElectronicShop {

	/**
	 * Story : Monica wants to buy one keyboard and one USB drive from her
	 * favorite electronics store. The store sells different n brands of
	 * keyboards and m different brands of USB drives. Monica has exactly s
	 * dollars to spend, and she wants to spend as much of it as possible (i.e.,
	 * the total cost of her purchase must be maximal).
	 * 
	 * Given the price lists for the store's keyboards and USB drives, find and
	 * print the amount money Monica will spend. If she doesn't have enough
	 * money to buy one keyboard and one USB drive, print -1 instead.
	 * 
	 * Note: She will never buy more than one keyboard and one USB drive even if
	 * she has the leftover money to do so.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains three space-separated integers describing
			// the respective values of s (the amount of money Monica has), n
			// (the
			// number of keyboard brands) and m (the number of USB drive
			// brands).
			int s = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();

			// The second line contains n space-separated integers denoting the
			// prices of each keyboard brand.
			int[] keyBoardPrices = new int[n];
			for (int i = 0; i < n; i++) {
				keyBoardPrices[i] = in.nextInt();
			}

			// The third line contains m space-separated integers denoting the
			// prices of each USB drive brand.
			int[] usbDrivePrices = new int[m];
			for (int i = 0; i < m; i++) {
				usbDrivePrices[i] = in.nextInt();
			}

			int amount = getPrice(s, keyBoardPrices, usbDrivePrices);
		}

	}

	/**
	 * @param s
	 *            money can use for spending.
	 * @param keyBoardPrices
	 *            all the key board prices.
	 * @param usbDrivePrices
	 *            all the usb drive prices.
	 * @return amount can be used for purchase, -1 if money is not enough to
	 *         purchase anything.
	 */
	public static int getPrice(int s, int[] keyBoardPrices,
			int[] usbDrivePrices) {
		int spentAmount = 0;
		// Prepare a list of prices which are affordable (less than the amount
		// have)
		List<Integer> affordableKeyBoardPrice = new ArrayList<>();
		List<Integer> affordableUsbDrivePrice = new ArrayList<>();

		int maxKeyBoardPrice = 0;
		int minKeyBoardPrice = Integer.MAX_VALUE;

		int maxUsbDrivePrice = 0;
		int minUsbDrivePrice = Integer.MAX_VALUE;

		for (int i = 0; i < keyBoardPrices.length; i++) {
			if (keyBoardPrices[i] <= s) {
				affordableKeyBoardPrice.add(keyBoardPrices[i]);
				if (keyBoardPrices[i] > maxKeyBoardPrice) {
					maxKeyBoardPrice = keyBoardPrices[i];
				} else if (keyBoardPrices[i] < minKeyBoardPrice) {
					minKeyBoardPrice = keyBoardPrices[i];
				}
			}
		}

		for (int i = 0; i < usbDrivePrices.length; i++) {
			if (usbDrivePrices[i] <= s) {
				affordableUsbDrivePrice.add(usbDrivePrices[i]);
			}
			if (usbDrivePrices[i] > maxUsbDrivePrice) {
				maxUsbDrivePrice = usbDrivePrices[i];
			} else if (usbDrivePrices[i] < minUsbDrivePrice) {
				minUsbDrivePrice = usbDrivePrices[i];
			}
		}

		int addedAmount = 0;

		if (maxKeyBoardPrice > maxUsbDrivePrice) {
			spentAmount = maxKeyBoardPrice;

			for (int i = 0; i < affordableUsbDrivePrice.size(); i++) {
				if (affordableUsbDrivePrice.get(i) + spentAmount <= s) {
					addedAmount = affordableUsbDrivePrice.get(i);
				}
			}

		} else {
			spentAmount = maxUsbDrivePrice;
			for (int i = 0; i < affordableKeyBoardPrice.size(); i++) {
				if (affordableKeyBoardPrice.get(i) + spentAmount <= s) {
					addedAmount = affordableKeyBoardPrice.get(i);
				}
			}
		}

		if (addedAmount + spentAmount  != 0 && addedAmount > 0){
			return addedAmount + spentAmount;
		}
		return -1;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author debmalyajash
 */
public class CodeFighter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sumOfThrees("4"));
        System.out.println(sumOfThrees("84"));
        System.out.println(sumOfThrees("531441"));
        System.out.println(sumOfThrees("2"));
        System.out.println(sumOfThrees("5"));
        
         for (int i = 1; i < 14; i++) {
            System.out.println(i + " gamma :" + gamma(i));
        }

    }

    public static String sumOfThrees(String n) {
        long m = Long.parseLong(n);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        while (m > 0) {

            long r = m % 3;
            if (r == 2) {
                return "Impossible";
            } else if (r != 0) {
                s.push(i);
            }
            i++;

            m /= 3;
        }

        while (!s.isEmpty()){
            sb.append(3).append("^").append(s.pop()).append("+");
        }
        return sb.toString().substring(0,sb.length()-1);

    }

    /**
     * This was a reverse challenge.
     * @param n - number of term.
     * @return value of the nth term.
     */
    public static int gamma(int n) {
        return (n == 1) ? 1 : (n - 1) * gamma(n - 1);
    }
    
    /**
     * Checking whether a Sudoku is correct or not.
     * @param s solved Sudoku.
     * @return true if it is correct, false otherwise.
     */
    public static boolean Sudoku(int[][] s) {
        if (s.length == 9) {
            int[] sumb = new int[9];
            for (int i = 0; i < s.length; i++) {
                int sum_h = 0;
                int sum_v = 0;
                for (int j = 0; j < s[i].length; j++) {
                    int v = s[i][j];
                    sum_h += v;
                    sum_v += s[j][i];
                    if (i >= 0 && i <= 2){
                        if (j >= 0 && j <=2) {
                            sumb[0] += v;
                        }else if (j >= 3 && j <=5) {
                            sumb[1] += v;
                        }else if (j >= 6 && j <=8) {
                            sumb[2] += v;
                        }
                    } else if (i >= 3 && i <= 5){
                        if (j >= 0 && j <=2) {
                            sumb[3] += v;
                        }else if (j >= 3 && j <=5) {
                            sumb[4] += v;
                        }else if (j >= 6 && j <=8) {
                            sumb[5] += v;
                        }
                    }else if (i >= 6 && i <= 8){
                        if (j >= 0 && j <=2) {
                            sumb[6] += v;
                        }else if (j >= 3 && j <=5) {
                            sumb[7] += v;
                        }else if (j >= 6 && j <=8) {
                            sumb[8] += v;
                        }
                    }
                    
                }
                if (sum_h != 45 || sum_v != 45) {
                    return false;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (sumb[i] != 45){
                    return false;
                }
                System.out.println(sumb[i]);
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * 1 ≤ a.length ≤ 150.
     * 1 ≤ b.length ≤ 150.
     * 
     * Return their multiplicatoin in modulo 10.
     * */
    int modulo10(String a, String b) {
      return new BigInteger(a).multiply(new BigInteger(b)).mod(BigInteger.TEN).intValue();
    }
    
    /**
     * Find the missing power of 2.
     * */
    public int powersOfTwo(int k, int n, int[] arr) {
      Arrays.sort(arr);
      for (int i = 0; i <= k; i++) {
           int j = (int)Math.pow(2,i);
          if (Arrays.binarySearch(arr,j) < 0){
             return j;
        }
    }
    return 1;
}

    public static void calculateLibraryFine() {
		try (Scanner scanner = new Scanner(System.in)) {
			String[] actuals = scanner.nextLine().split(" ");
			String[] expecteds = scanner.nextLine().split(" ");

			int d1 = 0;
			int d2 = 0;
			int m1 = 0;
			int m2 = 0;
			int y1 = 0;
			int y2 = 0;

			d1 = Integer.parseInt(actuals[0]);
			d2 = Integer.parseInt(expecteds[0]);
			
			m1 = Integer.parseInt(actuals[1]);
			m2 = Integer.parseInt(expecteds[1]);
			
			y1 = Integer.parseInt(actuals[2]);
			y2 = Integer.parseInt(expecteds[2]);
			
			if (d1 <= d2 && m1 <= m2 && y1 <= y2 ){
				System.out.println("0");
			} else if (y1 > y2) {
				System.out.println("10000");
			} else if (y1 <= y2 && m1 > m2) {
				System.out.println(500 * (m1 - m2));
			} else if (y1 <= y2 && m1 <= m2 && d1 > d2) {
				System.out.println(15 * (d1 - d2));
			}

		}
	}
	
	public static int Password(String word) {        
       
        	String w = word + word;
        	int l = word.length();
        	int r = 0;
        	String min = word;

        	for (int i = 0; i < l; i++) {
           		String t = w.substring(i, i + l);
           		if (t.compareTo(min) < 0) {
               			min = t;
               			r = i;
           		}
           
        	}  
        return r;

    }
    
    /**
	 * An arbitrage is the simultaneous purchase and sale of an asset in order
	 * to profit from a difference in the price. This type of trade exploits
	 * price differences between similar or identical financial instruments,
	 * either on different markets or in different forms. You are a currency
	 * trader looking for arbitrage opportunities in the currency market using
	 * these three quotes:
	 * 
	 * 1 . The cost of USD per EUR (USD/EUR) for converting USD -> EUR. 2 . The
	 * cost of EUR per GBP (EUR/GBP) for converting EUR -> GBP. 3 . The cost of
	 * GBP per USD (GBP/USD) for converting GBP -> USD.
	 * 
	 * You must use your USD to buy EUR, then use your EUR to buy GBP, and
	 * finally use your GBP to buy USD, resulting in some sort of profit or loss
	 * (i.e., USD->EUR->GBP->USD). Reverse trading is not allowed, so you are
	 * limited to the 3 exchanges in the direction shown above. For example, you
	 * can convert USD->EUR, which means selling US Dollars and buying Euros;
	 * you cannot invert the fraction to sell Euros and buy US Dollars. Given
	 * 100,000 USD for each trade, calculate the arbitrage profit truncated to
	 * whole dollars (USD); otherwise, print if there is no arbitrage
	 * opportunity.
	 * 
	 * Input format The first line contains a single integer, N, denoting the
	 * number of quotes. Each of the N subsequent lines describes a quote in the
	 * form of three space-separated integers: 1. The first quote is a real
	 * number denoting the price quote for (USD/EUR). 2. The second quote is a
	 * real number denoting the price quote for (EUR/GBP). 3. The third quote is
	 * a real number denoting the price quote for (GBP/USD).
	 * 
	 * Constraints 1 <= N <= 100 0.001 < quotes <= 1000
	 * 
	 * Output Format For each trade, print a single line denoting the arbitrage
	 * profit for that trade; if no arbitrage opportunity exists, print 0. You
	 * should have a total of N lines of output.
	 * 
	 * Sample Input 2 1.1837 1.3829 0.6102 1.1234 1.2134 1.2311
	 * 
	 * Sample Output 114 0
	 * 
	 * 
	 * Explanation There are 2 test cases. N = 2.
	 * 
	 * 1. You use your 100,000 USD to buy 84,480.8651 EUR. You then use your
	 * 84,480.8651 EUR to buy 61,089.6414 GBP. Finally, you use your 61,089.6414
	 * GBP to buy USD. Because we started out with 100,000 USD, our net profit
	 * in whole dollars is 114 USD. 2. There is no arbitrage opportunity here
	 * (the conversion would end up losing money), so we print 0.
	 * 
	 * 
	 * 
	 */
	public static void calculateArbritage() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			int[] r = new int[t];
			for (int i = 0; i < t; i++) {
				Double usdToEur = scanner.nextDouble();
				Double eurToGbp = scanner.nextDouble();
				Double gbpToUsd = scanner.nextDouble();

				Double capital = 100000.00d;

				Double eur = capital / usdToEur;
				Double gbp = eur / eurToGbp;
				Double usd = gbp / gbpToUsd;

				double arbritage = usd - capital;
				if (arbritage > 0.00d) {
					r[i] = (int) (Math.round(arbritage * 10000) / 10000);
				} else {
					r[i] = 0;
				}
			}

			for (int i = 0; i < t; i++) {
				System.out.println(r[i]);
			}
		}
	}
	
    /**
     * Given two strings, your task is to find out if there is a swap sequence that transforms the first string into 
     * the second string. A swap sequence is a sequence of strings, such that for each two consecutive string the one 
     * can be obtained from another after a swap of two characters in one of the strings.
     * @param a first string.
     * @param b second string.
     * @return true if a swap sequence exists and false otherwise.
     **/
    public boolean swapSequence(String a, String b) {
       	 char[] c = a.toCharArray();
       	 char[] d = b.toCharArray();
    
    	Arrays.sort(c);
    	Arrays.sort(d);
    
    	return Arrays.equals(c,d);
    }

}

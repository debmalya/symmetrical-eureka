/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf;

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
}

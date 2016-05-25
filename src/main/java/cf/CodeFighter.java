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
}

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
}

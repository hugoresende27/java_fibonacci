/**
 * performance (end 100) 1sec 474ms
 */
package com.hr.fibonacci.backend;

import java.math.BigInteger;

public class FibonacciV3 {
    // Returns n-th Fibonacci number
    public static BigInteger fib(int n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j = 2; j <= n; j++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return (b);
    }

    public static void main(String[] args) {
        int n = 100;
//        System.out.println("Fibonacci of " + n +
//                "th term" + " " + "is" + " " + fib(n));

        printFibo(0,n);
    }

    public static void printFibo(int start, int end){
        for (int i = start ; i <= end ; i++){
            System.out.println(fib(i));
        }
    }
}
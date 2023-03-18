package com.hr.fibonacci.backend;

import java.math.BigInteger;

/**
 * In mathematics, the Fibonacci sequence is a sequence in which each number is the sum of the two preceding ones.
 * Individual numbers in the Fibonacci sequence are known as Fibonacci numbers, commonly denoted
 * The sequence commonly starts from 0 and 1, although some authors start the sequence
 * from 1 and 1 or sometimes (as did Fibonacci) from 1 and 2. Starting from 0 and 1,
 * the first few values in the sequence are:[1]
 *     0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144.
 *  ------------------------------------------------
 * This fibonacci class use an array, long[] fibonacciCache to store the previous
 * fibonacci sequence number
 * This way we don't have to calculate the previous fibonacci number every iteration
 * performance (end in 40) 1sec and 511ms
 */
public class Fibonacci {

    public static long[] fibonacciCache;


    public Fibonacci() {

    }

    public static void main(String[] args) {

        int start = 40;
        int end = 60;   //max of long for fibonacci element is 90 , 9 zilion something

//        fibonacciCache = new long[end + 1];   //save precious number of fibonacci seq in a var named cache,
                                              //always last number + 1

        System.out.println("INDEXES: "+start+": "+end+ " -> " + printFiboIndexes(start, end));
        System.out.println("MIN-MAX: "+start+": "+end + " -> " +printFiboLimits(start, end));

    }

    /**
     * need a base case to stop execution
     * n(0) = 0 and n(1) = 1
     * An alternate way to print the Fibonacci series  using memoization :
     * In above example, Its time complexity is O(2n)  which can reduce to O(n)
     * using the memoization technique it will help to optimize recursion method.
     * This is because the function computes each Fibonacci number only once and stores it in the array.
     */
    public static long fibonnacci(int n){
        if ( n <= 1){
            return n;
        }

        if (fibonacciCache[n] != 0){    //if cache != 0 already stored elements in cache

            return fibonacciCache[n];   //if fibo number already in cache, use it
        }
        long nFibonacciNumber = (fibonnacci(n-1) + fibonnacci(n-2));
        fibonacciCache[n] = nFibonacciNumber;
        return nFibonacciNumber;
    }

    /**
     *  using BigInteger , if 0 return 0, if 1 return 1
     *  for loop, starting in 2 finish in n
     *  c equals to a + b, previous elements
     *  a assumes b value
     *  b assumes c value
     *  b is always the end of the fibo sequente atm
     *   Initialize the first and second numbers to 0 and 1.
     *   Following this, we print the first and second numbers.
     *   Then we send the flow to the iterative while loop
     *   where we get the next number by adding the previous two numbers and simultaneously
     *   we swap the first number with the second and the second with the third.
     *   Below is the implementation of the above approach:
     */
    public static BigInteger fibonnacci2(int n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        if (n == 0){
            return a;
        } else if(n == 1){
            return b;
        }
        //  fib[i] = fib[i-1] + fib[i-2];
        for (int j = 2; j <= n; j++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return (b);
    }

    public static void printFibo(int start, int end){
        for (int i = start ; i <= end ; i++){
            System.out.println(fibonnacci2(i)); //fibonacci2 uses a loop to return max fibo value of seq
        }
    }



    /*
        print fibonacci sequence between indexes passed
     */
    public static String printFiboIndexes(int start, int end) {
        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {

            res.append(" ").append(fibonnacci2(i)).append(" "); //fibonacci2 uses a loop to return max fibo value of seq

        }

        return res.toString();
    }


    /*
        print fibonacci sequence between max and min limits passed
     */
    public static String printFiboLimits(int start, int end) {
        StringBuilder res = new StringBuilder();

        //loop fibonacci sequence between 0 and 1000
        for (int i = 0; i <= 1000; i++) {

            //init BigInts
            BigInteger fiboVal = fibonnacci2(i);
            BigInteger s = BigInteger.valueOf(start);
            BigInteger e = BigInteger.valueOf(end);

            //BigInts compareTo ( > 0 bigger, 0 equal, < 0 smaller)
            int compareValueS = fiboVal.compareTo(s);
            int compareValueE = fiboVal.compareTo(e);

            //if start bigger then fibo val and end smaller then fibo val
            if (compareValueS > 0 && compareValueE < 0){
                //append fibo values between limits
                res.append(" ").append(fiboVal).append(" ");
            }


        }

        return res.toString();
    }


}

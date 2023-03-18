package com.hr.fibonacci.backend;

/**
 *  * This way i can only max about 40
 *  * performance (end in 40) 1sec and 388ms
 *  */

public class FibonacciV2 {

    public static void main(String[] args) {

        long n1 = 0 , n2 = 1 , sum = 0 , end = 90;

        System.out.println(n1 + " " + n2);

        for (long i = 2 ; i < end ; i ++){
            sum = n1 + n2; // 0 + 1 = 1
            System.out.println(" "+ sum); //  1 2 3
            n1 = n2; // n2 = 1
            n2 = sum;//sum = 1
        }
    }
}

package com.hr.fibonacci.backend;

import java.math.BigInteger;

public class FiboFinal {


    public static BigInteger fibonnacci(int n) {
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

    /*
    print fibonacci sequence between indexes passed
 */
    public static String printFiboIndexes(int start, int end) {
        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {

            res.append(" ").append(fibonnacci(i)).append(" "); //fibonacci2 uses a loop to return max fibo value of seq

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
            BigInteger fiboVal = fibonnacci(i);
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

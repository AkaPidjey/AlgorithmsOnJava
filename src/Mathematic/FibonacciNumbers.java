package Mathematic;

import java.util.Scanner;

/**
 * @title: FibonacciNumber
 * @author PJ
 * @since 21/05/2020
 * @task Дано целое число 1 <= n <= 40, необходимо вычислить n-е число Фибоначчи
 * (напомним, что F[0]=0, F[1]=1 и F[n]=F[n−1]+F[n−2] при n >= 2).
 */

class FibonacciNumbers {
    public static int fibonacciV1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciV1(n - 2) + fibonacciV1(n - 1);
    }

    public static int fibonacciV2(int n) {
        int[] inM = new int[n + 1];
        inM[0] = 0;
        inM[1] = 1;
        for (int a = 2; a <= n; a++) {
            inM[a] = (inM[a - 1] + inM[a - 2]);
        }
        return inM[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long startTime1 = System.currentTimeMillis();
        System.out.println(fibonacciV1(n));
        long finishTime1 = System.currentTimeMillis();
        System.out.println("Run Time Version #1 = " + (finishTime1 - startTime1) + " ms");
        long startTime2 = System.currentTimeMillis();
        System.out.println(fibonacciV2(n));
        long finishTime2 = System.currentTimeMillis();
        System.out.println("Run Time Version #2 = " + (finishTime2 - startTime2) + " ms");
    }

}
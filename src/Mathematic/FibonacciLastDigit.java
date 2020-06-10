package Mathematic;

import java.util.Scanner;

/**
 * @title: FibonacciLastDigit
 * @author PJ
 * @since 21/05/2020
 * @task Дано число 1 <= n <= 10^7, необходимо найти последнюю цифру n-го числа Фибоначчи.
 * Как мы помним, числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным с переполнением.
 * В данной задаче, впрочем, этой проблемы можно избежать, поскольку нас интересует только последняя цифра числа Фибоначчи: если 0 <= a, b <= 9,
 * a,b — последние цифры чисел F[i] и F[i+1] соответственно, то (a+b)mod10 — последняя цифра числа F[i+2].
 * Sample Input:
 * 696352
 * Sample Output:
 * 9
 */

public class FibonacciLastDigit {

    public static int fibonacciLastDigitV1(int n) {
        int[] inM = new int[n + 1];
        inM[0] = 0;
        inM[1] = 1;
        for (int a = 2; a <= n; a++) {
            inM[a] = (inM[a - 1] + inM[a - 2]) % 10;
        }
        return inM[n];
    }

    public static int fibonacciLastDigitV2(int n) {
        int f1 = 0, f2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int f3 = (f1 + f2) % 10;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long startTime1 = System.currentTimeMillis();
        System.out.println(fibonacciLastDigitV1(n));
        long finishTime1 = System.currentTimeMillis();
        System.out.println("Run Time Version #1 = " + (finishTime1 - startTime1) + " ms");
        long startTime2 = System.currentTimeMillis();
        System.out.println(fibonacciLastDigitV2(n));
        long finishTime2 = System.currentTimeMillis();
        System.out.println("Run Time Version #2 = " + (finishTime2 - startTime2) + " ms");
    }

}

package Mathematic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: FibonacciPisanoPeriods
 * @author PJ
 * @since 26/05/2020
 * @task Даны целые числа 1 <= n <= 10^18 и 2 <= m <= 10^5, необходимо найти остаток от деления nn-го числа Фибоначчи на m.
 * Sample Input:
 * 10 2
 * Sample Output:
 * 1
 */

public class FibonacciPisanoPeriods {

    public static int  fibonacciPisanoPeriodsV1(int n, int m) {
        int itog = n % m;
        int p;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);

        for (int a = 2; a < n; a++) {
            result.add((result.get(a - 1) + result.get(a - 2)) % m);
            if (result.get(a) == 1 && result.get(a - 1) == 0) {
                p = result.size() - 2;
                itog = result.get(n % p);
                break;
            }
        }
        return itog;
    }




    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        long startTime1 = System.currentTimeMillis();
        System.out.println(fibonacciPisanoPeriodsV1(n, m));
        long finishTime1 = System.currentTimeMillis();
        System.out.println("Run Time Version #1 = " + (finishTime1 - startTime1) + " ms");
    }

}
package Mathematic;

import java.util.Scanner;

/**
 * Title: GreatestSequenceTimeSubsequence.
 * @Eng - GreatestSequenceTimeSubsequence.
 * @Rus - Задача на программирование: наибольшая последовательнократная подпоследовательность.
 * @author PJ
 * @since 05/07/2020
 * @version 1.0
 * @task Дано целое число 1 <= n <= 10^3 и массив A[1…n] натуральных чисел, не превосходящих 2*10^9.
 * Выведите максимальное 1 <= k <= n, для которого найдётся подпоследовательность 1 <= i1 <= i2 <= ... <= ik <= n
 * длины k, в которой каждый элемент делится на предыдущий (формально: для  всех 1 <= j < k, A[ij] | A[ij+1])
 * Sample Input:
 * 4
 * 3 6 7 12
 * Sample Output:
 * 3
 */

public class GreatestSequenceTimeSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i] && a[i] % a[j] == 0 && (d[j] + 1) > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = 0;
        for (int element : d) {
            if (element > max) {
                max = element;
            }
        }
//        for (int element : a) {
//            System.out.print(element + " ");
//        }
//        System.out.println(" ");
//        for (int element : d) {
//            System.out.print(element + " ");
//        }

        System.out.println(max);
    }
}

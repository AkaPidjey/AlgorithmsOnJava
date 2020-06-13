package Mathematic;

import java.io.IOException;
import java.util.Scanner;

/**
 * Title - NumberOfInversions.
 * @Eng - NumberOfInversions.
 * @Rus - Задача на программирование: число инверсий.
 * @author PJ
 * @since 13/06/2020
 * @version 1.0
 * @task Первая строка содержит число 1 <= n <= 10^5 , вторая — массив A[1…n], содержащий натуральные числа,
 * не превосходящие 10^9. Необходимо посчитать число пар индексов 1 <= i < j <= n, для которых A[i]>A[j].
 * (Такая пара элементов называется инверсией массива. Количество инверсий в массиве является в некотором
 * смысле его мерой неупорядоченности: например, в упорядоченном по неубыванию массиве инверсий нет вообще,
 * а в массиве, упорядоченном по убыванию, инверсию образуют каждые два элемента.)
 * Sample Input:
 * 5
 * 2 3 9 2 9
 * Sample Output:
 * 2
 */

public class NumberOfInversions {

    private int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];
        for (int k = 0; k < res.length; k++) {
            if (j == b.length || (i < a.length && a[i] <= b[j])) {
                res[k] = a[i];
                i++;
            } else {
                count += a.length - i;
                res[k] = b[j];
                j++;
            }
        }
        return res;
    }

    long count = 0;

    private int[] mergeSort(int[] a) {
        if (a.length == 1) { return a; }
        int n = a.length;
        int m = n / 2;
        int[] left = new int[m];
        int[] right = new int[n - m];
        System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, (n - m));
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private void run() {
/*        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }


 */

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        int[] sortedA = mergeSort(a);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new NumberOfInversions().run();
        long finishTime = System.currentTimeMillis();
        System.out.println("Run Time: " + (finishTime - startTime));
    }
}

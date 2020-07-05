package Mathematic;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: HighestIncreasingSubsequence.
 * @Eng - HighestIncreasingSubsequence.
 * @Rus - Наибольшая возрастающая подпоследовательность.
 * @author PJ
 * @since 05/07/2020
 * @version 1.0
 */

public class HighestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = new int[15];
        int[] d = new int[15];
        int[] prev = new int[15];
        List<Integer> result = new ArrayList<>();
        a[0] = 7;
        a[1] = 2;
        a[2] = 1;
        a[3] = 3;
        a[4] = 8;
        a[5] = 4;
        a[6] = 9;
        a[7] = 1;
        a[8] = 2;
        a[9] = 6;
        a[10] = 5;
        a[11] = 9;
        a[12] = 3;
        a[13] = 8;
        a[14] = 1;

        for (int i = 0; i < a.length; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 1; j < (a.length - 1); j++) {
                if (a[j] < a[i] && (d[j] + 1) > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int max = 0;
        for (int element : d) {
            if (element > max) {
                max = element;
            }
        }

        int index = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] == max) {
                index = i;
                break;
            }
        }

        while (index != -1) {
            result.add(a[index]);
            index = prev[index];
        }

        for (int element : a) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
        for (int element : d) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
        for (int element : prev) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
        System.out.println(max);
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}

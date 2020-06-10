package Mathematic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title: VariousTerms
 * @rus: Различные слагаемые
 * @author PJ
 * @since 30/05/2020
 * @task По данному числу 1 <= n <= 10^9 найдите максимальное число k, для которого n можно представить как сумму k
 * различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
 * Sample Input1:
 * 4
 * Sample Output1:
 * 2
 * 1 3
 * Sample Input2:
 * 6
 * Sample Output2:
 * 3
 * 1 2 3
 */

public class VariousTerms {

    public static void vtV1(int n) {
        int max = 0;
        int count = 0;
        int temp = n;
        ArrayList<Integer> result = new ArrayList<>();

        if (n == 1) {
            max = 1;
            result.add(1);
            System.out.println(max);
            for (int element : result) {
                System.out.print(element + " ");
            }
        } else if (n == 2) {
            max = 1;
            result.add(2);
            System.out.println(max);
            for (int element : result) {
                System.out.print(element + " ");
            }
        } else {
            while (temp >= (count + 1 + count + 2)) {
                count++;
                max++;
                result.add(count);
                temp -= count;
            }
            max++;
            result.add(n - Amount(result));
            System.out.println(max);
            for (int element : result) {
                System.out.print(element + " ");
            }
        }
    }

    public static int Amount(ArrayList<Integer> k) {
        int result = 0;
        for (int a = 0; a < k.size(); a++) {
            result += k.get(a);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.next());
        long startTime1 = System.currentTimeMillis();
        vtV1(n);
        long finishTime1 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Run Time Version #1 = " + (finishTime1 - startTime1) + " ms");
    }
}


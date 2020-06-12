package SearchAndSort;

import java.util.Scanner;

/**
 * Title: BinarySearch.
 * @Eng - BinarySearch.
 * @Rus - Задача на программирование: двоичный поиск.
 * @author PJ
 * @since 12/06/2020
 * @version 1.0
 * @task В первой строке даны целое число 1 <= n <= 10^5 и массив A[1…n] из n различных натуральных чисел,
 * не превышающих 10^9, в порядке возрастания, во второй — целое число 1 <= k <= 10^5 и k натуральных чисел b1,....,bk,
 * не превышающих 10^9. Для каждого i от 1 до k необходимо вывести индекс 1 <= j <= n, для которого A[j]=bi, или -1,
 * если такого j нет.
 * Sample Input:
 * 5 1 5 8 12 13
 * 5 8 1 23 1 11
 * Sample Output:
 * 3 1 -1 1 -1
 */

public class BinarySearch {

    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arreyA = new int[num];
        for (int i = 0; i < num; i++) {
            arreyA[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] arreyB = new int[k];
        for (int i = 0; i < k; i++) {
            arreyB[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int pos = binary_search(arreyA, arreyB[i]);
            System.out.print(pos + " ");
        }
    }

    public static int binary_search(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) >> 1;
            if (list[mid] == item) {
                return mid;                  // для курса степик  -->  return mid + 1;
            } else if (list[mid] > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long finishTime = System.currentTimeMillis();
        System.out.println("Run time: " + (finishTime - startTime) + " ms");
    }
}

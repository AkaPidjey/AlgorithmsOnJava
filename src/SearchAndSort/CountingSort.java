package SearchAndSort;

import java.util.Scanner;

/**
 * Title: CountingSort.
 * @Eng - CountingSort.
 * @Rus - Задача на программирование: сортировка подсчётом .
 * @author PJ
 * @since 03/07/2020
 * @version 1.0
 * @task Первая строка содержит число 1 <= n <= 10^4 , вторая — n натуральных чисел, не превышающих 10.
 * Выведите упорядоченную по неубыванию последовательность этих чисел.
 * Sample Input:
 * 5
 * 2 3 9 2 9
 * Sample Output:
 * 2 2 3 9 9
 */

public class CountingSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        countingSort(input, 10);
    }

    public static int[] countingSort(int[] array, int maxValue) {
        int[] counts = new int[maxValue + 1];
        for (int num : array) {
            counts[num]++;
        }
        int[] sortedArray = new int[array.length];
        int currentSortedIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                sortedArray[currentSortedIndex] = i;
                currentSortedIndex++;
            }
        }
        for (int element : sortedArray) {
            System.out.print(element + " ");
        }
        return sortedArray;
    }
}

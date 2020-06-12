package FrameworkCollections;

import java.util.*;

/**
 * Title: PriorityQueue.
 * @Eng - PriorityQueue.
 * @Rus - Задача на программирование: очередь с приоритетами.
 * @author PJ
 * @since 12/06/2020
 * @version 1.0
 * @task Первая строка входа содержит число операций 1 <= n <= 10^5. Каждая из последующих n строк задают операцию
 * одного из следующих двух типов:
 * - Insert x, где 0 <= x <= 10^9 — целое число;
 * - ExtractMax.
 * Первая операция добавляет число x в очередь с приоритетами, вторая — извлекает максимальное число и выводит его.
 * Sample Input:
 * 6
 * Insert 200
 * Insert 10
 * ExtractMax
 * Insert 5
 * Insert 500
 * ExtractMax
 * Sample Output:
 * 200
 * 500
 */

public class PriorityQueue {
    private void priorityQueueV1() {
        List<Integer> result = new LinkedList<>();
        List<Integer> result2 = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int numberOperation = sc.nextInt();
        for (int i = 0; i < numberOperation; i++) {
            String tempStr = sc.next();
            if (tempStr.contains("Insert")) {
                int tempInt = sc.nextInt();
                result.add(tempInt);
            } else if (tempStr.contains("ExtractMax")) {
                Collections.sort(result);
                result2.add(result.get(result.size() - 1));
                result.remove(result.get(result.size() - 1));
            }
        }
        for (int element : result2) {
            System.out.println(element);
        }
    }

    private void priorityQueueV2() {
        Queue<Integer> queue = new java.util.PriorityQueue<>(11, Collections.reverseOrder());
        List<Integer> result = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int numberOperation = sc.nextInt();
        for (int i = 0; i < numberOperation; i++) {
            String tempStr = sc.next();
            if (tempStr.contains("Insert")) {
                int tempInt = sc.nextInt();
                queue.add(tempInt);
            } else if (tempStr.contains("ExtractMax")) {
                result.add(queue.poll());

            }
        }

        for (int element : result) {
            System.out.println(element);
        }
    }



    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new PriorityQueue().priorityQueueV2();
        long finishTime = System.currentTimeMillis();
        System.out.println("Run time: " + (finishTime - startTime) + " ms");
    }
}

// Queue<Integer> queue = new PriorityQueue<>(Comparator.<Integer>reverseOrder());

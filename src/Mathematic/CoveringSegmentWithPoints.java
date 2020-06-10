package Mathematic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @title: CoveringSegmentWithPoints
 * @rus: Покрытие отрезков точками
 * @author PJ
 * @since 28/05/2020
 * @task По данным nn отрезкам необходимо найти множество точек минимального размера,
 * для которого каждый из отрезков содержит хотя бы одну из точек.
 * В первой строке дано число 1 <= n <= 100 отрезков. Каждая из последующих nn строк
 * содержит по два числа 0 <= l <= r <= 10^9 задающих начало и конец отрезка.
 * Выведите оптимальное число mm точек и сами mm точек. Если таких множеств точек несколько,
 * выведите любое из них.
 * Sample Input1:
 * 3
 * 1 3
 * 2 5
 * 3 6
 * Sample Output1:
 * 1
 * 3
 * Sample Input2:
 * 4
 * 4 7
 * 1 3
 * 2 5
 * 5 6
 * Sample Output2:
 * 2
 * 3 6
 */

public class CoveringSegmentWithPoints {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] data = new int[n][];
        int i = 0;
        for (int c = 0; c < n; c++) {
            int a = Integer.parseInt(s.next());
            int b = Integer.parseInt(s.next());
            data[i++] = new int[]{a, b};
        }
        long startTime1 = System.currentTimeMillis();
        swpV1(data);
        long finishTime1 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Run Time Version #1 = " + (finishTime1 - startTime1) + " ms");
        long startTime2 = System.currentTimeMillis();
        swpV2(n, data);
        long finishTime2 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Run Time Version #2 = " + (finishTime2 - startTime2) + " ms");

    }

    public static int swpV1(int[][] data) {
        Arrays.sort(data,(o1, o2) -> {
            int v = o1[1] - o2[1];
            return v != 0 ? v : o1[0] - o2[0];
        });

        String[] res = cover(data);
        System.out.println(res.length);
        for (int a = 0; a < res.length; a++) {
            System.out.print(res[a] + " ");
        }
        return res.length;
    }

    public static String[] cover(int[][] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = arr.length; i < l ; i++ ) {
            int point = arr[i][1];
            for (int j = i ; j < l && point <= arr[j][1] && point >= arr[j][0] ; j++) {
                i = j;
            }
            sb.append(point).append(" ");

        }
        return sb.toString().split(" ");
    }

    public static int swpV2(int n, int[][] data) {
        Arrays.sort(data, Comparator.comparingInt(a -> a[1]));

        int points = 0;
        int lastPoint = -1;
        StringBuilder pointsResult = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (lastPoint < data[i][0]) {
                lastPoint = data[i][1];
                points++;
                pointsResult.append(lastPoint).append(" ");
            }
        }
        System.out.println(points);
        System.out.print(pointsResult);
        return points;
    }

}
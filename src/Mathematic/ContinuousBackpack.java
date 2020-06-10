package Mathematic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: ContinuousBackpack
 * @rus: Покрытие отрезков точками.
 * @author PJ
 * @since 29/05/2020
 * @task Первая строка содержит количество предметов 1 <= n <= 10^3 и вместимость рюкзака 0 <= W <= 2 * 10^6
 * Каждая из следующих n строк задаёт стоимость 0 <= c_i <= 2 * 10^6 и объём 0 < w_i <= 2 * 10^6 предмета
 * (n, W, c_i, w_i — целые числа). Выведите максимальную стоимость частей предметов
 * (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
 * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 * Sample Input1:
 * 3 50
 * 60 20
 * 100 50
 * 120 30
 * Sample Output1:
 * 180.000
 */

public class ContinuousBackpack {

    public static class Item implements Comparable<Item> {
        double cost;
        double weight;
        public Item(double cost, double weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {
            double r1 = (double) cost / weight;
            double r2 = (double) o.cost / o.weight;
//            long r1 =(long) cost * o.weight;
//            long r2 = (long) o.cost * weight;
            return -Double.compare(r1, r2);
//            return -Long.compare(r1, r2);
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.next());
        double w = Double.parseDouble(s.next());
        Item[] items = new Item[n];
        for (int c = 0; c < n; c++) {
            double a = Double.parseDouble(s.next());
            double b = Double.parseDouble(s.next());
            items[c] = new Item(a, b);
        }

        long startTime1 = System.currentTimeMillis();
        cbV1(n, w, items);
        long finishTime1 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Run Time Version #1 = " + (finishTime1 - startTime1) + " ms");
    }

    public static double cbV1(int n, double w, Item[] items) {
        Arrays.sort(items);
        double result = 0;
        for (Item item : items) {
            if (item.weight <= w) {
                result += item.cost;
                w -= item.weight;
            } else {
                result += item.cost * (w / item.weight);
                break;
            }
        }
        System.out.println(result);
        return result;
    }


}
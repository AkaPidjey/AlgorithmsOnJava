package Mathematic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Title: GreatestCommonDivisor
 * @Eng - Method that calculates the greatest common divisor.
 * @Rus - Метод который вычисляет наибольший общий делитель.
 * @author PJ
 * @since 17/05/2020
 * @version 1.0
 * @param  input - 2 numbers int.
 * @return - If a number it returns true.
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter 2 numbers");
            String str1 = br.readLine();
            String str2 = br.readLine();
            int count1 = Integer.parseInt(str1);
            int count2 = Integer.parseInt(str2);
            br.close();
            System.out.println("GСD=> " + gсdV1(count1, count2));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Entered an incorrect value");
        }
    }

    public static int gсdV1(int count1, int count2) {
        int gsd = 0;
        int min = 0;

        if (count1 == 0) {
            gsd = count2;
        } else if (count2 == 0) {
            gsd = count1;
        }
        if (count1 > count2) {
            min = count2;
        } else {
            min = count1;
        }

        for (int a = 1; a <= Math.abs(min); a++) {
            if (count1 % a == 0 && count2 % a == 0) {
                gsd = a;
            }
        }
        return gsd;
    }

    public static int gсdV2(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gсdV2(b, a % b);
    }
}

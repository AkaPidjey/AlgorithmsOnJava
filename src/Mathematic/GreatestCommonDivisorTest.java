package Mathematic;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreatestCommonDivisorTest {
    @Test
    public void whenNumbers_1vs10() {
        int input1 = 1;
        int input2 = 10;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 1;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_5vs10() {
        int input1 = 5;
        int input2 = 10;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 5;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_24vs24() {
        int input1 = 24;
        int input2 = 24;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 24;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_0vs0() {
        int input1 = 0;
        int input2 = 0;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 0;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_5vs0() {
        int input1 = 5;
        int input2 = 0;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 5;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_0vs15() {
        int input1 = 0;
        int input2 = 15;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 15;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_m5vs10() {
        int input1 = -5;
        int input2 = 10;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 5;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_m10vs10() {
        int input1 = -10;
        int input2 = 10;
        int result = GreatestCommonDivisor.gсdV1(input1, input2);
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        int expect = 10;
        assertEquals(result, expect);
        assertEquals(result2, expect);
    }
    @Test
    public void whenNumbers_m4vsm2() {
        int input1 = -4;
        int input2 = -2;
        int result1 = GreatestCommonDivisor.gсdV1(input1, input2);
        int expect = 2;
        int result2 = GreatestCommonDivisor.gсdV2(input1, input2);
        assertEquals(result1, expect);
        assertEquals(result2, expect);
    }



}
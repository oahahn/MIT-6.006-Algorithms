package mypackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    void getMax() {
        int[] input1 = {53, 89, 150, 36, 633, 233};
        int expectedResult1 = 633;
        int result1 = RadixSort.getMax(input1);
        int[] input2 = {121, 432, 564, 23, 1, 45, 788};
        int expectedResult2 = 788;
        int result2 = RadixSort.getMax(input2);
        assertAll(() -> assertEquals(result1, expectedResult1),
                () -> assertEquals(result2, expectedResult2));

    }

    @Test
    void countingSort1() {
        int[] result = {53, 89, 150, 36, 633, 233};
        int[] expectedResult = {36, 53, 89, 150, 233, 633};
        RadixSort.countingSort(result);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void countingSort2() {
        int[] result = {121, 432, 564, 23, 1, 45, 788};
        int[] expectedResult = {1, 23, 45, 121, 432, 564, 788};
        RadixSort.countingSort(result);
        assertArrayEquals(expectedResult, result);
    }
}
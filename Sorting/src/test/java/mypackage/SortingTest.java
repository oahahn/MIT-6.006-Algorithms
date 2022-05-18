package mypackage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
//    @DisplayName("List of length 5")
    void selectionSort() {
        int[] result = {8, 2, 4, 9, 3};
        int[] expectedResult = {2, 3, 4, 8, 9};
        Sorting.selectionSort(result);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void insertionSort() {
        int[] result = {2, 8, 5, 3, 9, 4};
        int[] expectedResult = {2, 3, 4, 5, 8, 9};
        Sorting.insertionSort(result);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void merge() {
        int[] L = {1, 5, 6, 7};
        int[] R = {2, 3, 4, 9};
        int[] result = new int[8];
        Sorting.merge(L, R, result, L.length, R.length, 0, 8);
        int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 9};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void mergeSort() {
        int[] result = {7, 1, 5, 6, 2, 4, 9, 3};
        int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 9};
        Sorting.mergeSort(result, 0, result.length);
        assertArrayEquals(expectedResult, result);
    }
}
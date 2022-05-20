package mypackage;

import java.util.Arrays;
import java.util.Collections;
public class RadixSort {

    public static int getMax(int[] arr) {
        int maxValue = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    // Assumes items have non-negative keys
    public static void countingSort(int[] arr, int place) {
        int max = getMax(arr);
        int[] count = new int[max + 1];
        int[] output = new int[arr.length + 1];

        // Initialise count array with all zeros
        for (int i = 0; i < max; i++) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < arr.length; i++) {
            int count_idx = (arr[i] / place) % 10;
            count[count_idx]++;
        }

        // Store the cumulative count of each array
        for (int i = 1; i <= 10; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in the count array
        for (int i = arr.length - 1; i >= 0; i--) {
            int count_idx = (arr[i] / place) % 10;
            int output_idx = count[count_idx] - 1;
            output[output_idx] = arr[i];
            count[count_idx]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }

    public static void main(String[] args) {
        int[] myList = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original list: " + Arrays.toString(myList));
        RadixSort.countingSort(myList, 1);
        System.out.println("Sorted list:   " + Arrays.toString(myList));
    }
}

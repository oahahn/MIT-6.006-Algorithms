package mypackage;
import java.util.Arrays;
import java.lang.Math;

// Example: [8, 2, 4, 9, 3] → [2, 3, 4, 8, 9]
public class Sorting {
    public static int findMax(int[] list) {
        int maxIdx = 0;
        int maxValue = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > maxValue) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void selectionSort(int[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            int[] subList = Arrays.copyOfRange(list, 0, i+1);
            int maxIdx = findMax(subList);
            if (maxIdx != i) {
                list[maxIdx] = subList[i];
                list[i] = subList[maxIdx];
            }
        }
    }
    // 2, 8, 5, 3, 9, 4
    public static void insertionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int j = i;
            while (j > 0 && list[j-1] > list[j]) {
                int tmp = list[j];
                list[j] = list[j-1];
                list[j-1] = tmp;
                j -= 1;
            }
        }
    }

    public static void merge(int[] L, int[] R, int[] A, int i, int j, int a, int b) {
        if (a < b) {
            if ((j <= 0) || (i > 0 && L[i-1] > R[j-1])) {
                A[b - 1] = L[i - 1];
                i -= 1;
            }
            else {
                A[b - 1] = R[j - 1];
                j -= 1;
            }
            merge(L, R, A, i, j, a, b-1);
        }
    }

    public static void mergeSort(int[] list, int a, int b) {
        if (b - a > 1) {
            int c = (int) ((a + b + 1) / 2);
            mergeSort(list, a, c);
            mergeSort(list, c, b);
            int[] L = Arrays.copyOfRange(list, a, c);
            int[] R = Arrays.copyOfRange(list, c, b);
            merge(L, R, list, L.length, R.length, a, b);
        }
    }

    public static void main(String[] args) {
        int[] myList = {2, 8, 5, 3, 9, 4};
        System.out.println("Original list: " + Arrays.toString(myList));
        Sorting.insertionSort(myList);
        System.out.println("Sorted list:   " + Arrays.toString(myList));
    }
}

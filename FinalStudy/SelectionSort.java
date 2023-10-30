package FinalStudy;

import java.util.NoSuchElementException;

public class SelectionSort {

    public static void main(String[] args) {
        // int[] arr = new int[] { 5, 4, 3, 2, 1 };
        // SelectionSort.printArray(arr);
        // SelectionSort.bubbleSort(arr);
        // System.out.println("\n");
        // SelectionSort.printArray(arr);
        // System.out.println(SelectionSort.binarySearch(arr, 4, 0, arr.length-1));
        
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // public static void selectionSort(int[] arr) {
    // for(int i = 0; i < arr.length; i++) {
    // int minIndex = i;
    // for(int j = i+1; j<arr.length; j++) {
    // if(arr[j] < arr[minIndex]) {
    // minIndex = j;
    // }
    // }
    // if(i != minIndex) {
    // int temp = arr[i];
    // arr[i] = arr[minIndex];
    // arr[minIndex] = temp;
    // }
    // }
    // }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean hasSwappped;
        do {
            hasSwappped = false;
            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    // System.out.println("i: " + i + "\nj: " + j);
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        hasSwappped = true;
                    }
                }
            }
        } while (hasSwappped);
    }

    public static int binarySearch(int[] arr, int target, int leftIndex, int rightIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        if (target == arr[middleIndex]) {
            return arr[middleIndex];
        }
        else if(leftIndex == rightIndex) {
            throw new NoSuchElementException("Element not in array");
        }
        else if(target > arr[middleIndex]) {
            return binarySearch(arr, target, middleIndex+1, rightIndex);
        }
        else {
            return binarySearch(arr, target, leftIndex, middleIndex-1);
        }
    }
}

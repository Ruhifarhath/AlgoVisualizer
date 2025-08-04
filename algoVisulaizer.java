package com.tap.algovisual;
import java.util.Arrays;
import java.util.Scanner;

public class AlgoVisualizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== AlgoVisualizer CLI ===");
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();

        while (true) {
            System.out.println("\nChoose an algorithm to visualize:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    visualizeBubbleSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 2:
                    visualizeSelectionSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 3:
                    visualizeInsertionSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 4:
                    System.out.print("Enter target to search: ");
                    int target = sc.nextInt();
                    visualizeLinearSearch(Arrays.copyOf(arr, arr.length), target);
                    break;
                case 5:
                    int[] sortedArr = Arrays.copyOf(arr, arr.length);
                    Arrays.sort(sortedArr);
                    System.out.print("Enter target to search: ");
                    int bTarget = sc.nextInt();
                    visualizeBinarySearch(sortedArr, bTarget);
                    break;
                case 6: 
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void visualizeBubbleSort(int[] arr) {
        System.out.println("\n--- Bubble Sort Visualization ---");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swapping " + arr[j] + " and " + arr[j + 1]);
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    static void visualizeSelectionSort(int[] arr) {
        System.out.println("\n--- Selection Sort Visualization ---");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            System.out.println("Min at position " + minIdx + " (" + arr[minIdx] + "). Swapping with position " + i + " (" + arr[i] + ")");
            int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
            System.out.println("After swap: " + Arrays.toString(arr));
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    static void visualizeInsertionSort(int[] arr) {
        System.out.println("\n--- Insertion Sort Visualization ---");
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; int j = i - 1;
            System.out.println("Inserting " + key);
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; j--;
                System.out.println(Arrays.toString(arr));
            }
            arr[j + 1] = key;
            System.out.println("Inserted: " + Arrays.toString(arr));
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    static void visualizeLinearSearch(int[] arr, int target) {
        System.out.println("\n--- Linear Search Visualization ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Checking index " + i + ": " + arr[i]);
            if (arr[i] == target) {
                System.out.println("Found at index " + i + "!");
                return;
            }
        }
        System.out.println("Target not found.");
    }

    static void visualizeBinarySearch(int[] arr, int target) {
        System.out.println("\n--- Binary Search Visualization (on sorted array) ---");
        System.out.println("Array: " + Arrays.toString(arr));
        int left = 0, right = arr.length - 1;
        int step = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("Step " + step++ + ": left=" + left + ", right=" + right + ", mid=" + mid + " (" + arr[mid] + ")");
            if (arr[mid] == target) {
                System.out.println("Found at index " + mid + "!");
                return;
            }
            if (arr[mid] < target) {
                left = mid + 1;
                System.out.println("Target greater than mid, new left = " + left);
            } else {
                right = mid - 1;
                System.out.println("Target less than mid, new right = " + right);
            }
        }
        System.out.println("Target not found.");
    }
}

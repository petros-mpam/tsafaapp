package com.tsafaapp;
/**
 * Created by kosta on 11/6/2017.
 */

public class SortingActivity {

    //Quick-sort

    public class Quicksort  {
        private int[] numbers;
        private int number;

        public void sort(int[] values) {
            // check for empty or null array
            if (values ==null || values.length==0){
                return;
            }
            this.numbers = values;
            number = values.length;
            quicksort(0, number - 1);
        }

        private void quicksort(int low, int high) {
            int i = low, j = high;
            // Get the pivot element from the middle of the list
            int pivot = numbers[low + (high-low)/2];

            // Divide into two lists
            while (i <= j) {
                // If the current value from the left list is smaller than the pivot
                // element then get the next element from the left list
                while (numbers[i] < pivot) {
                    i++;
                }
                // If the current value from the right list is larger than the pivot
                // element then get the next element from the right list
                while (numbers[j] > pivot) {
                    j--;
                }

                // If we have found a value in the left list which is larger than
                // the pivot element and if we have found a value in the right list
                // which is smaller than the pivot element then we exchange the
                // values.
                // As we are done we can increase i and j
                if (i <= j) {
                    exchange(i, j);
                    i++;
                    j--;
                }
            }
            // Recursion
            if (low < j)
                quicksort(low, j);
            if (i < high)
                quicksort(i, high);
        }

        private void exchange(int i, int j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    //Merge-sort

    public class Mergesort {
        private int[] numbers;
        private int[] helper;

        private int number;

        public void sort(int[] values) {
            this.numbers = values;
            number = values.length;
            this.helper = new int[number];
            mergesort(0, number - 1);
        }

        private void mergesort(int low, int high) {
            // check if low is smaller than high, if not then the array is sorted
            if (low < high) {
                // Get the index of the element which is in the middle
                int middle = low + (high - low) / 2;
                // Sort the left side of the array
                mergesort(low, middle);
                // Sort the right side of the array
                mergesort(middle + 1, high);
                // Combine them both
                merge(low, middle, high);
            }
        }

        private void merge(int low, int middle, int high) {

            // Copy both parts into the helper array
            for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
                if (helper[i] <= helper[j]) {
                    numbers[k] = helper[i];
                    i++;
                } else {
                    numbers[k] = helper[j];
                    j++;
                }
                k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                numbers[k] = helper[i];
                k++;
                i++;
            }
            // Since we are sorting in-place any leftover elements from the right side
            // are already at the right position.

        }
    }

}

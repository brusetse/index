package com.bruse.algorithm;

public class BinarySearch {

    public static int binarySearch(int[] arr, int value) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            int midVal = arr[mid];
            if (midVal < value) {
                left = mid;
            } else if (midVal > value) {
                right = mid;
            } else {
                return mid;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        System.out.println(binarySearch(arr, 7));
    }
}

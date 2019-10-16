package com.bruse.basic.algorithm;

/**
 * 直接插入排序
 * @author bruse
 */
public class InsertionSort {

    private static void sort1(int[] a) {
        int i, j, k;
        for (i = 1; i < a.length; i++) {
            // 为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    break;
                }
            }
            // 如找到了一个合适的位置
            if (j != i - 1) {
                int tmp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                a[j + 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 1, 5, 8, 0, 3, 7, 2};
        sort1(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}

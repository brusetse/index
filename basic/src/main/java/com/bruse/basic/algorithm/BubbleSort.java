package com.bruse.basic.algorithm;

/**
 * 冒泡排序
 * @author bruse
 */
public class BubbleSort {

    /**
     * 设数组长度为N。
     *
     * 1．比较相邻的前后二个数据，如果前面数据大于后面的数据，就将二个数据交换。
     *
     * 2．这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第N-1个位置。
     *
     * 3．N=N-1，如果N不为0就重复前面二步，否则排序完成。
     */
    private static void sort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    /**
     * 下面对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成
     */
    private static void sort2(int[] a) {
        int k = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 1; j < a.length - k; j++) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            k++;
        }
    }

    /**
     * 再做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，那么在第一趟遍历后，
     * 最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     */
    private static void sort3(int[] a) {
        int k;
        int flag = a.length;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int j = 1; j < k; j++) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                    flag = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 1, 5, 8, 0, 3, 7, 2};
        // sort1(array);
        // sort2(array);
        sort3(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}

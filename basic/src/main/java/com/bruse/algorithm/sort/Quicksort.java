package com.bruse.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int value = (int) (Math.random() * 1000);
            list.add(value);
        }
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println("\n----------------------------------------------------");
        quickSort(list, 0, list.size() - 1);
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
    }

    private static int division(List<Integer> list, int left, int right) {
        int baseNum = list.get(left);

        while (left < right) {
            while (left < right && list.get(right) >= baseNum) right--;

            list.set(left, list.get(right));

            while (left < right && list.get(left) <= baseNum) left++;

            list.set(right, list.get(left));
        }

        list.set(left, baseNum);

        return left;
    }

    private static void quickSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int i = division(list, left, right);

            quickSort(list, left, i - 1);

            quickSort(list, i + 1, right);
        }
    }
}

package com.bruse.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] result = twoSum(nums, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i != j && nums[i] + nums[j] == target) {
        //             int[] resultArray = {i, j};
        //             return resultArray;
        //         }
        //     }
        // }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] resultArray = {map.get(target - nums[i]), i};
                return resultArray;
            }
            map.put(nums[i], i);
        }

        return null;
    }
}

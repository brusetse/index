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

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
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

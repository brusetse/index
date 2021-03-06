package com.bruse.leetcode;

public class Solution3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {

        // 超出时间限制
        // int max = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = i + 1; j < s.length() + 1; j++) {
        //         String target = s.substring(i, j);
        //         int length = target.length();
        //         String[] split = target.split("");
        //         boolean flag = false;
        //         for (String s1 : split) {
        //             String replace = target.replace(s1, "");
        //             if (length - replace.length() != 1) {
        //                 flag = true;
        //                 break;
        //             }
        //         }
        //         if (flag) {
        //             continue;
        //         }
        //         if (length > max) {
        //             max = length;
        //         }
        //     }
        // }
        // return max;

        if (s.length() <= 1) {
            return s.length();
        }
        int maxLength = 0;
        int start = 0;
        int end = 1;
        while (true) {
            String subStr = s.substring(start, end);
            char nextChar = s.charAt(end);
            int index = subStr.indexOf(nextChar);
            if (index == -1) {
                int length = subStr.length() + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                int length = subStr.length();
                if (length > maxLength) {
                    maxLength = length;
                }
                start = start + index + 1;
            }
            end++;
            if (end == s.length()) {
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}

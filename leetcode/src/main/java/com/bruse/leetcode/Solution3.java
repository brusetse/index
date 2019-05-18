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

        // int start;
        // int end;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int start = s.indexOf(c);
            int end = s.lastIndexOf(s);
            if (start != end) {
                int currentLength = end - start;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}

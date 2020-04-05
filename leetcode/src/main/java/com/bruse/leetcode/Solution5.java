package com.bruse.leetcode;

public class Solution5 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLength = 0;
        String result = "";
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int len = 1;
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }

            while (left >= 0 && right < length && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            while (left >= 0 && right < length && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }

            if (maxLength < len) {
                result = s.substring(left + 1, right);
                maxLength = len;
            }
        }

        return result;
    }

    /**
     * 动态规划
     */
    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLength = 0;
        String result = "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int r = 1; r < length; r++) {
            for (int l = 0; l <= r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLength) {
                        maxLength = r - l + 1;
                        result = s.substring(l, r + 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution5().longestPalindrome(s));
    }
}

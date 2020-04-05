package com.bruse.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution139 {

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * <p>
     * 说明：
     * <p>
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        return isBreak(s, 0, new HashSet<>(wordDict), map);
    }

    public static boolean isBreak(String s, int start, HashSet<String> set, Map<Integer, Boolean> map) {
        if (start == s.length()) {
            return true;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        for (int i = start; i < s.length(); i++) {
            if (set.contains(s.substring(start, i + 1))) {
                map.put(start, true);
                if (isBreak(s, i + 1, set, map)) {
                    return true;
                }
            }
            map.put(start, false);
        }
        return false;
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = Arrays.asList(dict);
        System.out.println(new Solution139().wordBreak("catsandog", wordDict));
    }
}

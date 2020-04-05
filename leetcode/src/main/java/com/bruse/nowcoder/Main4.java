package com.bruse.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 全排列
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            Set<String> set = new HashSet<>();
            set.add(str);
            recurse(0, chars, set);
            System.out.println(set.size());
        }
    }

    public static void recurse(int start, char[] chars, Set<String> set) {
        int length = chars.length;
        if (start >= length - 1) {

        } else {
            for (int i = start; i < length; i++) {
                swap(chars, i, start);
                set.add(new String(chars));

                recurse(start + 1, chars, set);

                swap(chars, i, start);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

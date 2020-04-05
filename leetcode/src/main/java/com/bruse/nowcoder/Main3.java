package com.bruse.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Set<Character> set = new HashSet<>();
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 0 && c <= 127) {
                    set.add(c);
                }
            }
            System.out.println(set.size());
        }
    }
}
package com.bruse.nowcoder;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        TreeMap<Long, String> treeMap = new TreeMap<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                long l = o2 - o1;
                if (l > 0) {
                    return 1;
                } else if (l < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        while (scanner.hasNext()) {
            String disk = scanner.nextLine();
            sort(treeMap, disk);
        }
        for (Long aLong : treeMap.keySet()) {
            System.out.println(treeMap.get(aLong));
        }
    }

    public static void sort(TreeMap<Long, String> treeMap, String disk) {
        treeMap.put(getSizeM(disk), disk);
    }

    public static long getSizeM(String space) {
        char sign = space.charAt(space.length() - 1);
        String numStr = space.substring(0, space.length() - 1);
        int num = Integer.parseInt(numStr);
        if (sign == 'T') {
            return num * 1000 * 1000;
        } else if (sign == 'G') {
            return num * 1000;
        } else if (sign == 'M') {
            return num;
        } else {
            return 0;
        }
    }
}
package com.bruse.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String disk = scanner.nextLine();
            if (!disk.equals("")) {
                list.add(disk);
                num--;
            }
            if (num == 0) {
                break;
            }
        }
        Collections.sort(list, (o1, o2) -> {
            long size1 = getSizeM(o1);
            long size2 = getSizeM(o2);
            long l = size1 - size2;
            if (l > 0) {
                return 1;
            } else if (l < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        for (String s : list) {
            System.out.println(s);
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
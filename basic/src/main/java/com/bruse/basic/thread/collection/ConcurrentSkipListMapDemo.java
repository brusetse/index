package com.bruse.basic.thread.collection;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {

    public static void main(String[] args) {
        /**
         * 时间复杂度 O(log(N))
         */
        Map<String, String> map = new ConcurrentSkipListMap<>(Collections.reverseOrder());
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        System.out.println(map.toString());
    }
}

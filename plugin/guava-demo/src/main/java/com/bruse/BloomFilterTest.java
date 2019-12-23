package com.bruse;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {

    public static void main(String[] args) {
        int total = 1000000;
        BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);
        // 初始化数据
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }

        int count = 0;
        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)) {
                System.out.println(i + " escape...");
                count++;
            }
        }
        System.out.println("escape count: " + count);

        int count2 = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)) {
                System.out.println(i + " wrong...");
                count2++;
            }
        }
        System.out.println("wrong count: " + count2);
    }
}

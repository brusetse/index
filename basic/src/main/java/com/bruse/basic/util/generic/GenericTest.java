package com.bruse.basic.util.generic;

import java.util.Date;

public class GenericTest<T> {

    public static <T> T create(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Date date = create(Date.class);
        StringBuilder sb = create(StringBuilder.class);
    }
}

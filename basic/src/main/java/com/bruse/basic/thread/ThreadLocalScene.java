package com.bruse.basic.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalScene {

    public static void main(String[] args) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        System.out.println(rnd.nextInt());
    }
}

class ThreadLocalDateFormat {
    static ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String date2String(Date date) {
        return sdf.get().format(date);
    }

    public static Date string2Date(String str) throws ParseException {
        return sdf.get().parse(str);
    }
}

/**
 * 上下文信息
 */
class RequestContext {
    public static class Request {
    }
    private static ThreadLocal<String> localUserId = new ThreadLocal<>();
    private static ThreadLocal<Request> localRequest = new ThreadLocal<>();

    public static String getCurrentUserId() {
        return localUserId.get();
    }

    public static void setCurrentUserId(String userId) {
        localUserId.set(userId);
    }

    public static Request getCurrentRequest() {
        return localRequest.get();
    }

    public static void setCurrentRequest(Request request) {
        localRequest.set(request);
    }
}
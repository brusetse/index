package com.bruse.basic.util.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static void get() throws Exception {
        String url = "http://www.baidu.com";
        URL httpUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println(is2string(connection.getInputStream()));
        }
    }

    public static void post(Boolean isJson) throws Exception {
        String url = "http://www.baidu.com";
        URL httpUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        if (isJson) {
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        }
        connection.connect();

        String body = "userName=zhangsan&password=123456";
        if (isJson) {
            body = "{userName:zhangsan,password:123456}";
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        writer.write(body);
        writer.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println(is2string(connection.getInputStream()));
        }
    }

    public static void main(String[] args) {
        try {
            // get();
            post(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String is2string(InputStream is) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        StringBuilder str = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            str.append(inputLine);
        }
        in.close();
        return str.toString();
    }
}

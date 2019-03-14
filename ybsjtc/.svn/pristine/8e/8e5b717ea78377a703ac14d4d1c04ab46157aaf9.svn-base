package com.wondersgroup.framework.upms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UasUtil {
    private static int timeout = 30000;
    protected static Logger logger = LoggerFactory.getLogger(UasUtil.class);

    public static String httpGet(String url) {
        return httpGet(url, timeout);
    }

    public static String httpPost(String url, String param) {
        return httpPost(url, param, timeout);
    }

    public static String httpGet(String url, int to) {
        String ret = "";

        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连�?
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setUseCaches(false);
            // 设置通用的请求属�?
            connection.setReadTimeout(to);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("accept", "*/*");
            // connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连�?
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响�?
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                ret += line;
            }

        } catch (Exception e) {
            System.out.println("发�?�GET请求出现异常�?" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入�?
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                System.out.println("释放GET请求出现异常�?" + e2);
                e2.printStackTrace();
            }
        }

        return ret;
    }

    public static String httpPost(String url, String param, int to) {
        PrintWriter out = null;
        BufferedReader in = null;
        String ret = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连�?
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setUseCaches(false);
            // 发�?�POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 设置通用的请求属�?
            connection.setReadTimeout(to);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("connection", "Keep-Alive");

            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());
            // 发�?�请求参�?
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响�?
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                ret += line;
            }
        } catch (Exception e) {
            System.out.println("发�?? POST 请求出现异常�?" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流�?�输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.out.println("释放POST请求出现异常�?" + ex);
                ex.printStackTrace();
            }
        }
        return ret;
    }
}

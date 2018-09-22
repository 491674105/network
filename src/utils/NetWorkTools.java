package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description: NetWorkTools
 * @author: Fearon
 * @create: 2018/9/21 14:54
 **/
public class NetWorkTools {
    public static double ping(String domain, int times, long timeOut)
            throws ConnectException, UnknownHostException {
        String osName = System.getProperty("os.name");
        String command;
        if (osName.toLowerCase().contains("windows"))
            command = "ping " + domain + " -n " + times + " -w " + timeOut;
        else
            command = "ping " + domain + " -c " + times + " -i " + timeOut;

        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader buffer = null;
        int count = 0;
        try {
            Runtime run = Runtime.getRuntime();
            Process process = run.exec(command);
            inputStream = process.getInputStream();
            reader = new InputStreamReader(inputStream, System.getProperty("sun.jnu.encoding"));
            buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.toUpperCase().contains("TTL")) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != buffer) {
                    buffer.close();
                }

                if (null != reader) {
                    reader.close();
                }

                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (count == 0) {
            if (!parseURL(domain))
                throw new UnknownHostException("Unable to resolve the target address!");

            throw new ConnectException("The network connection is abnormal!");
        }

        return count / times;
    }

    public static boolean parseURL(String domain) {
        boolean isParsed = false;
        try {
            System.out.println("Start parsing...");
            System.out.println("DomainManager ---> " + domain);

            InetAddress[] addresses = InetAddress.getAllByName(domain);

            int length = addresses.length;
            if (length > 0) {
                isParsed = true;

                /*for (int i = 0; i < addresses.length; i++) {
                    System.out.println("IP No." + (i + 1) + " : " + addresses[i]);
                }*/
            }

            System.out.println("Parsing completed!");
        } catch (UnknownHostException e) {
            System.out.println("Parsing failed!");
        }

        return isParsed;
    }

    public static void environment() {
        // 获取系统属性列表
//        System.getProperties().list(System.out);

        // 获取当前操作系统名称
        System.out.println("os.name ---> " + System.getProperty("os.name"));

        // 获取JNU编码
        System.out.println("sun.jnu.encoding ---> " + System.getProperty("sun.jnu.encoding"));

        //获取系统默认编码
        System.out.println("file.encoding ---> " + System.getProperty("file.encoding"));

        // 获取系统默认的字符编码
//        System.out.println(Charset.defaultCharset());

        // 获取系统默认语言
//        System.out.println(System.getProperty("user.language"));

        // 设置编码
//        System.getProperties().put("file.encoding", "GBK");
    }
}
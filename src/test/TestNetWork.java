package test;

import utils.NetWorkTools;

import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: Fearon
 * @create: 2018/9/22 10:11
 **/
public class TestNetWork {
    public static void main(String[] args) throws UnknownHostException, ConnectException {

        NetWorkTools.environment();

        String domain = "www.baidu.com";

        System.out.println(NetWorkTools.parseURL(domain));

        System.out.println(NetWorkTools.ping(domain, 4, 300));
    }
}
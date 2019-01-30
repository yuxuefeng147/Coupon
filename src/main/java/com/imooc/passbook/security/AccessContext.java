package com.imooc.passbook.security;

/**
 * @program: rd
 * @description: ThreadLocal 去单独储存每个线程携带的信息
 * @author: xuefeng
 * @create: 2019/1/30 14:25
 */
public class AccessContext {

    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tolenStr) {
        token.set(tolenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}

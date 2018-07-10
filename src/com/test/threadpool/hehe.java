package com.test.threadpool;

import java.util.ArrayList;

public class hehe {
    ArrayList<String> array = new ArrayList<>();

    /**
     * 总结就是，只要我这边和后台正常关闭了
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Integer integer1 = 3;
        Integer integer2 = 3;

        if (integer1 == integer2)
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");

        Integer integer3 = 300;
        Integer integer4 = 300;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");

    }
//        InputStream is = s.getInputStream();
//        byte[] bys = new byte[8192];
//        int len;
//        while ((len = is.read(bys)) != -1) {
//            String str = new String(bys, 0, len);
//            System.out.println(str);
//        }
//        System.out.println(len);
//        System.out.println("send over");
//        System.out.println(s.isClosed() + "" + s.isConnected() + s.isBound() + s.getInetAddress().toString());
//        System.in.read();
}




package com.test.threadpool.jav;


import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ja {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket();
        System.out.println(s.isClosed() + "" + s.isConnected() + s.isBound());
        s.connect(new InetSocketAddress("127.0.0.1", 3113));
        System.out.println(s.isClosed() + "" + s.isConnected() + s.isBound() + s.getInetAddress().toString());
        s.close();
        s = new Socket();
        SocketAddress address = s.getRemoteSocketAddress();
        s.connect(address);
        System.out.println(s.isClosed() + "" + s.isConnected() + s.isBound() + s.getInetAddress().toString());
        System.out.println(s.getRemoteSocketAddress());
/*

        new Thread(() -> {
            InputStream is = null;
            try {
                is = s.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bys = new byte[8192];
            int len;
            try {
                while (!s.isClosed()
                        && (len = is.read(bys)) != -1) {
                    System.out.println(new String(bys, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        s.connect(s.getRemoteSocketAddress());
        s.setReuseAddress(true);
        System.out.println(s.isClosed() + "" + s.isConnected() + s.isBound() + s.getInetAddress().toString());
        //也就是说我这边自己主动closed之后会Socket Closed IOException
      //  s.sendUrgentData(0XFF);
        System.out.println(s.isClosed() + "" + s.isConnected() + s.isBound() + s.getInetAddress().toString());
*/

    }
}

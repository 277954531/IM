package com.test.threadpool.jav

import java.io.IOException
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import com.sun.xml.internal.ws.streaming.XMLStreamWriterUtil.getOutputStream
import java.net.Socket


class TcpCore {
    private var socket: Socket? = null

    private var tcpReceiver: ITcpReceiver? = null

    fun setTcpReceiver(tcpReceiver: ITcpReceiver) {
        this.tcpReceiver = tcpReceiver
    }


    /**
     * 这个必须第一个用
     *
     * @param host ip字符串
     * @param port 端口号
     * @throws IOException 抛出的IO异常
     */
    @Throws(IOException::class)
    fun connect(host: String, port: Int) {
        if (socket != null) {
            if (!socket!!.isClosed)
                socket!!.close()
            // socket.connect(new InetSocketAddress(host, port));
        }
        socket = Socket(host, port)
    }

    /**
     * 下行，一个socket只能被调用一次 [base64]
     *
     * @throws Exception 抛出的IO异常
     */
    @Throws(Exception::class)
    fun getData() {
/*        val input = socket!!.getInputStream()
        val bys = ByteArray(8192)
        var len: Int
        do {
            len = input.read(bys)
            tcpReceiver?.onPart(bys,len)
        }while (len!=-1)
        while ((len = input.read(bys)) != -1) {
            if (tcpReceiver != null)
                tcpReceiver!!.onPart(bys, len)
        }*/
    }

    /**
     * 上行方法，这里我们应该不做任何封装，可以给上层更多的操作方式
     * 没有链接的时候send是不会抛异常的
     *
     * @param bytes byte数组
     * @throws IOException 抛出的IO异常
     */
    @Throws(IOException::class)
    fun send(bytes: ByteArray) {
        val os = socket!!.getOutputStream()
        os.write(bytes)
        //os.flush();//强制刷新会Broken pipe
    }

    /**
     * 客户端主动关闭socket
     */
    fun disconnect() {
        if (null != socket) {
            try {
                socket!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }
}

interface ITcpReceiver {
    /**
     * TCP核心每次接收一部分的byte数组就会调用此方法
     *
     * @param bys 数据数组
     * @param len 数组中有效长度
     */
    @Throws(Exception::class)
    fun onPart(bys: ByteArray, len: Int)
}
package com.code1j.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static com.code1j.nio.NioTest.getString;
import static java.nio.channels.SelectionKey.OP_ACCEPT;

/**
 * @ wuhui
 * @ date  2017/9/27下午3:28
 */
public class NioStartup {

    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    init();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    public static void init2(){
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8081));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if (selector.select(TIMEOUT) == 0) {
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    System.out.println(0);
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        System.out.println(1);
                    }
                    if(key.isReadable()){
                        System.out.println(2);
                    }
                    if(key.isWritable() && key.isValid()){
                        System.out.println(3);
                    }
                    if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void init() throws IOException {
        //打开多路复用器
        Selector selector =Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();;
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        //注册
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while(true) {
            if (selector.select(1000000) == 0) {
                continue;
            }
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()){
                SelectionKey selectionKey = iter.next();
                if(selectionKey.isReadable()){
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    //创建ByteBuffer，并开辟一个1M的缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //读取请求码流，返回读取到的字节数
                    int readBytes = sc.read(buffer);
                    buffer.flip();
                    String f = getString(buffer);
                    if(f!=null&&!f.equals("")){
                        System.out.println(f);
                    }

                }
                if(selectionKey.isAcceptable()){
                    System.out.println("bbb");
                    ServerSocketChannel ssChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel sc = ssChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selectionKey.selector(), SelectionKey.OP_READ,null);
                }

                if(selectionKey.isWritable() && selectionKey.isValid()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    buf.flip();
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    while(buf.hasRemaining()){
                        sc.write(buf);
                    }
                    buf.compact();
                }

                if(selectionKey.isConnectable()){
                }
                iter.remove();

            }

        }

    }

}

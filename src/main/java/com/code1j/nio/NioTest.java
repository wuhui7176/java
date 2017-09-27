package com.code1j.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.*;

/**
 * @ wuhui
 * @ date  2017/9/27下午1:45
 */
public class NioTest {


   static List<SocketChannel> list = new ArrayList();


    public static void main(String[] args) throws IOException {
       selector();


    }


    private static final int BUF_SIZE=1024;
    private static final int PORT = 8080;
    private static final int TIMEOUT = 3000;



    public static void handleAccept(SelectionKey key) throws IOException{
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(BUF_SIZE));
        list.add(sc);
    }

    public static String getString(ByteBuffer buffer) {

        Charset charset = null;

        CharsetDecoder decoder = null;

        CharBuffer charBuffer = null;

        try {

            charset = Charset.forName("UTF-8");

            decoder = charset.newDecoder();

            //用这个的话，只能输出来一次结果，第二次显示为空

// charBuffer = decoder.decode(buffer);

            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());

            return charBuffer.toString();

        } catch (Exception ex) {

            ex.printStackTrace();

            return "error";

        }

    }

    public static void handleRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel) key.channel();
        //创建ByteBuffer，并开辟一个1M的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取请求码流，返回读取到的字节数
        int readBytes = sc.read(buffer);
        buffer.flip();
        String f = getString(buffer);


        if(f.contains("exit")){
            try {
                sc.close();
                return;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                return;
            }
        }
        //读取到字节，对字节进行编解码
//        if(readBytes>0){
//            //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
//            buffer.flip();
//            //根据缓冲区可读字节数创建字节数组
//            byte[] bytes = new byte[buffer.remaining()];
//            //将缓冲区可读字节数组复制到新建的数组中
//            buffer.get(bytes);
//            String expression = new String(bytes,"UTF-8");
//            System.out.println("服务器收到消息：" + expression);
//
//        }

        try {
            list.get(1).write(buffer);

        }catch (Exception e){

        }

    }
    public static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer)key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try{
            selector = Selector.open();
            ssc= ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8081));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while(true){
                if(selector.select(TIMEOUT) == 0){
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    System.out.println(0);
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        handleAccept(key);
                    }
                    if(key.isReadable()){

                        handleRead(key);
                    }
                    if(key.isWritable() && key.isValid()){
                        handleWrite(key);
                    }
                    if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }


                    iter.remove();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
//            try{
//                if(selector!=null){
//                    selector.close();
//                }
//                if(ssc!=null){
//                    ssc.close();
//                }
//            }catch(IOException e){
//                e.printStackTrace();
//            }
        }
    }

}

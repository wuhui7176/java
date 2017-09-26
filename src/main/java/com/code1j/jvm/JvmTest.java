package com.code1j.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ wuhui
 * @ date  2017/9/26上午9:31
 */
public class JvmTest {
    //         gc类型                        年轻代用的  gc后的  总量      堆内存用的  gc后  堆内存总量
    //[GC (Allocation Failure) [PSYoungGen: 741213K->131056K(917504K)] 741213K->706776K(3014656K), 0.7861434 secs] [Times: user=2.46 sys=0.42, real=0.79 secs]


    //[Full GC (Ergonomics) [PSYoungGen: 262144K->260462K(305664K)]
    // [ParOldGen: 639176K->639176K(699392K)] 901320K->899638K(1005056K),
    // [Metaspace: 2657K->2657K(1056768K)], 2.9479086 secs] [Times: user=10.53 sys=0.03, real=2.95 secs]



    // PSYoungGen      total 611840K, used 247854K [0x0000000795580000, 0x00000007c0000000, 0x00000007c0000000)
//    eden space 524800K, 30% used [0x0000000795580000,0x000000079f293b80,0x00000007b5600000)
//    from space 87040K, 99% used [0x00000007bab00000,0x00000007bfff8020,0x00000007c0000000)
//    to   space 87040K, 0% used [0x00000007b5600000,0x00000007b5600000,0x00000007bab00000)
    //新生代：程序新创建的对象都是从新生代分配内存，新生代由Eden Space和两块相同大小的Survivor Space(通常又称S0和S1或From和To)构成
    //可通过-Xmn参数来指定新生代的大小，也可以通过-XX:SurvivorRation来调整Eden Space及SurvivorSpace的大小。



//    ParOldGen       total 1398272K, used 864564K [0x0000000740000000, 0x0000000795580000, 0x0000000795580000)
//    object space 1398272K, 61% used [0x0000000740000000,0x0000000774c4d020,0x0000000795580000)
    //用于存放经过多次新生代GC仍然存活的对象，





    public static void main(String[] args) {

        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        long max = Runtime.getRuntime().maxMemory();
                        long freeMem =Runtime.getRuntime().freeMemory();
                        System.out.println("最大堆内存"+max/1024/1024);
                        System.out.println("剩余空间"+freeMem/1024/1024);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.setDaemon(false);
        t.start();


        long start = System.currentTimeMillis();


        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    List list = new ArrayList<>();
                    for (int j = 0; j < 100000; j++) {
                        list.add(Integer.valueOf(j));
                    }
                }
            },"test-"+i);
            thread.start();

        }

        long end = System.currentTimeMillis();


        System.out.println(end-start);



    }


    //java com.code1j.jvm.JvmTest  运行。class文件  14752
    //java com.code1j.jvm.JvmTest das das 2ed ddd dsada   传参数给args
    //java -Xms1024m -Xmx1024m com.code1j.jvm.JvmTest    jvm启动参数设置


    //-Xms 初始堆大小
    //-Xmx 最大堆大小
    //-Xmn 年轻代大小(1.4or lator)
    //-XX:NewRatio 年轻代(包括Eden和两个Survivor区)与年老代的比值(除去持久代)
    //-XX:SurvivorRatio	 Eden区与Survivor区的大小比值

    //-XX:+PrintGCDetails
}

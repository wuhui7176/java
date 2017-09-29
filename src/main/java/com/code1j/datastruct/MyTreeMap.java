package com.code1j.datastruct;

/**
 *
 *
 *
 * 1）每个结点要么是红的，要么是黑的。
 2）根结点是黑的。
 3）每个叶结点，即空结点（NIL）是黑的。
 4）如果一个结点是红的，那么它的俩个儿子都是黑的。
 5）对每个结点，从该结点到其子孙结点的所有路径上包含相同数目的黑结点。
 * @ wuhui
 * @ date  2017/9/29下午4:22
 */
public class MyTreeMap<K,V>{

    // 跟节点是黑色的
    private Entry<K,V> root;

    public void put(K k,V v){
        Entry<K,V> t = root;

        if(t ==null){
            Entry entry = new Entry(k,v,null);
            return;
        }

        int cmp;

        //父节点
        Entry<K,V> parent;

        do {
            //第一次循环 ,父节点就是 root 节点
            parent = t;
            cmp= comp(k,parent.key);

            // <0 往左边找
            if(cmp <0){
                t.left = t;
                // >0 右边找
            }else if (cmp >0){
                t.right = t;
            }else {
                // = 0  已有这个 对象，重新复制
                t.setValue(v);
            }

        }while (t!=null);


        //找到父节点后，创建对象
        Entry e = new Entry(k,v,parent);

        //
        if(cmp >0){
            parent.right = e;
        }else {
            parent.left = e;
        }

        //重新染色 ，调整红黑树平衡
        fixAfterInsertion(e);

    }

    private void fixAfterInsertion(Entry<K,V> x) {
        //先染色称红色
        x.color = RED;

        //插入一个新节点，默认红色，如果夫节点是黑色的，对红黑树没有影响，直接插入即可
        // 父节点是红色的话一直循环,父节点不是红色直接退出
        while (x!=null && x!=root &&x.parent.color ==RED){

            //父节点  ，和左 爷爷节点一样 ，祖父节点的左边
            if(parentOf(x)==leftOf(parentOf(parentOf(x)))){
                //父节点的父节点 的 右节点  =  叔叔节点
                Entry<K,V> y = rigthOf(parentOf(parentOf(x)));
                //如果叔叔节点是红色的
                if(colorOf(y) ==RED){
                    //1  把父 设置为黑色
                    setColor(parentOf(x),BLACK);
                    //2   把叔叔节点设置为黑色
                    setColor(y, BLACK);
                    //3 祖父节点设置为红色
                    setColor(parentOf(parentOf(x)), RED);
                    // 不需要旋转
                }else {

                }



            }else {
                //祖父节点的右边

            }

        }

        //父节点是黑色的不需要操作
        root.color = BLACK;


    }


    private static <K,V> void setColor(Entry<K,V> p, boolean c) {
        if (p != null)
            p.color = c;
    }
    private static <K,V> boolean colorOf(Entry<K,V> p) {
        return (p == null ? BLACK : p.color);
    }
    //寻找父亲节点
    private <K,V> Entry<K,V> parentOf(Entry<K,V> p) {
        return (p == null ? null: p.parent);
    }

    //寻找左节点
    private <K,V> Entry<K,V> leftOf(Entry<K,V> p){
        return p.left ==null? null:p.left;
    }

    //寻找左节点
    private <K,V> Entry<K,V> rigthOf(Entry<K,V> p){
        return p.right ==null? null:p.right;
    }

        // k1 > k2
    private int comp(K k1,K k2){
        return 0;
    }




    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    static final class Entry<K,V>{

        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;

        Entry(K key, V value, Entry<K,V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }



    }


}

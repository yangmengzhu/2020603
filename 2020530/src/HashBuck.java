/*
 * @program: 2020530
 * @description哈希桶的实现
 *哈希桶也叫开散列-》是解决冲突的一种方式
 * @author mrs.yang
 * @create: 2020 -05 -30 15 :10
 */

import java.util.HashMap;

public class HashBuck {
    static class Node{
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public Node[] arr=new Node[10];
    public int usedSize;
    //负载因子
    public double loadFactor(){
        return this.usedSize*0.1/arr.length;
    }
    //扩容（2倍扩容
    public void relise(){
        //扩容之后index位置会改变,所以需要重新hash
        Node[] newArr=new Node[2*arr.length];
        for (int i = 0; i < arr.length; i++) {
            Node cur=arr[i];
            if(cur!=null){
                //头插法
                Node curNext=cur.next;
                int index=cur.key%newArr.length;
                cur.next=newArr[index];
                newArr[index]=cur;
                cur=curNext;
            }
        }
        arr=newArr;
    }
    public void put(int key,int val){
        Node node=new Node(key,val);
        int index=key%this.arr.length;
        Node cur=arr[index];
        while(cur!=null){
            //key相同就更新Val的值
            if(cur.key==key){
                cur.val=val;
                return;
            }
            cur=cur.next;
        }
        //否则头插法
        node.next=arr[index];
        arr[index]=node;
        this.usedSize++;
        //放完之后判断是否超过负载因子
        if(loadFactor()>0.75){
            //超过就扩容
            relise();
        } 
    }
    public int getKey(int key){
        int index=key%arr.length;
        Node cur=arr[index];
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }
            cur=cur.next;
        }
        return -1;
    }
}

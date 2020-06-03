/*
 *
 * @program: 2020530
 * @description
 * map和set练习题
 * @author: mrs.yang
 * @create: 2020 -05 -30 18 :04
 */

import java.util.*;

class Node{
    public int data;
    public Node next;
    public Node random;
    public Node(int data){
        this.data=data;
    }
}
public class MapSet {
    //复制链表
    public Node copyLinked(Node head){
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
        if(head==null){
            return null;
        }
        while(cur!=null){
            Node newHead=new Node(cur.data);
            map.put(cur,newHead);
            cur=cur.next;
        }
        cur=head;
        //修改新链表的值
        while(cur!=null){
             map.get(cur).next=map.get(cur.next);
             map.get(cur).random=map.get(cur.random);
             cur=cur.next;
        }
        return map.get(head);
    }
    //宝石和石头
    public int numJ(String J,String S){
        char[] j=J.toCharArray();
        char[] s=S.toCharArray();
        Set<Character> set=new HashSet<>();
        for (char val:j) {
            set.add(val);
        }
        int count=0;
        for (char sh:s) {
            if(set.contains(sh)){
                count++;
            }
        }
        return count;
    }
    //坏键盘打字
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String expected=scan.nextLine();
        String actual=scan.nextLine();
        Set<Character> set=new HashSet<>();
        for ( char act:actual.toUpperCase().toCharArray()) {
            set.add(act);
        }
        Set<Character> set1=new HashSet<>();
        for (char exp:expected.toUpperCase().toCharArray()) {
            if(!set.contains(exp)&&!set1.contains(exp)){
                System.out.print(exp);
                set1.add(exp);
            }
        }
    }
}

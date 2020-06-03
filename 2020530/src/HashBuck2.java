import java.util.Objects;

/*
 *
 * @program: 2020530
 * @description
 * 泛型的哈希桶
 * @author: mrs.yang
 * @create: 2020 -05 -30 16 :26
 */
//用equals方法来对比key 值是不是要查找的key
class Person{
  public int id;
  public Person(int id){
      this.id=id;
  }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class HashBuck2<K,V> {
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
        public Node<K,V>[] arr=(Node<K,V>[])new Node[10];
        public int usedSize;
        public void put(K key,V val){
            int hash=key.hashCode();
            int index=hash%arr.length;
            Node<K,V> node=new Node<K,V>(key,val);
            Node<K,V> cur=arr[index];
            while(cur!=null){
                if(cur.key.equals(key)){
                    cur.val=val;
                    return;
                }
                cur=cur.next;
            }
            node.next=arr[index];
            arr[index]=node;
            this.usedSize++;
        }
        public V getKey(K key){
            int hash=key.hashCode();
            int index=hash%arr.length;
            Node<K,V> cur=arr[index];
            while(cur!=null){
                if(cur.key.equals(key)){
                    return cur.val;
                }
                cur=cur.next;
            }
            return null;
        }
    public static void main(String[] args) {
        HashBuck2<Person,String> hash=new HashBuck2<>();
        Person P1=new Person(12);
        Person P2=new Person(12);
        hash.put(P1,"HAHA");
        System.out.println(hash.getKey(P2));
    }
}

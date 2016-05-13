package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haodongl on 4/14/16.
 * 3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]
 */
public class LRUCache {
    Map<Integer, Node> cache = new HashMap<>();
    int size;
    Node head;
    Node tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node n = cache.get(key);
            remove(n);
            setHead(n);
            return cache.get(key).value;
        } else{
            return -1;
        }
    }

    public void set(int key, int value) {

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        }else{
            Node n = new Node();
            n.key = key;
            n.value = value;
            if(cache.size() == size){
                cache.remove(tail.key);
                remove(tail);
            }
            cache.put(key, n);
            setHead(n);
        }
    }

    private void remove(Node n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }

    }

    private void setHead(Node newHead){
        newHead.prev = null;
        newHead.next = this.head;

        if(this.head !=null){
            this.head.prev = newHead;
        }
        this.head = newHead;
        if(tail == null) tail = newHead;
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(3);
        cache.set(1,1);

        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);

        System.out.println(cache.get(4));

        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));

        cache.set(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));

    }
}

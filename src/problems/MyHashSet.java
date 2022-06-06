package problems;

import java.util.Objects;

class Node{
    int key;
    Node next;
    Node(int key){
        this.key = key;
    }
}
public class MyHashSet {
    Node[] buckets;
    int size = 10000;
    public MyHashSet() {
        buckets = new Node[size];
    }
    public int getBucketNum(int key) {
        int hash = Objects.hash(key);
        int bucketNum = hash % size;
        return bucketNum;
    }
    public void add(int key) {
        int bucketNum = getBucketNum(key);
        if(buckets[bucketNum] == null){
            buckets[bucketNum] = new Node(key);
            return;
        }
        Node curr = buckets[bucketNum];
        while( curr.key != key && curr.next != null ) curr = curr.next;
        if(curr.key == key) return;
        curr.next = new Node(key);
    }

    public void remove(int key) {
        int bucketNum = getBucketNum(key);
        if(buckets[bucketNum] == null) return;
        if(buckets[bucketNum].key == key){
            buckets[bucketNum] = buckets[bucketNum].next;
            return;
        }
        Node curr = buckets[bucketNum];
        while(curr.next != null && curr.next.key != key){
            curr = curr.next;
        }
        if(curr.next == null) return;
        curr.next = curr.next.next;
    }

    public boolean contains(int key) {
        int bucketNum = getBucketNum(key);
        Node curr = buckets[bucketNum];
        while(curr != null){
            if(curr.key == key) return true;
        }
        return false;
    }
}

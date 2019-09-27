package Test0911;

import java.util.Random;

public class HashBucket {
    private static class Node {
        int key;
        int val;
        Node next;
    }

    private Node[] array;
    private int size;

    HashBucket() {
        array = new Node[8];
        size = 0;
    }


    private int hashFunction(int key, int cap) {
        return key % cap;
    }

    public int get(int key) {
        int index = hashFunction(key, array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }
            cur=cur.next;
        }
        return -1;
    }

    public int put(int key, int val) {
        int imdex = hashFunction(key, array.length);
        Node head = array[imdex];
        Node cur = head;
        while (cur != null) {
            if (key == cur.key) {
                int oldval = cur.val;
                cur.val = val;
                return oldval;
            }
            cur = cur.next;
        }
        Node node = new Node();
        node.key = key;
        node.val = val;
        node.next = head;
        array[imdex] = node;

        size++;
        if(size/array.length>=0.75){
            resize();
        }
        return -1;
    }

    private void resize() {
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                int index=hashFunction(cur.key,newArray.length);
                Node node=new Node();
                node.key=cur.key;
                node.val=cur.val;
                node.next=newArray[index];
                newArray[index]=node;
                cur=cur.next;
            }
        }
    }

    public int remove(int key) {
        int index = hashFunction(key, array.length);
        Node head = array[index];
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (cur.key == key) {
                int oldval = cur.val;
                if (cur == head) {
                    array[index] = head.next;
                } else {
                    pre.next = cur.next;
                }
                size--;
                return oldval;
            }
            pre = cur;
            cur = cur.next;
        }
        return -1;
    }
// 作业
// keySet
// values
// entrySet
// containsKey
// containsValue
// getOrDefault
    public static void main(String[] args) {
        HashBucket map = new HashBucket();
        Random random = new Random(20190911);
        for (int i = 0; i < 20; i++) {
            int r = random.nextInt(100);
            map.put(r, r + 10);
        }
        System.out.println("success");
        System.out.println(map.array.length);
        map.remove(42);
        map.remove(46);
        System.out.println("success");
    }

}

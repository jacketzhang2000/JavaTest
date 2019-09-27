package Test0909;

public class HashBucket {
    private static class Node{
        int key;
        int val;
        Node next;
    }
    private Node[] array;
    private int size;
    HashBucket(){
        array=new Node [16];
        size=0;
    }
}

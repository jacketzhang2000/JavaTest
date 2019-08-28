package Test0821;

import list.MyLinkedList;

public class MyQueue<I extends Number> {
    static class Node {
        int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }

    }

    Node head = null;
    Node last = null;
    int size = 0;

    public void push(int ele) {
        if (last != null) {
            last.next = new Node(ele);
            last=last.next;
        } else {
            head = last = new Node(ele);

        }
        size++;

    }

    public int pop() {
        int old = head.val;
        size--;
        head = head.next;
        if (head == null) {
            last = null;
        }
        return old;
    }

    public int last() {
        return last.val;
    }

    public int head() {
        return head.val;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String s="[";
        for(Node c = head; c!=null; c=c.next){
            s+=(c.val+",");
        }
        s+="]";
        //System.out.println(s.toString());
        return s;
    }
    public static void main(String[] args) {
        MyQueue<Integer> myQueue=new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(7);

        System.out.println(myQueue.size());
        //myQueue.pop();
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue);


    }
}




package Test0821;

import java.util.LinkedList;
import java.util.Queue;

class  MyStackWithQueue {
     Queue<Integer> queue=new LinkedList<>();
    public MyStackWithQueue(){
        this.queue=queue;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + queue +
                '}';
    }

    public  void push(int x){
        queue.add(x);
    }
    public int pop(){
        int s=queue.size()-1;
        for(int i=0;i<s;i++){
            int x=queue.remove();
            queue.add(x);
        }
        int old=queue.remove();
        return old;
    }
    public int top(){
        int s=queue.size()-1;
        for(int i=0;i<s;i++){
            int x=queue.remove();
            queue.add(x);
        }
        int v=queue.poll();
        queue.add(v);
        return v;
    }
    public boolean isempty(){
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        MyStackWithQueue s=new MyStackWithQueue();
        s.push(1);
        s.push(3);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s);

    }
}

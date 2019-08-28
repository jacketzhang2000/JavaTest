package Test0821;

import java.util.Stack;

public class MyQueueWithStack {
    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();
    //使用两个栈实现队列
    public void push(int x){
        s1.push(x);
    }
    public int pop() {
        if (s2.empty()) {
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public int peek(){
        if(s2.empty()){
            while(!(s1.empty())){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    public boolean empty(){
        return s1.empty()&&s2.empty();
    }

    @Override
    public String toString() {
        return "Node{" +
                "" +s1+ s2+
                '}';
    }

    public static void main(String[] args) {

        MyQueueWithStack m=new MyQueueWithStack();
        System.out.println(m.empty());
        m.push(1);
        m.push(3);
        m.push(5);
        m.push(7);
        m.pop();
        System.out.println(m);
        System.out.println(m.empty());
        m.push(8);
        System.out.println(m);
    }

}

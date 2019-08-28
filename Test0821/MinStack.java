package Test0821;

public class MinStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> min=new Stack<>();
    public MinStack(){}
    public void push(int x){
        stack.push(x);
        if(min.empty()){
            min.push(x);
        }else{
            int m=min.peek();
            if(x<m){
                min.push(x);
            }else{
                min.push(m);
            }
        }
    }

    public void pop(){
        stack.pop();
        min.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack m=new MinStack();
        m.push(2);
        m.push(8);
        m.push(5);
        m.push(4);
        m.push(1);
        m.push(9);
        //后进先出
        System.out.println(m.getMin());
        m.pop();
        m.pop();
        System.out.println(m.getMin());

    }
}

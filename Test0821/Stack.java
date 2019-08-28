package Test0821;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack<I extends Number> {
    private int[] array;
    private int top=0;

    /*
    Stack(){
        this.array=array;
    }
    private Stack(int[] array,int top){
        this.array=array;
        this.top=top;
    }
*/

    private void ensureCapacity(){
        int cap = 0;
        if (array == null) {
            cap = 10;
        } else {
            cap = 2 * array.length;
        }
        if (array != null) {
            array = Arrays.copyOf(array, cap);
        } else {
            array = new int[cap];
        }
    }
    public int push(int ele) {
        ensureCapacity();
        array[top++] = ele;
        return ele;
    }
    public int pop(){
        int old=array[top-1];
        top--;
        return old;
    }

    public int peek(){
        return array[top-1];
    }
    public boolean empty(){
        return top==0;
    }
    public int size(){
        return top;
    }

    public int search(int element){
        for(int i=0;i<top;i++){
            if(array[i]==element){
                return i;
            }
        }
       return -1;
    }

    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(3);
        s.push(2);
        s.pop();
        System.out.println(s.search(3));
        System.out.println(s.toString());
    }
}

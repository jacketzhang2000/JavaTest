package Test0827;
//优先级队列
public class MyPriorityQueue {
    private int[] array =new int[100];
    private int size=0;
    //o(log(n))
    public void add(int element){
        array[size++]=element;
        Heaps.adjustUp(array,size-1);
    }
    public int poll(){
        int e=array[0];
        array[0]=array[--size];
        Heaps.heapify(array,size,0);
        return e;
    }
    public int peek(){
        return array[0];
    }

    public static void main(String[] args) {

    }
}

package Test0823;

public class MyCircularQueue {
    /*
    MyCircularQueue(k): 构造器，设置队列长度为 k 。
	Front: 从队首获取元素。如果队列为空，返回 -1 。
	Rear: 获取队尾元素。如果队列为空，返回 -1 。
	enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
	deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
	isEmpty(): 检查循环队列是否为空。
     */
    private int[] array;
    private int front=0;
    private int rear=0;
    private int size=0;
    public  MyCircularQueue(int k){
        array=new int[k];
    }
    public boolean enQueue(int value){
        if(size==array.length){
            return false;
        }
        array[rear]=value;
        rear=(rear+1)%array.length;
        size++;
        return true;
    }
    public boolean deQueue(){
        if(size==0){
            return false;
        }
        front=(front+1)%array.length;
        size--;
        return true;
    }
    public int Front(){
        if(size==0){
            return -1;
        }
        return array[front];
    }
    public int Rear(){
        if(size==0){
            return -1;
        }
        int index=(rear-1+array.length)%array.length;
        return array[index];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==array.length;
    }

    public static void main(String[] args) {
        MyCircularQueue m=new MyCircularQueue(5);
        System.out.println(m.isEmpty());
        m.enQueue(5);
        m.enQueue(4);
        m.enQueue(1);
        m.enQueue(3);
        m.deQueue();
        System.out.println(m);
        System.out.println(m.Front());
        System.out.println(m.Rear());
        //头删
        m.deQueue();
        System.out.println(m.Front());
        System.out.println(m.isEmpty());


    }
}

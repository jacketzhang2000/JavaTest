package Test0902;

public class MyArrayList<E> {
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")

    public MyArrayList() {
        array = (E[]) new Object[100];
        size=0;
    }
    public  void add(E element){
        array[size++]=element;
    }
    public void remove(){
        array[--size]=null;
        //size--;可能导致内存泄漏，原本语义上应该死去的对象，因为写法的问题，导致
    }
}

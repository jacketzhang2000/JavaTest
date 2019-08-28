package Test0820;

import java.util.Iterator;

class A implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
public class Foreach {
    public static void main(String[] arags){
        A a=new A();
        for(int i:a){
        }
    }
}

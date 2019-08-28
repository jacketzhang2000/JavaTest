package Test0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListAemo {
    public static void main(String[] args) {

        LinkedList<String> list1 =new LinkedList<>();
        list1.push("c");
        list1.push("javaSE");
        list1.push("数据结构");
        list1.push("计算机");
        //头插进栈
        System.out.println(list1.pop());
        System.out.println(list1);
        System.out.println(  );

        LinkedList<String> list =new LinkedList<>();
        list.addLast("c");
        list.addLast("java");
        list.addLast("操作系统");
        System.out.println(list.peek());
        //取而不删，为空时返回null
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(list.poll());
        //且取且删，为空时返回null
        System.out.println(list.getFirst());
        //取而不删,为空时抛异常
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list);
        //删完之后，list为空
        List<Integer> or= Arrays.asList(1,2,3,4,5);
        ArrayList<Integer> list3=new ArrayList<>(or);
        System.out.println(list3);
    }
}

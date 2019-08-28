package Test0819;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Person{}
class Bird{}

public class demo {

    public static void main(String[] args) {
        List<String > list1=new ArrayList<>();
        List<Integer> list2=new LinkedList<>();
        List<Bird> list3=new ArrayList<>();
        System.out.println(list1 instanceof ArrayList);
        System.out.println(list2 instanceof LinkedList);
        System.out.println(list3 instanceof ArrayList);
        //instanceof判断对象是否是特殊的类
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list3.getClass());
        //表示 类对象的运行时类的Class对象。
    }
}

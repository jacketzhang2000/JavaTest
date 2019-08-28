package Test0819;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String > set=new HashSet<>();
        Set<String > set1=new TreeSet<>();
        set.add("你好");
        set.add("中国");
        set.add("人");
        //哈希表的映射顺序无序
        set1.add("中国");
        set1.add("你好");
        set1.add("人");
        //TreeSet按照自然排序排序，打印有序
        List<String> list=new ArrayList<>();
        List<String> list1=new ArrayList<>(set);
        List<String> list2=new ArrayList<>(100);
        List<String> list3=new ArrayList<>(set1);
        //构造具有指定初始容量(100)的空列表。
        System.out.println(list1);
        list.add("hello");
        list.add(1,"world");
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
    }
}

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("我");
        list.add("爱");
        list.add("你");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        for(String s:list){
            System.out.println(s);
        }
        list.remove("爱");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
    }
}
package Test0917;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapDemo {
    public static void main(String[] args) {
        //无论是map还是set都有覆写equal和hashcode方法
        card p=new card(1,"♠");
        card q=new card(1,"♠");
        HashSet<card> set=new HashSet<>();
        set.add(p);
        System.out.println(set.contains(q));

        HashMap<card,String > map=new HashMap<>();
        map.put(p,"黑桃A");
        System.out.println(map.get(q));
    }
}

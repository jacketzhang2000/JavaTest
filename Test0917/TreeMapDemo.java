package Test0917;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
class CardComparator implements Comparator<card> {

    @Override
    public int compare(card o1, card o2) {
        return o1.val-o2.val;
    }
}
public class TreeMapDemo {
    public static void main(String[] args) {
        card p=new card(1,"♠");
        card q=new card(1,"♠");
        CardComparator comparator=new CardComparator();
        TreeSet<card> set=new TreeSet<>(comparator);
        set.add(p);
        System.out.println(set.contains(q));

        TreeMap<card,String > map=new TreeMap<>(comparator);
        map.put(p,"黑桃A");
        System.out.println(map.get(q));
        //麻将
    }
}

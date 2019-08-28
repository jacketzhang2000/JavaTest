package Test0820;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;


public class PokerCard {
    int val;
    String color;
    public PokerCard(int val,String color){
        this.val=val;
        this.color=color;
    }
    @Override
    public String toString() {
        return String.format("[%d,%s]",val,color);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(!(obj instanceof PokerCard)){
            //判断该对象是否能对该类型的引用指向
            //该对象是不是该类型的小类型
            return false;
        }
        PokerCard other=(PokerCard)obj;
        return this.val==other.val&&
                this.color.equals(other.color);
        //String 是引用类型，不能直接判断是否相等,通过调用String类型的equals判断
    }

    public static void swap(ArrayList<PokerCard> card, int i, int j){

        PokerCard x=card.get(i);
        PokerCard y=card.get(j);
        card.set(i,y);
        card.set(j,x);

    }
    public static void main(String[] args) {
        ArrayList<PokerCard> cards = new ArrayList<>(52);
        String[] colors = {"♥", "♣", "♦", "♠"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokerCard card = new PokerCard(j, colors[i]);
                cards.add(card);
            }
        }
        Random random = new Random(20190820);
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, i, j);
        }
        // System.out.println(cards);
        System.out.println();
        ArrayList<PokerCard> A = new ArrayList<>();
        ArrayList<PokerCard> B = new ArrayList<>();
        ArrayList<PokerCard> C = new ArrayList<>();
        System.out.println(cards.subList(52 - 15, 52));
        //subList[ , )
        for (int i = 0; i < 15; i++) {
            PokerCard card = cards.remove(cards.size() - 1);
            switch (i % 3) {
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
                    break;
            }
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        PokerCard heartA = new PokerCard(6, "♦");
        for (PokerCard card : A) {
            if (card.equals(heartA)) {
                System.out.println("包含");
                 //A.remove(card);    //  这个不能删
            }
        }
        Iterator<PokerCard>it=A.iterator();
        while(it.hasNext()){
            PokerCard o=it.next();
            if(o.equals(heartA)){
                it.remove();
            }
        }
        if (A.contains(heartA)) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

            for(int i=0;i<A.size();i++){
            PokerCard o=A.get(i);
            if(o.equals(heartA)){
                A.remove(i);
            }
            }//可以删


        System.out.println(A);

        Iterator<PokerCard> it1 = A.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println();
        ListIterator<PokerCard> it2 = A.listIterator();
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.previous());
        //返回列表中的上一个元素，并向后移动光标位置。
        System.out.println(it2.next());
    }

}

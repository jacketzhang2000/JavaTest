package Test0820;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
public class Main {
    public static void swap(ArrayList<PokerDome> card, int i, int j) {
        PokerDome x = card.get(i);
        PokerDome y = card.get(j);
        card.set(i, y);
        card.set(j, x);

    }

    public static void main(String[] args) {
        ArrayList<PokerDome> crads = new ArrayList<>();
        String[] colors = {"♥", "♣", "♦", "♠"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokerDome crad = new PokerDome(j, colors[i]);
                crads.add(crad);

            }
        }
        System.out.println(crads);
        Random random = new Random(20190820);
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(crads, i, j);
        }
        System.out.println();
        System.out.println(crads.subList(52 - 15, 52));
        ArrayList<PokerDome> A = new ArrayList<>();
        ArrayList<PokerDome> B = new ArrayList<>();
        ArrayList<PokerDome> C = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            PokerDome card = crads.remove(crads.size() - 1);
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
        PokerDome fapa = new PokerDome(1, "♠");
        if(C.contains(fapa)){
            System.out.println("找到了");
            C.remove(fapa);
        }
        else{
            System.out.println("没找到");
        }
        for (PokerDome card : C) {
            if (card.equals(fapa)) {
                System.out.println("包含");
                C.remove(card);
            }
        }
        System.out.println(C);

        System.out.println();
        Iterator<PokerDome> it=A.iterator();
        PokerDome fapa1 = new PokerDome(10, "♣");
        while(it.hasNext()){
            PokerDome o=it.next();
            if(o.equals(fapa1))
            it.remove();
        }
        System.out.println(A);

    }



}

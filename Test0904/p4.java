package Test0904;

import java.util.*;

public class p4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String ex=scanner.nextLine();
        String ac=scanner.nextLine();
        Set<Character> set=new HashSet<>();
        char[] a=ex.toUpperCase().toCharArray();
        char[] b=ac.toUpperCase().toCharArray();

        for(Character c:b){
            set.add(c);
        }
        Set<Character> retur=new HashSet<>();
        for(Character c:a){
            if(!set.contains(c)){
                retur.add(c);
            }
        }
        System.out.println(retur);
    }
}

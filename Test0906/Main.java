package Test0906;

import Test0819.Solution;

public class Main {
    public static void main(String[] args) {
        String s="900 google.mali.com";
        String[] t=s.split(" ");
        System.out.println(t[0]);
        System.out.println(t[1]);
//返回一个 Integer对象，保存指定的值为 String 。
        int n=Integer.valueOf(t[0]);
        String [] u=t[1].split("\\.");
        System.out.println(u[0]);
        System.out.println(u[1]);
        System.out.println(u[2]);
        String[] v={"google","com"};
        String w=String.join(".",v);
        System.out.println(w);
    }
}

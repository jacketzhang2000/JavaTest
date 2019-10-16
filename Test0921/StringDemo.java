package Test0921;

public class StringDemo {
    public static void main(String[] args) {
        String s="hello";
        String m=s.toUpperCase();
        String n=s.substring(1,3);
        System.out.println(s==m);
        System.out.println(s==n);
        constantDemo();
    }
    public static void constantDemo(){
        String s="hello";
        String m="hello";
        System.out.println(m.equals(s));
        System.out.println(m==s);
    }
}

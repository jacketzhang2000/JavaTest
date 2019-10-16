package Test0921;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class MyString implements Comparable <MyString>{
    //public 的方法先写
    private  final char[] value;
    //复制数组可以保证不被泄露
    public MyString(char value[]){
        this.value= Arrays.copyOf(value,value.length);
    }
    public MyString (char value[],int offset,int count){
        this.value=Arrays.copyOfRange(value,offset,offset+count);
    }
//这里的引用泄露没有问题，因为新的对象也不会去修改val值
    public MyString (MyString s){
        this.value=s.value;
    }
    static List<MyString> pool=new ArrayList<>();
    //自动入池
    public static MyString literal(MyString s) {
        for (MyString ms : pool) {
            if (ms.equals(s)) {
                return ms;
            }
        }
        MyString rs = new MyString(s);
        pool.add(rs);
        return rs;

    }
    //手动入池
    public MyString intern(){
       for(MyString ms:pool){
           if(ms==this){
               return ms;
           }
       }
       MyString rs=new MyString(this);
       pool.add(rs);
       return rs;
    }

    public char charAt(int index){
        return value[index];
    }
    //不能直接返回引用，防止引用被泄露
    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }
    @Override
    public int compareTo(MyString o) {
        if (o == null) {
            return 1;
        }
        int length = Math.min(value.length, o.value.length);
        for (int i = 0; i < length; i++) {
            char a = value[i];
            char b = o.value[i];
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        if(value.length>o.value.length){
            return 1;
        }else if(value.length<o.value.length){
            return -1;
        }else return 0;

    }

    @Override
    public int hashCode() {
        int hash =0;
        for(char c: value){
            hash=(hash ^c);
        }
        return hash;
    }
    public MyString subString(int begin,int end){
        return new MyString(value,begin,end-begin);
    }

    @Override
    public boolean equals(Object s){
        /*
        1.判断引用是否指向同一个对象
        2.s是不是空
        3.s是不是mystring类型的对象
        4.比较属性的相等性
         */
        if(this==s){
            return true;
        }
        if(s==null){
            return false;
        }
        //gercalss返回此 Object的运行时类。s.getClass()==getClass()
        if(!(s instanceof MyString)){
            return false;
        }
        return Arrays.equals(value,((MyString) s).value);
    }
    public MyString toUpper(){
        MyString s=new MyString(value);
        for(int i=0;i<s.value.length;i++){
            if(s.value[i]>='a'&&s.value[i]<='z'){
                s.value[i]=(char)(s.value[i]-32);
            }
        }
        /*
        1。构造一个新对象
        2.遍历新对象的val
        3.把小写字母变成大写字母
        4.返回新对象
         */
        return s;
}
    public MyString toLower() {
        MyString s = new MyString(value);
        for (int i = 0; i < s.value.length; i++) {
            if (s.value[i]>='A'&& s.value[i]<='Z'){
                s.value[i]=(char)(s.value[i]+32);
            }
        }
        return s;
    }
    public boolean equalsIgnoreCase(MyString s){
        /*
        return toUpper().equals(s.toUpper());
    */
        if(s==null){
            return false;
        }
        if(value.length!=s.value.length){
            return false;
        }
        for(int i=0;i<s.value.length;i++){
            char a=value[i];
            char b=s.value[i];
            if(a==b){
                continue;
            }
            if(a>='a'&&a<='z'){
                a+=('A'-'a');
                if(a==b){
                    continue;
                }
            }else if(a>='A'&& a<='Z'){
                a+=('a'-'A');
            }if(a==b){
                continue;
            }
            else return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new String(value);
    }

    public static void main(String[] args) {
        char[] a={'A','b','c'};
        MyString b=new MyString(a);
        MyString c=new MyString(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(b.equals(c));
        MyString d=b.toUpper();
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(b.equals(c));
        a[0]='s';
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(b.equals(c));
        MyString e=c.toLower();
        System.out.println(e);
    }
}

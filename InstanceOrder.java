class Parent2{
    {
        System.out.println("A");
    }//无静态代码块，直接执行非静态代码块
    //无论产生多少实例化对象，静态代码块都只执行一次
    Parent2(){
        System.out.println("B");
    }
    {
        System.out.println("C");
    }


}
public class InstanceOrder extends Parent2{
    InstanceOrder(){
        super();
        System.out.println(1);
    }
    InstanceOrder(int v){
        this();
        //调用无参的构造方法
        System.out.println(2);
    }
    private int initA(){
        System.out.println(3);
        return 0;
    }
    private int initB(){
        System.out.println(4);
        return 0;
    }
    int a =initA();
    {
        System.out.println(5);
    }
    int b=initB();
    {
        System.out.println(6);
    }

    public static void main(String[] args) {
       new InstanceOrder(100);
       new InstanceOrder(10);
    }





}

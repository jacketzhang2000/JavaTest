class HelloA {
    //一个文件中只能有一个public 类
    public HelloA(){
        System.out.println("A的构造方法");
    }
    {
        System.out.println("A的非静态代码块");
    }
    static {
        System.out.println("A的静态代码块");
    }
    //无论产生多少实例化对象，静态代码块都只执行一次
    //静态块的主要作用是对static 属性初始化
}
public class HelloB extends HelloA{
    public HelloB() {
        System.out.println("B的构造方法");
    }

    {
        System.out.println("B的非静态代码块");
    }

    static {
        System.out.println("B的静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("start");
        new HelloB();
        new HelloB();
        System.out.println("end");
    }
}
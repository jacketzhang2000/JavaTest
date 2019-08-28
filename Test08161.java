/*
class outter{
    private String outname;
    private int outage;
    class Inner{
        private int Inage;

        public Inner(){
            outter.this.outname="I am a outter class";
            outter.this.outage=20;
        }
        public void display(){
            System.out.println(outname);
            System.out.println(outage);
            //内部类可以直接访问外部类的元素

        }
    }
}
public class Test08161 {
    public static void main(String[] args) {
    //创建对象格式：
    //          外部类.内部类 内部类对象=new 外部类().new 内部类();
        outter.Inner inner=new outter().new Inner();
        inner.display();
    }
}
*/
class Outter{
    public void display(){
        Inner inner=new Inner();
        inner.display();
        //外部类可以间接引用内部类
    }
    class Inner{
        public void display(){
            System.out.println("I am a student");
        }
    }

    public static void main(String[] args) {
        Outter outter=new Outter();
        outter.display();
    }
}

abstract class Person{
    private String name;
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void getPersonInfo();
}
class Student extends Person{
    public void getPersonInfo(){
        System.out.println("I am a student");
    }
}
public class Test0815 {
    public static void main(String[] args) {
        Person per=new Student();
        per.getPersonInfo();
    }
}
/*
abstract class Person{
    private String name;
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void getPersonInfo();
    public static Person getInstance() {
        class Student extends Person {
            public void getPersonInfo() {
                System.out.println("I am a student");
            }
        }
        return new Student();
    }
}
public class Test0815 {
    public static void main(String[] args) {
        Person per=Person.getInstance();
        per.getPersonInfo();
    }
}
 */

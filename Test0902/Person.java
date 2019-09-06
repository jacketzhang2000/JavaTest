package Test0902;

public class Person implements Comparable<Person>{
    public String name;
    public int age;
    public int sex;
    public int rank;

    /**
     *
     * @param o
     * @return如果小于0，指this指向的对象小于o指向的对象
     * 如果等于0，指this指向的对象等于o指向的对象
     * 如果大于0，指this指向的对象等于o指向的对象
     */
    @Override
    public int compareTo(Person o) {
        if(age<o.age){
            return -1;
        }
        else if(age==o.age){
            return 0;
        }
        else return 1;
    }

    @Override
    public String toString() {
        return String.format("Person+{%d}",age);
    }
}

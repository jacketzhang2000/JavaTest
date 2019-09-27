package Test0909;

import java.util.Comparator;
import java.util.TreeMap;

class person implements Comparable<person>{
   public String name;
    person(String name){
        this.name=name;
    }


    @Override
    public int compareTo(person o) {
        return name.compareTo(o.name);
    }
}
class contact{
    String phone;
    String adress;
    contact(String phone,String adress){
        this.adress=adress;
        this.phone=phone;
    }
}
class PersonCompator implements Comparator<person>{

    @Override
    public int compare(person o1, person o2) {
        return o1.name.compareTo(o2.name);
    }

}
public class TreeMapDemo{
    public static void main(String[] args) {
        TreeMap<person,contact> map=new TreeMap<>();
        person per=new person("zyy");
        contact con=new contact("183","大学");
        map.put(per,con);
        TreeMap<String,Integer> map1=new TreeMap<>();
        TreeMap<String ,Integer> map2=new TreeMap<>();
        System.out.println(map.keySet());

    }
}

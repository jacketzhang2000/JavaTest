package Test0920;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class student{
    int sex;
    String major;
    student (){}
    student(int sex,String major){
        this.major=major;
        this.sex=sex;
    }

}
public class p2 {
private static void test1(student student){
    String[] majors={"计算机","网工"};
    student s1=new student(1,"计算机");
    student s2=new student(0,"网工");
    student s3=new student(0,"计算机");
    student s4=new student(1,"网工");
    student s5=new student(0,"计算机");
    student[] s={s1,s2,s3,s4,s5};
    statistics(s,majors);
}
    private static void test2(student student) {
    student[] s=new student[1000];
    String[] majors={"计算机","网工","物联网"};

        Random random=new Random(20190921);
        for(int i=0;i<1000;i++){
            int m=random.nextInt(3);
            int se=random.nextInt(2);
            s[i]=new student(se,majors[m]);
        }
        statistics(s,majors);
    }
    public static void main(String[] args) {
        test1(new student());
        System.out.println();

        test2(new student());
    }

    private static void statistics(student[] s,String[] majors) {
        Map<String ,int[]> map=new HashMap<>();
        for(String major:majors){
            map.put(major,new int[2]);
        }
        for(student t:s){
            map.get(t.major)[t.sex]++;
           }
           for(Map.Entry<String,int[]> e:map.entrySet()){
            String key=e.getKey();
            int[] val=e.getValue();
               System.out.printf("专业：%s ,男生：%d,女生：%d%n",key,val[0],val[1]);
        }
    }

}

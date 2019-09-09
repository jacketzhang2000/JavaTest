package Test0904;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    //找出单身数
    public static Map<Integer,Integer> count(int[] numbers){
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:numbers){
            //如果在，出现次数加一，不在，出现次数是1
            int c=map.getOrDefault(n,0);
            map.put(n,c+1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] a={1,5,2,4,1,4,2,6,5};
        Map<Integer,Integer> map=count(a);
        //遍历map的三种方式
        //keySet();取出所有的key所有的数字
        //values(); 取出所有的value所有的数字

       for(Integer i:map.keySet()){
           int c=map.getOrDefault(i,0);
           if(c==1){
               System.out.println(i);
           }
       }
        /*
         //entrySet（）;  取出所有的数字及键值对
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int number=entry.getKey();
            int cnt=entry.getValue();
            if(cnt==1){
                System.out.println(number);
            }
        }
        */

        //System.out.println(map);
    }
}

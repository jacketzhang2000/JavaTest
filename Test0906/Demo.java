package Test0906;

import java.util.*;

public class Demo {

    public static List<String> subdomainVisits(String[] cpdomains){
        Map<String, Integer> count=new HashMap<>();
        for(String cp:cpdomains) {
            String[] t = cp.split(" ");
            int n = Integer.valueOf(t[0]);
            String domain = t[1];

            String[] s = domain.split("\\.");
            for (int i = 0; i < s.length; i++) {
                String[] sub = Arrays.copyOfRange(s, i, s.length);
                String d = String.join(".", sub);

                int oldCount=count.getOrDefault(d,0);
                count.put(d,oldCount+n);
            }
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> map:count.entrySet()){
            String a=map.getKey();
            Integer b=map.getValue();
            result.add(a+" "+b);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] s={"900 google.mali.com","50 baidu.com","1 intel.com"};
        List<String>a=subdomainVisits(s);
        System.out.println(a);

    }
}

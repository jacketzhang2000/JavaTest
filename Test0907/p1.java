package Test0907;

import java.util.*;

public class p1 {
    public List<String> commonChars(String[] A) {
        List<String > list=new ArrayList<>();
        int[] res=new int[26];
        for(char a:A[0].toCharArray()){
            res[a-'a']++;
        }
        for(int i=1;i<A.length;i++){
            int[] temp=new int[26];
            for(char a:A[i].toCharArray()){
                temp[a-'a']++;
            }
            for(int j=0;j<26;j++){
                res[j]=Math.min(res[j],temp[j]);
            }
        }
        for(int i=0;i<res.length;i++){
            if(res[i]>0){
                for(int j=0;j<res[i];j++){
                    list.add((char) ('a'+i)+"");
                }
            }
        }
        return list;
    }

    /**
     * 1.统计每个单词中，每个字母的出现次数
     * 2.
     * 3.
     * 4.
     * @param A
     * @return
     */
    public static List<String> commonChars1(String[] A) {
        List<Map<Character,Integer>> counts=new ArrayList<>();
        for(String s:A){
            Map<Character,Integer> map=new HashMap<>();
            //toCharArray切割字符串
            for(char c:s.toCharArray()){
                int n=map.getOrDefault(c,0);
                map.put(c,n+1);
            }
            counts.add(map);
        }
        System.out.println(counts);
        List<String> result=new ArrayList<>();
        for(char c:counts.get(0).keySet()) {
            boolean allCounts = true;
            for (int i = 0; i < counts.size(); i++) {
                Map<Character, Integer> map = counts.get(i);
                if (!map.containsKey(c)) {
                    allCounts = false;
                    break;
                }
            }
            if (!allCounts) {
                continue;
            }

            int min = counts.get(0).get(c);
            for(int i=1;i<counts.size();i++){
                int n=counts.get(i).get(c);
                if(min>n){
                    min=n;
                }
            }
            for(int i=0;i<min;i++){
                result.add(c+"");
            }
        }
        return result;
    }
    public static List<String> commonChars2(String[] A){
        List<int[]> counts=new ArrayList<>();
        for(String s:A){
            int[] a=new int[26];
            for(char c:s.toCharArray()){
                int index=c-'a';
                a[index]++;
            }
            counts.add(a);
        }
        int[] r=new int[26];
        for(int i=0;i<26; i++){
            int n=Integer.MAX_VALUE;
            for(int[] a:counts){
                n=Math.min(n,a[i]);
            }
            r[i]=n;
        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(r[i]>0){
                for(int j=0;j<r[i];j++) {
                    char c = (char) ('a' + i);
                    result.add(c + "");
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] a={"bella","label","robller"};
        List<String > list=new p1().commonChars(a);
        System.out.println(list);
        String[] b={"bella","label","robller"};
        System.out.println(commonChars1(b));
        String[] c={"bella","label","robller"};
        System.out.println(commonChars2(c));
    }
}

package Test0904;

import java.util.*;

public class p5 {
    public static class StringCompartor implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public static Map<String,Integer> count(String[] words){
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            int c=map.getOrDefault(s,0);
            map.put(s,c+1);
        }
        return map;
    }
    public static Map<Integer,List<String >> remap(Map<String ,Integer> w) {
        Map<Integer,List<String >> countWorld=new HashMap<>();
        for(Map.Entry<String,Integer> e:w.entrySet()) {
            String word = e.getKey();
            int count = e.getValue();

            List<String> wordList = countWorld.get(count);
            if(wordList==null){
                wordList=new ArrayList<>();
                countWorld.put(count,wordList);
            }
            wordList.add(word);
        }
        return countWorld;
    }

    public static List<String> topK (String[] words,int k) {
       // 1. 统计每个单词出现的数目，  wordToCount
        Map<String,Integer> wordToCount=count(words);
        // 2.得到，每个出现的次数下，对应的单词，countToWord
        Map<Integer,List<String >> countToWord=remap(wordToCount);
        Set<Integer> keys=countToWord.keySet();
        int[] counts=new int[keys.size()];
        int i=0;
        for(int key:keys){
            counts[i++]=key;
        }
        Arrays.sort(counts);
        int j=0;
        int index=counts.length-1;
        Comparator<String> comparator=new StringCompartor();
        List<String> result=new ArrayList<>();
        while(j<k) {
            int c = counts[index--];
            List<String> list=countToWord.get(c);
           list.sort(comparator);
           if(list.size()<=k-j){
               result.addAll(list);
               j+=list.size();
           }else{
               result.addAll(list.subList (0,k-j));
               break;
           }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {
                "i", "love", "leetcode",
                "i", "love", "coding"
        };
        List<String> r = topK(words, 3);
        System.out.println(r);
    }
}

package Test0819;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<List<Integer>> getnum (int numRows){

        List<List<Integer>> list =new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i=2;i<numRows;i++){
            List<Integer> nums=list.get(i);
            nums.add(1);
            for(int j=1;j<i;j++){
                int num=list.get(i-1).get(j-1)
                        +list.get(i-1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }

    private static void disPlay(Solution s,int numRows) {
        System.out.println(s.getnum(numRows).toString());
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        disPlay(solution,5);
    }
    /*
    public List<List<Integer>>generate (int numRows){
        List<List<Integer>> list=new ArrayList<>(numRows);
        //List 类型的接口引用
        //元素类型是Integer类类型的引用
        //Integer是int 的包装类
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>(i+1));
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i=2;i<numRows;i++){
            List<Integer>nums=list.get(i);
            nums.add(1);
            for (int j=1;j<i;j++){
                int num=list.get(i-1).get(j-1)
                +list.get(i-1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }
    private  static void printPascalsTriangle(Solution s,int numRows){
        System.out.println(s.generate(numRows));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution,5);
        printPascalsTriangle(solution,10);
    }
    */
}

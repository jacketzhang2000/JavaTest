package Test0821;

import java.util.ArrayList;

public class Solution {
    public boolean match(char left,char right){
        if(left=='{'&&right=='}'){
            return true;
        }
        if(left=='['&&right==']'){
            return true;
        }
        if(left=='('&&right==')'){
            return true;
        }
        return false;
    }
    public boolean isValid(String s){
        ArrayList<Character> Stack =new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //返回 char指定索引处的值。

            switch (ch){
                case '{':
                case '[':
                case '(':
                    Stack.add(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(Stack.isEmpty()){
                        return false;
                    }else{
                        char left= Stack.remove(Stack.size()-1);
                        if(!match(left,ch)){
                            return false;
                        }
                        break;
                    }
            }
        }
        if(!Stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String x="([]{})";
        String y="{}[}";
        System.out.println(solution.isValid(x));
        System.out.println(solution.isValid(y));
    }

}


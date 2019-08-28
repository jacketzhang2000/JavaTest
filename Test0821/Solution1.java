package Test0821;

import java.util.ArrayList;

public class Solution1 {
    public boolean san(int x, int y, int z) {
        if (x + y < z || x + z < y || y + z < x || x - y > z || x - z > y || y - z > x) {
            return false;
        } else return true;
    }

    public int longer(int[] s) {
        ArrayList<Integer> Stack = new ArrayList<>();
        int size = s.length - 1;
        for (int i = 0; i < size; i++) {
            if (Stack.size() < 3) {
                Stack.add(s[i]);
                System.out.println(Stack.size());
            } else {
                int l = Stack.remove(Stack.size() - 1);
                if (s[i] > l) {
                    Stack.remove(l);
                    Stack.add(s[i]);
                }
            }
        }
            int x = Stack.remove(Stack.size()-1);
            int y = Stack.remove(Stack.size()-1);
            int z = Stack.remove(Stack.size()-1);
            if (san(x, y, z)) {
                System.out.println(san(x,y,z));
                return x + y + z;
            }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 s=new Solution1();
        int[] x={3,4,5};
        System.out.println(s.longer(x));
    }
}

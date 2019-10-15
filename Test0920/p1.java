package Test0920;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int x=scanner.nextInt();
        System.out.println(shengxiao(x));

    }

    private static char shengxiao(int x) {
        char[] shen={'猴','鸡','狗','猪','鼠','牛','虎','兔','龙','蛇','马','羊'};
        x=x%12;
        return shen[x];
    }
}

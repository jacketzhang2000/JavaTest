//package basic_practice;
import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.Scanner;
public class shuzu {
    public static void main(String[] args) {
        int a[][] = new int[100][100];
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        //跳过这行换行符
        int j = 0;
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String strLine = in.nextLine();
            Scanner s = new Scanner(strLine);
            while (s.hasNextInt()) {
                a[i][j++] = s.nextInt();
            }
        }
        int x = in.nextInt();
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int s = 0; s < j; s++) {
                while (a[i][s] == x)
                    m++;
            }
        }
        if (m != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

package Test0825;

import java.util.Scanner;

public class MyScanner {
    private static Trees.ReturnValue bulidTree(char[] preorder){
        return null;
    }
    private static void inorderTraver(Node root){
        if(root==null){
            return ;
        }
        inorderTraver(root.left);
        System.out.println(root.val+"");
        inorderTraver(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String pre=scanner.nextLine();
        char[] preorder=pre.toCharArray();
        Trees.ReturnValue RV=bulidTree(preorder);
        inorderTraver(RV.root);
    }
}

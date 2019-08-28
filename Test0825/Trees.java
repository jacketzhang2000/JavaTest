package Test0825;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Node {
    int val;
    Node left=null;
    Node right=null;
    Node(char val){
        this.val=val;
    }
    public Node(){}
    Node (char val,Node left,Node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class Trees {
    public  static Node buildTree1(){
        Node h=new Node('H',null,null);
        Node g=new Node('G',null,null);
        Node f=new Node ('F',null,null);
        Node e=new Node ('E',null,h);
         Node d=new Node('D',null,null);
        Node c=new Node('C',f,g);
        Node b=new Node('B',null,e);
        Node a=new Node('A',b,c);
        return a;
    }
    public static class ReturnValue {
        Node root;
        int used;
    }
    public static ReturnValue buildTreePreorder(List<Integer> preorder) {
        if (preorder.size() == 0) {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;

            return rv;
        }
        int rootValue = preorder.get(0);
        if (rootValue == '#') {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 1;
            return rv;
        }
        ReturnValue leftRV = buildTreePreorder(
                preorder.subList(1, preorder.size()));
        ReturnValue rightRV = buildTreePreorder(
                preorder.subList(1 + leftRV.used, preorder.size()));

        Node root = new Node();
        root.val = rootValue;
        root.left = leftRV.root;
        root.right = rightRV.root;

        ReturnValue rv = new ReturnValue();
        rv.root = root;
        rv.used = 1 + leftRV.used + rightRV.used;

        return rv;
    }
    public static ReturnValue bulidTreePreOrder(List<Integer> preorder) {
        if (preorder.size() == 0) {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;
            return rv;
        }
        int rootVal = preorder.get(0);
        if (rootVal == '#') {
            ReturnValue rv = new ReturnValue();
            rv.root=null;
            rv.used=1;
            return rv;
        }
        ReturnValue leftRV=bulidTreePreOrder(
                //subList下标从1开始
                preorder.subList(1,preorder.size()));
        ReturnValue rightRV=bulidTreePreOrder(
                preorder.subList(1+leftRV.used,preorder.size()));
        Node root = new Node();
        ///root.val = rootVal;
        root.left = leftRV.root;
        root.right =rightRV.root;
        ReturnValue rv = new ReturnValue();
        rv.root = root;
        rv.used = 1 + leftRV.used + rightRV.used;
        return rv;
    }
    public static void preOrder(StringBuilder sb,Node root ){
        if(root==null){
            return ;
        }
        sb.append("(");
        sb.append(root.val);
        if(root.left==null&&root.right!=null){
            sb.append("()");
        }else{
            preOrder(sb,root.left);
        }
        preOrder(sb,root.right);
        sb.append(")");
    }
    public static String tree2str(Node t){
        if(t==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        preOrder(sb,t);
        String r=sb.toString();
        return r.substring(1,r.length()-1);
    }

    public static void main(String[] args) {
        List<Integer> preorder = Arrays.asList(
                1, 2, 3, (int)'#', (int)'#', (int)'#', 4, (int)'#', 5, (int)'#', (int)'#'
        );
        ReturnValue s=bulidTreePreOrder(preorder);

        System.out.println(tree2str(buildTree1()));
    }
}

package Test0823;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.SocketHandler;

public class Trees {
    public static Node buildTree(){
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');
        a.left=b;
        a.right=c;
        b.right=e;
        e.right=h;
        b.left=d;
        c.left=f;
        c.right=g;

        return a;
    }
    public static Node buildTree1(){
        Node h=new Node('H',null,null);
        Node g=new Node('G',null,null);
        Node f=new Node ('F',null,null);
        Node e=new Node ('E',null,h);
        Node d=new Node('D',null,null);
        Node c=new Node('C',f,g);
        Node b=new Node('B',d,e);
        Node a=new Node('A',b,c);

        return a;
    }
    private List<Character> list;
    static List<Character> l1 =new ArrayList<>();
    static List<Character> l2 =new ArrayList<>();
    static List<Character> l3 =new ArrayList<>();
    public void preOrder(Node root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public List<Character> preOrderTraversal3(Node root){
        list=new ArrayList<>();
        preOrder(root);
        return list;
    }
    public static List<Character> preOrderTraversal(Node root){
        if(root==null){
            return null;
        }
        Trees.l1.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return l1;
    }
    public static List<Character> preOrderTraversal2(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Character> l12=new ArrayList<>();
        List<Character> leftRoot=preOrderTraversal2(root.left);
        List<Character> rightRoot= preOrderTraversal2(root.right);
        l12.add(root.val);
        l12.addAll(leftRoot);
        l12.addAll(rightRoot);
        return l12;
    }
    public static List<Character> inOrderTraversal1(Node root){
        if(root==null){
            return null;
        }
        inOrderTraversal1(root.left);
        Trees.l2.add(root.val);
        inOrderTraversal1(root.right);
        return l2;
    }
    public static void inOrderTraversal0(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal0(root.left);
        System.out.print(root.val);
        inOrderTraversal0(root.right);
    }

    public static List<Character> postOrderTraversal1(Node root){
        if(root==null){
            return null;
        }
        postOrderTraversal1(root.left);
        postOrderTraversal1(root.right);
        Trees.l3.add(root.val);
        return l3;
    }

    public static void main(String[] args) {

        Node a=Trees.buildTree1();
       //System.out.println(preOrderTraversal(a));
       //函数内定义list   2
        System.out.println(preOrderTraversal2(a));
        Trees t=new Trees();
        //函数外部定义非静态的，利用List打印      3
        System.out.println(t.preOrderTraversal3(a));
        System.out.println();
        //函数外定义静态的，利用list打印  1
        //System.out.println(inOrderTraversal1(a));
        //直接打印   0
        inOrderTraversal0(a);
        System.out.println();
        System.out.println(postOrderTraversal1(a));
    }
}

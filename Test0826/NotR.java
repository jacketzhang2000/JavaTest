package Test0826;


import java.util.Stack;

public class NotR {
    //遍历的非递归写法
    public static void preorderNoR(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                System.out.print(cur.val+" ");
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
        System.out.println();
    }
    //中序
    public static void irorderNoR(Node root) {
        Stack<Node > stack = new Stack<>();
        Node cur=root;
        while(cur!=null|| !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node s=stack.pop();
            System.out.println(s.val);
            cur=s.right;
        }
    }
//后序非递归遍历
    public static void postorderNoR(Node root) {
        Stack<Node > stack=new Stack<>();
        Node cur=root;
        Node last=null;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.peek();
            if(top.right==null||top.right==last){
                stack.pop();
                System.out.print(top.val+" ");
                last=top;
            }
            else{
               cur=top.right;
                //下一个循环时，会以根节点入队列
            }
        }
    }
    public static void main(String[] args) {
        Node a=new Node(1);Node b=new Node(2);
        Node c=new Node(3);Node d=new Node(4);
        Node e=new Node(5);Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;b.left=d;c.left=e;b.right=f;c.right=g;
        preorderNoR(a);
        irorderNoR(a);
        postorderNoR(a);
    }
}

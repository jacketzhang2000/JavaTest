package Test0826;

import java.util.*;

class Element{
    Node node;
    int level;
        }
public class Main {

    //层序遍历且返回list
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Element> queue=new LinkedList<>();
        Element ro=new Element();
        ro.node=root;
        ro.level=0;
        queue.add(ro);
        while(!queue.isEmpty()){
            Element front =queue.poll();
            if(list.size()== front.level){
                list.add(new ArrayList<>());
            }
            list.get(front.level).add(front.node.val);
            if(front.node.left!=null){
                Element l=new Element();
                l.node= front.node.left;
                l.level= front.level+1;
                queue.add(l);
            }
            if(front.node.right!=null){
                Element r=new Element();
                r.node= front.node.right;
                r.level= front.level+1;
                queue.add(r);
            }
        }
        return list;
    }
    public static  boolean isCompleteTree(Node root){
        if(root==null){
            return true;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        //将元素入队列，只到有null
        while(true){
            Node front=q.poll();
            if(front==null){
                break;
            }
            front=front.left;
            front=front.right;
        }
        //判断后续是否还会有非空，有则不是完全二叉树，否则则是
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node!=null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node a=new Node(1);Node b=new Node(2);
        Node c=new Node(3);Node d=new Node(4);
        Node e=new Node(5);Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;b.left=d;c.left=e;b.right=f;c.right=g;
        System.out.println(levelOrder(a));
        System.out.println(isCompleteTree(a));
    }
}

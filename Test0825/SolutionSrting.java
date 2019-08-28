package Test0825;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionSrting {
    public static boolean search(Node root,Node n){
        if(root==null){
            return false;
        }
        if(root==n){
            return true;
        }
        if(search(root.left,n)){
            return true;
        }
        return search(root.right,n);
    }
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root==p&&root==q){
            return root;
        }
        boolean pInLeft=search(root.left,p);
        boolean qInLeft=search(root.left,q);
        if(pInLeft&&qInLeft)
        return lowestCommonAncestor(root.left,p,q);
        if(!pInLeft&&!qInLeft)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }
    public static void main(String[] args) {
        Node h=new Node('H',null,null);
        Node g=new Node('G',null,null);
        Node f=new Node ('F',null,null);
        Node e=new Node ('E',null,h);
        Node d=new Node('D',null,null);
        Node c=new Node('C',f,g);
        Node b=new Node('B',d,e);
        Node a=new Node('A',b,c);
        System.out.println(lowestCommonAncestor(a,b,c));

        //levelOrder(a);
    }

}

package Test0906;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class BinarySearchTree {
    public static class Node{
        int key;
        int val;

        Node left;
        Node right;

    }

    private Node root=null;
    public int get(int key){
        Node cur=root;
        while(cur!=null){
            if(key==cur.key){
                return cur.val;
            }
            else if(key>cur.key){
                cur=cur.right;
            }
            else{
                cur=cur.left;
            }
        }
        return -1;
    }
    public int put(int key,int val){
        if(root==null){
            root=new Node();
            root.key=key;
            root.val=val;
            return -1;
        }

        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){
                int oldValue=cur.val;
                cur.val=val;
                return oldValue;
            }
            else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        Node node=new Node();
        node.key=key;
        node.val=val;
        if(key<parent.key){
            parent.left=node;
        }
        else{
            parent.right=node;
        }
        return -1;
    }
    public int getOrDefault(int key,int defaultValue){
        Node cur=root;
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }
            else if(cur.key<key){
                cur=cur.right;
            }
            else {
                cur=cur.left;
            }
        }
        return defaultValue;
    }
    //层序遍历
    public Set<Integer> keySet(){
        Set<Integer> set=new HashSet<>();
        if(root==null){
            return set;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node front = queue.poll();
            set.add(front.key);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
        return set;
    }
    //中序遍历
    public Set<Integer> keySet2(){
        Set<Integer> set=new HashSet<>();
        inrderTraversal(set,root);
        return set;
    }
    private static void inrderTraversal(Set<Integer> set,Node n){
        if(n!=null){
            inrderTraversal(set,n.left);
            set.add(n.key);
            inrderTraversal(set,n.right);
        }
    }

    public static class Entry{
        private int key;
        private int val;

        public int getKey(){
            return key;
        }
        public int getVal(){
            return val;
        }
    }
    //Entry层序遍历
    public Set<Entry> entitySet(){
        Set<Entry> set=new HashSet<>();
        if(root==null){
            return set;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front= queue.poll();
            Entry entry=new Entry();
            entry.key=front.key;
            entry.val=front.val;
            set.add(entry);
            if(front.left!=null){
                queue.add(front.left);
            }if(front.right!=null){
                queue.add(front.right);
            }
        }
        return set;
    }
    //中序遍历Entry
    public Set<Entry> entrySet1(){
        Set<Entry> set=new HashSet<>();
        inrderTraversalEntry(set,root);
        return set;
    }

    private  void inrderTraversalEntry(Set<Entry> set, Node n) {
        if(n!=null){
            inrderTraversalEntry(set,n.left);
            Entry entry=new Entry();
            entry.val=n.val;
            entry.key=n.key;
            inrderTraversalEntry(set,n.right);
        }
    }

//删除
    public  int remove(int key){
        Node cur=root;
        Node parents=null;
        while(cur!=null){
            if(key==cur.key){
                int oldval=cur.val;
                deleteNode(parents,cur);
                return oldval;
            }
            else if(cur.key<key){
                parents=cur;
                    cur=cur.right;
            }else{
                parents=cur;
                cur=cur.left;
            }
        }
        return -1;
    }

    private void deleteNode(Node parents, Node cur) {
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }
            if(cur==parents.left){
                parents.left=cur.right;
            }else{
                parents.right=cur.right;
            }
        }
        else if(cur.right==null) {
            if (cur == root) {
                root = cur.left;
            }
            if (cur == parents.left) {
                parents.left = cur.left;
            } else {
                parents.right = cur.left;
            }
        }else{
            Node goat=cur.left;
            Node goatParent=cur;
            while(goat.right!=null){
                goatParent=goat;
                goat=goat.right;
            }
            cur.key=goat.key;
            cur.val=goat.val;

            if(goat==goatParent.left){
                goatParent.left=goat.left;
            }else{
                goatParent.right=goat.left;
            }
        }

    }

    //打印
    public static void preorderPrint(Node root){
        if(root!=null){
            System.out.print(root.key+" ");
            preorderPrint(root.left);
            preorderPrint(root.right);
        }
    }
    public static void main(String[] args) {

        BinarySearchTree b=new BinarySearchTree();
        int [] keys={6,7,4,2,1,5,9,3,8};

        for(int key:keys){
            b.put(key,key+100);
        }
        preorderPrint(b.root);
        System.out.println();
        inOrderPront(b.root);
        System.out.println();
        System.out.println(b.put(1,2));
        System.out.println(b.get(5));
    }

    private static void inOrderPront(Node root) {
        if(root!=null){
            inOrderPront(root.left);
            System.out.print(root.key+" ");
            inOrderPront(root.right);
        }
    }
}

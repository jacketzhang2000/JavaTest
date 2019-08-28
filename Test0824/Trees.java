package Test0824;

import java.util.Arrays;
import java.util.List;

public class Trees {
    public static Node bulidTrees(List<Character> preOrder, List<Character> inOrder){
        if(preOrder.size()==0){
            return null;
        }
        char rootOrder=preOrder.get(0);
        int rootinOrder=inOrder.indexOf(rootOrder);
        Node root=new Node(rootOrder);
        List<Character> leftPreOrder=preOrder.subList(1,rootinOrder+1);
        List<Character> leftInOrder=inOrder.subList(0,rootinOrder);
        Node left=bulidTrees(leftPreOrder,leftInOrder);
        root.left=left;
        List<Character> rightPreOrder=preOrder.subList(rootinOrder+1,preOrder.size());
        List<Character> rightInOrder=inOrder.subList(rootinOrder+1,inOrder.size());
        Node right=bulidTrees(rightPreOrder,rightInOrder);
        root.right=right;
        return root;
    }
    public static Node bulidTrees1(List<Character> inOrder,List<Character> postOrder){
        if(inOrder.size()!=postOrder.size()){
            return null;
        }
        if(inOrder.size()==0){
            return null;
        }
        char rootOrder=postOrder.get(postOrder.size()-1);
        int rootIndex=inOrder.indexOf(rootOrder);
        Node root=new Node(rootOrder);
        List<Character> leftInOrder=inOrder.subList(0,rootIndex);
        List<Character> leftPostOrder=postOrder.subList(0,rootIndex);
        Node left=bulidTrees1(leftInOrder,leftPostOrder);
        root.left = left;
        List<Character> rightInOrder=inOrder.subList(rootIndex+1,inOrder.size());
        List<Character> rightPostOrder=postOrder.subList(rootIndex,postOrder.size()-1);
        Node right=bulidTrees1(rightInOrder,rightPostOrder);
        root.right=right;
        return root;
    }
    public static Node bulid1(int[] inorder,int[] postorder){
        if(inorder.length==0){
            return null;
        }
        int rootVal=postorder[postorder.length-1];
        int leftcunt=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                leftcunt=i;
            }
        }
        int[] leftInOrder=Arrays.copyOfRange(inorder,0,leftcunt);
        int[] leftPostOrder=Arrays.copyOfRange(postorder,0,leftcunt);
        int[] rightInorder=Arrays.copyOfRange(inorder,leftcunt+1,inorder.length);
        int[] rightPostOrder=Arrays.copyOfRange(postorder,leftcunt,postorder.length-1);
        Node root=new Node(rootVal);
        root.left=bulid1(leftInOrder,leftPostOrder);
        root.right=bulid1(rightInorder,rightPostOrder);
        return root;

    }


    public static void main(String[] args) {
        List<Character> pre= Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        List<Character> in=Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        List<Character> post=Arrays.asList('D', 'G', 'E', 'B', 'H', 'F', 'C', 'A');
        Node s=bulidTrees(pre,in);
        System.out.println(s);
        Node x=bulidTrees1(in,post);
        System.out.println(x);
        System.out.println("成功");
        System.out.println();
        int[] l={4,2,5,1,6,3};
        int[] r={4,5,2,6,3,1};
        Node y=bulid1(l,r);
        System.out.println();

    }
}

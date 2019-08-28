package Test0823;

import java.util.ArrayList;
import java.util.List;

class treeNode{
    int val;
    treeNode left;
    treeNode right;
    treeNode(int val){
        this.val=val;
    }
    treeNode(int val,treeNode left,treeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class Solution{
    private List<Integer> list;
    public static treeNode buildTree1(){
        treeNode h=new treeNode('H',null,null);
        treeNode g=new treeNode('G',null,null);
        treeNode f=new treeNode ('F',null,null);
        treeNode e=new treeNode ('E',null,h);
        treeNode d=new treeNode('D',null,null);
        treeNode c=new treeNode('C',f,g);
        treeNode b=new treeNode('B',d,e);
        treeNode a=new treeNode('A',b,c);
        return a;
    }
    private void first(treeNode root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        first(root.left);
        first(root.right);
    }
    public List<Integer> pretree(treeNode root){
        list=new ArrayList<>();
        first(root);
        return list;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        treeNode a=buildTree1();
        System.out.println(s.pretree(a));
    }
}

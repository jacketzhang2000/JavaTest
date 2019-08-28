package Test0825;

public class solutionBalance {
    public  Node buildTree1(){
        Node h=new Node('H',null,null);
        Node g=new Node('G',null,null);
        Node f=new Node ('F',null,null);
        Node e=new Node ('E',null,h);
       // Node d=new Node('D',null,null);
        Node c=new Node('C',f,g);
        Node b=new Node('B',null,e);
        Node a=new Node('A',b,c);
        return a;
    }
    public int hight(Node root){
        if(root==null){
            return 0;
        }
        int left=hight(root.left);
        int right=hight(root.right);
        int max=Math.max(left,right);
        return max+1;
    }
    //判断是否是平衡二叉树
    public boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        boolean left=isBalanced(root.left);
        if(!left){
            return false;
        }
        boolean right=isBalanced(root.right);

        if(!right){
            return false;
        }
        int l=hight(root.left);
        int r=hight(root.right);
        if(l-r<-1&&l-r>1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solutionBalance s=new solutionBalance();
        Node a=s.buildTree1();
        System.out.println(s.isBalanced(a));
    }
}


package Test0824;

import java.util.List;

class Node {
    int val;
    Node left=null;
    Node right=null;
    Node(int val){
        this.val=val;
    }
    Node (int val,Node left,Node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class Main {
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
    public static Node buildTree2(){
        Node h=new Node('H',null,null);
        Node g=new Node('G',null,null);
        Node f=new Node ('F',null,null);
        Node e=new Node ('E',h,null);
        Node d=new Node('D',null,null);
        Node c=new Node('C',g,f);
        Node b=new Node('B',e,d);
        Node a=new Node('A',c,b);
        return a;
    }
    public static Node bulidTree3(){
        Node c=new Node('F',null,null);
        Node b=new Node('G',null,null);
        Node a=new Node('C',c,b);
        return a;

    }
    //节点个数
    public static int count=0;
    public static void calcCount1(Node root){
        if(root==null){
            return ;
        }
        count++;
        //遍历思想
        calcCount1(root.left);
        calcCount1(root.right);
    }
    public static int calcCount2(Node root){
        if(root==null){
            return 0;
        }
        int left=calcCount2(root.left);
        int right=calcCount2(root.right);
        int count=1+left+right;
        //汇总思想
        return count;
    }
    //叶子节点个数
    public static int leafcount=0;
    public static void calcleafCount3(Node root){
        if(root==null){
            return ;
        }
        //代表是叶子节点
        if(root.left==null&&root.right==null){
            leafcount++;

        }
        calcleafCount3(root.left);
        calcleafCount3(root.right);
    }
    public static int calcleafCount1(Node root){
        if(root==null){
            return 0;
        }
        //代表只有一个节点的数
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=calcleafCount1(root.left);
        int right=calcleafCount1(root.right);
        int count=left+right;
        return count;
    }
    //数的高度
    public static int calcHeight(Node root){
        if(root==null){
            return 0;
        }
        int left=calcHeight(root.left);
        int right=calcHeight(root.right);
        int max=Math.max(left,right)+1;
        return max;
    }
    //第K层节点数
    public static int calcKlevel(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int left=calcKlevel(root.left,k-1);
        int right=calcKlevel(root.right,k-1);
        int count=left+right;
        return count;
    }

    //查找
    public static Node search(Node root,char val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        Node left=search(root.left,val);
        if(left!=null){
            return left;
        }
        Node right=search(root.right,val);
        if(right!=null){
            return right;
        }
        return null;
    }

    //查找
    public static boolean search1(Node root,char val){
        if(root==null){
            return false;
        }
        if(root.val==val){
            return true;
        }
        if(search1(root.left,val)){
            return true;
        }
        return search1(root.right,val);

        //if(search1(root.right,val)) {
         //   return true;
        //}
       // return false;


    }
    //相同的树
    public static boolean isSameTree(Node r1,Node r2){
        if(r1==null&&r2==null){
            return true;
        }else if(r1==null||r2==null){
            return false;
        }
        return r1.val==r2.val&&
                isSameTree(r1.left,r2.left)&&
                isSameTree(r1.right,r2.right);
    }

    //镜像树
    public static boolean isMirror(Node p,Node q){
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }return p.val==q.val&&
                isMirror(q.left,p.right)&&
                isMirror(q.right,p.left);
    }
    //一棵树是否是对称的
    public static boolean isSymmetric(Node root){
        if(root==null){
            return false;
        }
        return isSymmetric(root.right)==isSymmetric(root.left);
    }
    //572另一个树的子树(搜索子树）
    public static boolean isSubTree(Node root,Node q){
        if(root==null){
            return false;
        }
        if(root.val==q.val){
            if(isSameTree(root,q)) {
                return true;
            }
        }
        if(isSubTree(root.left,q)){
            return true;
        }
        return isSubTree(root.right,q);
    }
    public static void main(String[] args) {

        Node a=buildTree1();
        Node b=buildTree2();
        Node c=bulidTree3();
        count=0;
        calcCount1(a);
        System.out.println(count);
        System.out.println(calcCount2(a));
        System.out.println();
        calcleafCount3(a);
        System.out.println(leafcount);
        System.out.println(calcleafCount1(a));
        System.out.println();
        System.out.println(calcKlevel(a,3));
        System.out.println();
        System.out.println(calcHeight(a));
        System.out.println(search(a,'H'));
        System.out.println();
        System.out.println(search1(a,'H'));
        System.out.println(isSameTree(a,b));
        System.out.println(isMirror(a,b));
        System.out.println(isSymmetric(c));
        System.out.println(isSubTree(a,c));
    }
}


package Test0824;

public class Test {
    //节点个数2
    static int count=0;
    public static void calcCount1(Node root){
        if(root==null){
            return ;
        }
        count++;
        calcCount1(root.left);
        calcCount1(root.right);
    }
    public static int calcCount2(Node root){
        if(root==null){
            return 0;
        }
        int l=calcCount2(root.left);
        int r=calcCount2(root.right);
        return l+r+1;
    }
    //叶子节点个数 2
    static int count1=0;
    public static void calcleafCount1(Node root){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            count1++;
            return ;
        }
        calcleafCount1(root.left);
        calcleafCount1(root.right);
    }
    public static int calcleafCount2(Node root){
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        int l=calcleafCount2(root.left);
        return 0;
    }
    //树的高度
    public static int calcHeight(Node root) {
        return 0;
    }
    //第k层节点数
    public static int calcKlevel(Node root,int k){
        return 0;
    }
    //查找 2(返回类型不同）
    public static Node search1(Node root,char val){
        return null;
    }
    public static boolean search2(Node root,char val){
        return false;
    }
    //相同的树
    public static boolean isSameTree(Node r1,Node r2){
        return false;
    }
    //镜像树
    public static boolean isMirror(Node p,Node q){
        return false;
    }
    //一颗树是否是对称的
    public static boolean isSymmetric(Node root){
        return false;
    }
    //一棵树是否是另一棵的子树
    public static boolean isSubTree(Node root,Node q){
        return false;
    }

    public static void main(String[] args) {

    }


}

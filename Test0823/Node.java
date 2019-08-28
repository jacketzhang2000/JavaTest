package Test0823;

public class Node {
    char val;
    Node left=null;
    Node right=null;
    Node(char val){
        this.val=val;
    }
    public Node(){}
    Node (char val,Node left,Node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

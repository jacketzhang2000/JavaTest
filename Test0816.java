class Node {
    public int val;
    public Node next=null;
    public Node (int val){
        this.val=val;
    }
    public Node (int val,Node next){
        this(val);
        this.next=next;
    }
    @Override
    public String toString() {
        return "node{"+
                "val"+val+
                "}";
    }
}

public class Test0816 {
    public static Node creatA() {
        Node n1=new Node (6);
        Node n2=new Node (5);
        Node n3=new Node (2);
        Node n4=new Node (3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;
    }
    public static Node creatB() {
        Node n1=new Node (4);
        Node n2=new Node (6);
        Node n3=new Node (9);
        Node n4=new Node (10);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;
    }
    public Node heBing(Node headA,Node headB){
        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }
        Node curA=headA;
        Node curB=headB;
        Node newnode=null;
        Node last=null;
        while(curA!=null&&curB!=null){
            if(curA.val<=curB.val){
                Node next=curA.next;
                if(newnode==null){
                    newnode=curA;
                }else{
                    curA.next=null;
                    last.next=curA;
                }
                last=curA;
                curA=next;
            }else {
                Node next = curB.next;
                if (newnode == null) {
                    newnode = curB;
                } else {
                    curB.next = null;
                    last.next = curB;
                }
                last = curB;
                curB = next;
            }
        }
        if(curA!=null){
            last.next=curA;
        }else{
            last.next=curB;
        }
        return newnode;
    }
    public Node separate(Node head,int value) {
        Node cur = head;
        Node small=null;
        Node smalllast=null;
        Node big=null;
        Node biglast=null;
        while(cur!=null) {
            if (cur.val <= value) {
                if (small == null) {
                    small = cur;
                } else {
                    smalllast.next = cur;
                }
                smalllast = cur;
            } else {
                if (big == null) {
                    big = cur;
                } else {
                    biglast.next = cur;
                }
                biglast = cur;
            }
            cur=cur.next;
        }
            if(small==null){
                return big;

            }
            else{
                smalllast.next=big;
                if(biglast!=null)
                biglast.next=null;
            }

        return small;
    }
    /*
    public Node cha(Node head,int value){
        Node cur=head;
        Node newNode=null;
        Node pre=null;
        pre.next=head;
        newNode.val=value;
        Node last=null;
        while(cur!=null){
            Node next=cur.next;
            if(cur.val<=value){
                cur.next=pre.next;
                pre.next=cur;
                cur=next;
            }
            else{

            }
        }
    }
    */
    public static void main (String[] args) {
        //Node headA= creatA();
        //Node headB=creatB();
        Node head=creatA();
        Node newNode=new Test0816().separate(head,4);
        //Node newNode=new Test0816().heBing(headA,headB);
        for(Node c=newNode;c!=null;c=c.next){
            System.out.println(c);
        }
    }
}

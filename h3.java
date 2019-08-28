class node {
    public int val;
    public node next=null;
    public node (int val){
        this.val=val;
    }
    public node (int val,node next){
        this(val);
        this.next=next;
    }
}
public class h3 {
    public static node creat() {
        node n1=new node (5);
        node n2=new node (7);
        node n3=new node (8);
        node n4=new node (9);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;
    }
    public  node reverse(node head){
        //遍历原链表
        //把每个节点头插到新链表上
        node car=head;
        node newNode=null;
        while(car!=null){
            node next=car.next;
            car.next=newNode;
            newNode=car;
            car=next;
        }
        return newNode;
    }

    public static void printlist(node head){
        node cur=head;
        while(cur!=null){
            System.out.print(cur.val+"-> ");
            cur=cur.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public static void main (String[] args) {
        node n1= creat();
        node newNode=new h3().reverse(n1);
        printlist(newNode);
    }
}

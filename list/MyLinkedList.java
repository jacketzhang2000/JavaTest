package list;
//双向不循环链表
//记录链表头和尾
public  class MyLinkedList implements List {
    private static class Node {
        private int val;
        private Node pre;
        private Node next;

        private Node(int val) {
            this.val = val;
        }

        private Node(int val, Node pre, Node next) {
            this(val);
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    Node head=null;
    Node last=null;
    private int size=0;

    @Override
    public boolean add(int element) {
        return add(size,element);
    }

    private Node getNode(int index) {
        if (index <=size/ 2) {
            Node cur = head;
            int i = 0;
            for (; i < index; i++, cur = cur.next) {
            }
            return cur;
        } else {
            Node cur = last;
            int i = 0;
            for (; i <size-index-1; cur = cur.pre,i++) {
            }
            return cur;
        }
    }
    @Override
    public boolean add(int index, int element) {
        //1.检查下标合法性
        if(index<0 || index>size){
            System.out.println("下标不合法");
            return false;
        }
        //2.找到index 位置的结点node
        if(index==0){
            head=new Node(element,null,head);
            if(head.next!=null){
                head.next.pre=head;
            }
            if(size==0){
                last=head;
            }
            size++;
            return true;
        }if(index==size) {
            last = new Node(element, last, null);
            if (last.pre != null) {
                last.pre.next = last;
            }
            if (size == 0) {
                head = last;
            }
            size++;
            return true;
        }

        Node node=getNode(index);
        //当index=0；需要特殊处理
        //3.把element装到节点里
        //4.node前区.next=element
        //5.element所在节点的next=node;
        Node newNode=new Node(element,node.pre,node);
        node.pre.next=newNode;
        node.pre=newNode;
        //6.size++
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        if(index<0 ||index>size){
            return -1;
        }
        Node node=getNode(index);
        return node.val;

    }

    @Override
    public int set(int index, int val) {
        if(index<0 ||index>size){
            return -1;
        }
        Node node=getNode(index);
        int value=node.val;
        node.val=val;
        return value;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        Node node = getNode(index);
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {

            last=node.pre;
        }
        size--;
        return node.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        String s="[";
        for(Node c=head;c!=null;c=c.next){
            s+=(c.val+",");
        }
        s+="]";
        //System.out.println(s.toString());
        return s;
    }
}

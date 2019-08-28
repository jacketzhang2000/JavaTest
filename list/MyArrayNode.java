package list;

public class MyArrayNode implements List {
    class NODE{
        public int val;
        public NODE next=null;
        public NODE(int val){
            this.val=val;
            this.next=next;
        }
    }
    int size=0;
    NODE head=null;
    @Override
    public boolean add(int element) {
        add(size,element);
        return true;
    }

    @Override
    public boolean add(int index, int element) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return false;
        }
        if(head==null){
            head=new NODE(element);
            size++;
            return true;
        }
        else {
            NODE cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            NODE newNode = new NODE(element);
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
            return true;
        }
    }

    @Override
    public int get(int index) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return -1;
        }
        int i = 0;
        NODE cur=head;
        for (; i <= index; i++, cur = cur.next) {
        }
        return cur.val;
    }

    @Override
    public int set(int index, int val) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return -1;
        }
        int i = 0;
        NODE cur=head;
        for (; i <= index; i++, cur = cur.next) {
        }
        int oldval=cur.val;
        cur.val=val;
        return oldval;

    }

    @Override
    public int remove(int index) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return -1;
        }
        int i = 0;
        NODE cur=head;
        for (; i <index; i++, cur = cur.next) {
        }
        int oldval=cur.next.val;
        cur.next=cur.next.next;
        return oldval;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(head==null){
            return false;
        }else return true;
    }

    @Override
    public String toString() {
        String r = "[";
        for (NODE c = head; c != null; c = c.next) {
            r += (c.val + ",");
        }
        r += "]";

        return r;
    }

    class MyIterator implements Iterator {
        NODE cur=head;
        @Override
        public boolean hasNext() {
            return cur!=null;
        }

        @Override
        public int next() {
            int val=cur.val;
            cur=cur.next;
            return val;
        }

        @Override
        public int remove() {
            return 0;
        }
    }
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
}

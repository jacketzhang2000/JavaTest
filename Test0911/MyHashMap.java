package Test0911;

public class MyHashMap<k,v> {
    private static class Node<M,N> {
        private M key;
        private N val;
        private Node<M,N> next;
    }
    private Node<k,v>[] array;
    private int size;

    public MyHashMap() {
        array = (Node<k,v>[])new Object[16];
        size = 0;
    }
    public v get(k key){
        int hash=key.hashCode();
        int n=array.length;
        hash=((hash>>16)^hash);
        int index=hash^(n-1);

        Node<k,v> head=array[index];
        Node <k,v> cur=head;
        while(cur!=null){
            if(key.equals(cur.key)){
                return cur.val;
            }
            cur=cur.next;
        }
        return null;
    }
}

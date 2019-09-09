package Test0904;

import sun.rmi.transport.proxy.CGIHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mian {
    static class Node {
        int val;
        Node random=null;
        Node next=null;
    }
    public static Node copyRandomList(Node head){
        Node cur=head;
        Node result=null;
        Node last=null;
        Map<Node,Node> map=new HashMap<>();
        while(cur!=null){
            Node q=new Node();
            q.val=cur.val;
            if(result==null){
                result=q;
            }
            else{
               last.next=q;
            }
            last=q;
            map.put(cur,q);
            cur=cur.next;
        }
        cur=head;
        Node q=result;
        while(cur!=null){
            q.random=map.get(cur.random);
            q=q.next;
            cur=cur.next;
        }
        return result;
    }
    public static int numIeweIsInStones(String j,String s){
        Set<Character> set=new HashSet<>();
        for(char ch:j.toCharArray()){
            set.add(ch);
        }
        int count=0;
        for(char st:s.toCharArray()){
            if(set.contains(st)){
                count++;
            }
        }
        return count;
    }

    public int remove(int key){
        return -1;
    }
    public static void main(String[] args) {

    }
}

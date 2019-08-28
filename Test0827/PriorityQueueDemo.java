package Test0827;
import java.util.*;
public class PriorityQueueDemo{
    public static void main(String[] args) {
        //优先级队列，该队列的头部是相对于指定顺序的最小元素。 PriorityQueue
        PriorityQueue<Integer> q1=new PriorityQueue<>();
        Queue<Integer> q2=new LinkedList<>();
        Random random=new Random(20170827);
        for(int i=0;i<10;i++){
            int n=random.nextInt(500);
            q1.add(n);
            q2.add(n);
        }
       while(!q1.isEmpty()){
           System.out.print(q1.poll()+" ");
       }
        System.out.println();
       while(!q2.isEmpty()){
           System.out.print(q2.poll()+" ");
       }


    }
}

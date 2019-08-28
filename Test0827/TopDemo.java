package Test0827;

import java.util.Arrays;
import java.util.Random;

public class TopDemo {
    public static void main(String[] args) {
        Random random=new Random(114158);
        int[] wulin=new int[100];
        for(int i=0;i<wulin.length;i++){
            wulin[i]=random.nextInt(1000);
        }
        int[] topk=findTopK(wulin,5);
        System.out.println(Arrays.toString(topk));
        System.out.println();
        Arrays.sort(wulin);
        System.out.println(Arrays.toString(Arrays.copyOfRange(wulin,wulin.length-10,wulin.length)));
    }
    public static int[] findTopK(int[] wulin ,int k){
        int[] heap=new int[k];
        for(int i=0;i<k;i++){
           heap[i]=wulin[i];
        }
        Heaps.creatHeapMin(heap,heap.length);
        for(int i=k;i<wulin.length;i++){
            if(wulin[i]>heap[0]){
                heap[0]=wulin[i];
                Heaps.heapifyMin(heap,k,0);
            }
        }
        return heap;
    }
}

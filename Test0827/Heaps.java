package Test0827;

import java.util.Arrays;

public class Heaps {
    /**
     * 前提：除了index和他的孩子外，其他的位置都满足堆的性质
     *
     * @param array 被看作堆的数组
     * @param szie   数组中被看作堆的值的个数
     * @param index   要调整的位置 的下标
     */
    //向下调整大堆
    public static void heapify(int[] array,int szie,int index){

        while(true){
        int left=2*index+1;
        if(szie<=left){
            return ;
        }
        int max=left;
        if(left+1<szie) {
            if (array[left + 1] > array[left]) {
                max = left + 1;
            }
        }
            if (array[index] >= array[max]) {
                return;
            }
            swap(array, index, max);
            index=max;

        }
    }
    private static void swap(int[] array,int index,int max){
        int count=array[index];
        array[index]=array[max];
        array[max]=count;
    }

    //利用数组建大堆
    public static void creatHeap(int[] array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array,size,i);
        }
    }
    //向上调整大堆
    public static void adjustUp(int[] array,int index){
        while (index>0){
        if(index==0){
            return ;
        }
        int cur=(index-1)/2;
            if(cur>=index){
                return ;
            }
            swap(array,cur,index);
            index=cur;
        }
    }
//构建小堆
    public static void creatHeapMin(int[] array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapifyMin(array,size,i);
        }
    }
    //向下调整小堆
    public static void heapifyMin(int[] array,int size,int index){

        while(true){
            int left=2*index+1;
            if (left > size) {
                return ;
            }
            int min=left;
            if(left+1<size&&array[left+1]<array[left]){
                min=left+1;
            }
            swap(array,index,min);
            index=min;
        }
    }
    public static void main(String[] args) {
        /*
        int[] array={-1,8,4,6,7,2,3,1,0};
        heapify(array,array.length,0);
        System.out.println(Arrays.toString(array));

*/
        int[] array1={3,5,2,4,9,0,1,9,8,4,7,2,3,8,6,3};
        creatHeap(array1,array1.length);
        System.out.println(Arrays.toString(array1));
    }
}

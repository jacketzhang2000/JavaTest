package Test0830;

import Test0821.Stack;

import java.util.Arrays;

public class Main {
    //快排非递归版
    public static void quickSortNoR(int[] array) {
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.empty()){
            int left=stack.pop();
            int right=stack.pop();
            if(left>right){
                continue;
            }
            int pivotIndex= Test0829.Main.partition2(array,left,right);
            stack.push(right);
            stack.push(pivotIndex+1);
            stack.push(pivotIndex-1);
            stack.push(left);

        }
    }
    //归并排序
    public static void mergeSort(int[] array){
        merageSortInternal(array,0,array.length);
    }

    private static void merageSortInternal(int[] array, int low, int high) {
        if(low+1>=high){
            return ;
        }
        int mid=(low+high)/2;
        merageSortInternal(array,low,mid);
        merageSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int length=high-low;
        int[] extra=new int[length];
        //[low,mid)
        //[mid,high)
        int iLeft = low;
        int iRight = mid;
        int iExtra=0;
        while(iLeft< mid&& iRight<high){
            if(array[iLeft]<=array[iRight]){
                extra[iExtra++]=array[iLeft++];
            }else{
                extra[iExtra++]=array[iRight++];
            }
        }

        while(iLeft<mid){
            extra[iExtra++]=array[iLeft++];
        }
        while(iRight<high){
            extra[iExtra++]=array[iRight++];
        }
        for(int i=0;i<length;i++){
            array[low+i]=extra[i];
        }
    }
//归并排序非递归写法
    public static void mergrSortNoR(int[] array) {
        for(int i=1;i<array.length;i=i*2){//i黑色长度
            for(int j=0;j<array.length;j=j+2*i){//j蓝色起始下标
                int low=j;
                int mid=j+i;
                int high=mid+i;
                if(mid>=array.length){
                    continue;
                }
                if(high>array.length){
                    high=array.length;
                }
                merge(array,low,mid,high);
            }
        }
    }
    public static void main(String[] args) {

        int[] a={8,4,9,1,0,3,6,5};
       // quickSortNoR(a);
        mergeSort(a);
       // mergrSortNoR(a);
        System.out.println(Arrays.toString(a));
    }
}

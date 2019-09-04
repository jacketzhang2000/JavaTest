package Test0828;

import Test0827.Heaps;

import java.util.Arrays;
import java.util.Random;

public class sorts {


    //堆排序
    public static void heapSort(int[] array){
        Heaps.creatHeap(array,array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            Heaps.heapify(array,array.length-1-i,0);
        }
    }
    public static void swap(int[] array,int i,int j){
        int count=array[i];
        array[i]=array[j];
        array[j]=count;
    }
    //选择排序
    public static void selectSort(int[] array){
        //无序区间[0,array.length-i)
        //有序区间[array.length-i,array.length)
        for(int i=0;i<array.length-1;i++){
            int max=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            swap(array,max,array.length-i-1);
        }
    }
    //希尔排序
    public static void insertSortwithgap(int[] array,int gap){
        for(int i=0;i<array.length-gap;i++){
            int j;
            int key=array[i+gap];
            for(j=i;j>=0&&key<array[j];j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }
    public static void shellSort(int[] array){
        int gap=array.length;
        while(true){
            gap=gap/3+1;
            insertSortwithgap(array,gap);
            if(gap==1){
                return ;
            }
        }
    }

    //插排
    public static void insertSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            //有序区间  [0,i]
            //无序区间 [i+1,array.length)
            //待插入的数据 array[i+1]
            //插入过程在有序区间内查找
            int key=array[i+1];
            int j;
            for(j=i;j>=0 &&key<array[j];j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    public static int[] bulidArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=i;
        }
        return array;
    }
    public static int[] bulidreverseArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=n-i;
        }
        return array;
    }
    public static int[] bulidRandomArray(int n){
        Random random=new Random(20190828);
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=random.nextInt(n);
        }
        return array;
    }
    public static void main(String[] args) {
        int[] a={9,3,5,4,2,7};
        int[] array;
        array=bulidRandomArray(10);
        //array=bulidArray(10);
        //array=bulidreverseArray(10);
        long begin=System.nanoTime();
        insertSort(array);
        //insertSort(a);
        long end=System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println(end-begin);

        int[] a1={9,3,5,4,2,7};
        shellSort(a1);
        System.out.println(Arrays.toString(a1));

        int[] a2={9,3,5,4,2,7};
        selectSort(a2);
        System.out.println(Arrays.toString(a2));

    }
}

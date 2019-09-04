package Test0829;

import java.util.Arrays;

public class Main {
    //选择排序进阶

    public static void selectHighSort(int[] array) {
        int less=0;
        int high=array.length-1;
        while(less<high) {
            int min = less;
            int max = less;
            for (int j = less + 1; j <= high; j++) {
                if (array[j] > array[max]) {
                   max=j;
                }
                if (array[j] < array[min]) {
                    min=j;
                }
            }
            swap(array, less, min);
            if (max == less) {
                max = min;
            }
            swap(array, max, high);
            less++;
            high--;
        }
    }

    //快速排序
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);
        //quickSortInternal1(array,0,array.length-1);
    }
//因为要用到归并排序，所以要将quickSort和quickSortInternal分开写
    private static void quickSortInternal(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int pivotINdex=partition(array,left,right);
        //int pivotINdex=partition1(array,left,right);
        //int pivotINdex=partition2(array,left,right);
        quickSortInternal(array,left,pivotINdex-1);
        quickSortInternal(array,pivotINdex+1,right);
    }
    private static void quickSortInternal1(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int[] pivotINdex=partition3(array,left,right);
        quickSortInternal1(array,left,pivotINdex[0]-1);
        quickSortInternal1(array,pivotINdex[1]+1,right);
    }


    private static int partition(int[] array, int left, int right) {
        int pivot=array[right];
        int less=left;
        int great=right;
        while(less<great){
            while (less<great&& array[less]<=pivot) {
                less++;
            }
            while (less<great&& array[great]>=pivot ){
                great--;
            }
            swap(array,less,great);
        }
        swap(array,right,less);
        return less;
    }
    private static int partition1(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];
            while (less < great && array[great] >= pivot) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = pivot;
        return less;
    }
    public static int partition2(int[] array, int left, int right) {
        int less=left;//蓝色的箭头
        int pivot = array[right];
        for(int i=left;i<right;i++){//红色的箭头
            if(array[i]< pivot){
                swap(array,less,i);
                less++;
            }
        }
        swap(array,less,right);
        return less;
    }

    public static int[] partition3(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        int i=left;

        while(i<great){
            if(array[i]==pivot){
                i++;
            }
            else if(array[i]<pivot){
                swap(array,i,less);
                i++;
                less++;
            }else{
                while(i<great&& array[great]>pivot){
                    great--;
                }
                swap(array,i,great);
            }
        }
        return new int[] {less,great-1};
    }

    //冒泡排序
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            boolean sorted=true;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    sorted=false;
                    swap(array,j,j+1);
                }
            }
            if(sorted){
                break;
            }
        }
    }

    private static void swap(int[] array, int j, int i) {
        int count=array[j];
        array[j]=array[i];
        array[i]=count;
    }

    public static void main(String[] args) {

        int[] a={1 , 7, 3,4 ,6,2,0,9,5};
        //selectHighSort(a);
        //quickSort(a);
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}

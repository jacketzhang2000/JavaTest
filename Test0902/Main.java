package Test0902;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void mergeSort(Person[] array){
        mergeSortget(array,0,array.length);
    }

    private static void mergeSortget(Person[] array, int low,int high) {
        int length=high-low;
        if(length<=1){
            return ;
        }
        int mid=(low+high)/2;
        mergeSortget(array,low,mid);
        mergeSortget(array,mid,high);
        merage(array,low,mid,high);
    }

    private static void merage(Person[] array, int low, int mid, int high) {
        int length=high-low;
        Person[] exate=new Person[length];
        int ileft=low;
        int iright=mid;
        int Ex=0;
        while(ileft<mid&& iright<high){
            int r=array[ileft].compareTo(array[iright]);
            if(r<=0)
            exate[Ex++]=array[ileft++];
            else {
                exate[Ex++]=array[iright++];
            }
        }
        while(ileft<mid){
            exate[Ex++]=array[ileft++];
        }
        while(iright<high){
            exate[Ex++]=array[iright++];
        }
        for(int i=0;i<length;i++){
            array[i+low]=exate[i];
        }
    }

    public static void main(String[] args) {
        Person[] person=new Person[20];
        Random random=new Random(20190902);
        for(int i=0;i<person.length;i++){
            person[i]=new Person();
            person[i].age=random.nextInt(100);
        }
        //mergeSort(person);
        testBubbleSort(person);
        System.out.println(Arrays.toString(person));
    }
    public static void testBubbleSort(Person[] people){
        buubleSort(people,new PersonRankCompareator());
    }
    public static void buubleSort(Person[] array,Comparator<Person> comparator){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                int a=comparator.compare(array[j],array[j+1]);
                if(a>0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(Person[] array, int j, int i) {
        Person a=array[i];
        array[i]=array[j];
        array[j]=a;
    }
}

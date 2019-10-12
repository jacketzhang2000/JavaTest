package Test0918;

import java.util.Arrays;

import static Test0828.sorts.swap;

public class p1 {
    public int[] prevPermOpt1(int[] A) {
        //1.倒叙去找第一个遇到降序的位置i
        int i;
        for( i=A.length-1;i>0;) {
            if (A[i-1] <=A[i]) {
                i--;
            }
            else break;
        }
        i--;
        if(i<0){
            return A;
        }
        int j=i+1;
        int max=j;
        for (; j < A.length;j++ ) {
            if (A[j] < A[i] && A[max] < A[j]) {
                max = j;
            }
        }
        swap(A,i,max);
        return A;
        //2.从i的右边找
        //比a[i]小的里面最大的一个
        //如果出现多个相同，交换最左边的一个

    }
    public int[] prevPermOpt2(int[] A) {
        for(int i=A.length-2;i>=0;i--){
            if(A[i]>A[i+1]){
                int max=i+1;
                for(int j=i+2;j<A.length;j++){
                    if(A[j]<A[i]&&A[max]<A[j]){
                        max=j;
                    }
                }
                int c=A[i];
                A[i]=A[max];
                A[max]=c;
                return A;
            }
        }
        return A;
    }
    public static void swap(int[] array,int i,int j){
        int count=array[i];
        array[i]=array[j];
        array[j]=count;
    }
    public static void main(String[] args) {
        int[] a={1,5,3,4,2};
        p1 p=new p1();
        System.out.println(Arrays.toString(p.prevPermOpt2(a)));
    }
}

package Test0830;

import Test0819.Solution;
import Test0828.sorts;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Runner {
    private static final Srots[] srots={
            new InsertSort(),
    };
    private static void testSort(int[] origin){
        for (Srots sort : srots){
            int[] array= Arrays.copyOf(origin,origin.length);
            long begin=System.nanoTime();
            sort.srot(array);
            long end=System.nanoTime();
            System.out.printf("%s:排序消耗的时间是：%0.4f 毫秒%n",sort.name(),(end-begin)*1.0/1000/1000);
        }
    }
    //待排序序列： 顺序|逆序|随机
    //数据量:100000
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("需要指定序列顺序和数据量大小");
            return;
        }
        String order = args[0];
        int size = Integer.parseInt(args[1]);
        int[] array=new int[size];
        if (order.equals("顺序")) {
            array = sorts.bulidArray(size);
        } else if (order.equals("逆序")) {
            array = sorts.bulidreverseArray(size);
        } else if (order.equals("随机")) {
            array = sorts.bulidRandomArray(size);
        }
        testSort(array);
    }

}

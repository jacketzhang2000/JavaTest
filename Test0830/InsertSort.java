package Test0830;

public class InsertSort implements Srots {

    @Override
    public String name() {
        return "直接插入排序";
    }

    @Override
    //插入排序
    public void srot(int[] array) {
        for(int i=0;i<array.length-1;i++){
            int key=array[i+1];
            int j;
            for(j=i;j>0&& array[j]>key;j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }
}

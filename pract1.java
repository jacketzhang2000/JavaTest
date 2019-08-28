
//<pre name="code" class="java">
public class pract1 {

    public static boolean Find(int [][] array,int target){

        int rows=array.length;

        int columns=array[0].length;

        boolean found=false;

        if(array !=null && rows >0 && columns >0){

            int row =0;

            int column=columns-1;

            while(row>0){

                int tempValue=array[row][column];

                if(target > tempValue){

                    row++;

                }else if(target < tempValue){

                    column--;



                }else{

                    found=true;

                    break;

                }

            }

        }

        return found;

    }

    public static void main(String[] args) {

        int [][] a = new int [][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println(Find(a,5));

    }

}




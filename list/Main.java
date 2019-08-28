package list;

public class Main {
    public static void id(List list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.get(2));
        System.out.println(list.toString());
        list.set(2, 100);
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.remove(0);
        list.remove(2);
        list.remove(0);
        list.remove(0);
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        //Iterator it =list.iterator();
       // list.add(1);        //list.add(8);

        //list.add(4);
        //list.add(3,6);

       // list.add(5);
        //list.toString();

        /*while(it.hasNext()){
            int element=it.next();
            System.out.println(element);
            }
            */

        }
    public static void main(String[] args) {
       // MyLinkedList linkedList = new MyLinkedList();
       id (new MyArrayList());
       id(new MyLinkedList());

    }
}

package Test0909;

import java.util.Comparator;

//<k,v>是类型遍历，形参
public class MyTreeMap<k,v> {
    //<k,v>是类型遍历，形参
    public static class Entry<k,v> {
        private k key;
        private v val;

        private Entry<k, v> left;
        private Entry<k, v> right;
    }
        public Entry<k,v> root;
        private Comparator<k> comparator=null;
        public MyTreeMap(Comparator<k> comparator) {
            this.comparator = comparator;
        }
        public MyTreeMap(){

        }

        public v get(k key){
            Entry<k,v> cur=root;
            while(cur!=null){
                int r=comparator.compare(key,cur.key);
                if(r==0) {
                    return cur.val;
                }else if(r>0){
                    cur=cur.right;
            }else{
                    cur=cur.left;
                }
        }
        return null;
    }

}

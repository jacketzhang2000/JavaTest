package list;

import java.util.Arrays;

public class MyArrayList implements List {
    int[] array = null;
    int size = 0;

    public void ensureCapacity() {
        int cap = 0;
        if (array == null) {
            cap = 10;
        } else {
            cap = 2 * array.length;
        }
        if (array != null) {
            array = Arrays.copyOf(array, cap);
        } else {
            array = new int[cap];
        }
    }

    @Override
    public boolean add(int element) {
        add(size(), element);
        return true;
    }

    @Override
    public boolean add(int index, int element) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return false;
        }
        //2.检查空间
        ensureCapacity();
        //3.插入
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == index) {
                return array[index];
            }
        }
        return -1;
    }

    @Override
    public int set(int index, int val) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return 0;
        }
        int fan = array[index];
        array[index] = val;
        return fan;
    }

    @Override
    public int remove(int index) {
        //1.判断下标是否越界
        if (index < 0 || index > size()) {
            System.out.println("下标越界");
            return 0;
        }
        int fan = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return fan;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
    return size==0;
    }
    @Override
    public String toString() {

        return Arrays.toString(Arrays.copyOf(array,size()));
    }

    class MyIterator implements Iterator {
        int el = 0;

        @Override
        public boolean hasNext() {
            return size > el;
        }

        @Override
        public int  next() {
            int val = array[el++];
            return val;
        }

        @Override
        public int  remove() {
            return 0;
        }

    }
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
}

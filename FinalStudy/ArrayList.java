package FinalStudy;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T>{

    private T[] backingArray;
    private int size;

    public ArrayList() {
        backingArray = (T[]) new Object[0];
        size = 0;
    }

    public void add(T element) {
        T[] tempArray = (T[]) new Object[size+1];
        for(int i = 0; i < size; i++) {
            tempArray[i] = this.backingArray[i];
        }
        tempArray[size] = element;
        this.backingArray = tempArray;
        size++;
    }

    public T remove(int index) {
        if(this.size == 0) {
            throw new IndexOutOfBoundsException("ArrayList is empty");
        }
        else if(size == 1) {
            T element = this.backingArray[0];
            this.backingArray = (T[]) new Object[0];
            this.size--;
            return element;
        }
        else {
            T[] tempArray = (T[]) new Object[size-1];
            for(int i = 0; i < index; i++) {
                tempArray[i] = this.backingArray[i];
            }
            for(int i = index+1; i < size; i++) {
                tempArray[i-1] = this.backingArray[i];
            }
            T element = this.backingArray[index];
            this.backingArray = tempArray;
            this.size--;
            return element;
        }
    }

    public T[] getBackingArray() {
        return this.backingArray;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>(this);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(0);
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.remove(6);
        for(int i : arrList) {
            System.out.println(i);
        }
    }
    
}

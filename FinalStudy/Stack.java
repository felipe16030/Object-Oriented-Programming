package FinalStudy;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    private T[] backingArray;
    private int size;

    public Stack() {
        backingArray = (T[]) new Object[0];
        size = 0;
    }

    public void push(T element) {
        T[] tempArray = (T[]) new Object[size+1];
        tempArray[0] = element;
        for(int i = 1; i < tempArray.length; i++) {
            tempArray[i] = backingArray[i-1];
        } 
        backingArray = tempArray;
        size++;
    }

    public T peak() {
        return this.backingArray[0];
    }

    public T pop() {
        if(size == 0) {
            throw new NullPointerException("Stack is empty");
        }
        else if(size == 1) {
            T objectReturned = this.backingArray[0];
            this.backingArray = (T[]) new Object[0];
            this.size = 0;
            return objectReturned;
        }
        T[] tempArray = (T[]) new Object[size-1];
        for(int i = 0; i < tempArray.length; i++) {
            tempArray[i] = this.backingArray[i+1];
        }
        size--;
        this.backingArray = tempArray;
        return this.backingArray[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<T>();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.pop();
        s.pop();
        s.pop();
        s.peak();
        s.pop();
        
        for(int i : s) {
            System.out.println(i);
        }
    }

    public class StackIterator<E> implements Iterator<E> {

        private int index;

        public StackIterator() {
            this.index = 0;
        }

        public boolean hasNext() {
            if(this.index > size-1) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            if(hasNext()) {
                E originalElement = (E) backingArray[index];
                index++;
                return originalElement;
            }
            else {
                throw new IndexOutOfBoundsException("invalid index");
            }
        }
    }
    
}

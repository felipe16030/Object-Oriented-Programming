package FinalStudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

    private Node<T> headNode;
    private int size;
    
    public LinkedList(Collection<T> collection) {
        if(collection == null) {
            throw new IllegalArgumentException("collection passed in is null");
        }
        for(T element : collection) {
            if(element == null) {
                throw new IllegalArgumentException("an element in the collection is null");
            }
            this.add(new Node<T>(element, null));
        }
    }

    public void add(Node<T> node) {
        if(node == null) {
            throw new IllegalArgumentException("node passed in is null");
        }
        else if(size == 0) {
            this.headNode = node;
            size++;
        }
        else if(size == 1) {
            this.headNode.setNextNode(node);
            size++;
        }
        else {
            Node<T> currentNode = this.headNode;
            for(int i = 0; i < this.size-1; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(node);
            size++;
        }
    }

    public Node<T> remove(Node<T> node) {
        Node<T> currPerson = this.headNode;
        return null;
    }

    public int size() {
        return this.size;
    }

    public Node<T> getHeadNode() {
        return this.headNode;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    public static void main(String[] args) {
        // ArrayList<String> arrList = new ArrayList<>();
        // arrList.add("A");
        // arrList.add("B");
        // arrList.add("C");
        // arrList.add("D");
        // LinkedList<String> linkedList = new LinkedList<>(arrList);
        // for(String s : linkedList) {
        //     System.out.println(s);
        // }
        for(String e : args) {
            System.out.println(e);
        }
    }

    private class LinkedListIterator<E> implements Iterator<E> {

        private LinkedList<E> linkedList;
        private Node<E> currentNode;

        public LinkedListIterator(LinkedList<E> linkedList) {
            this.linkedList = linkedList;
            this.currentNode = (Node<E>) linkedList.getHeadNode();
        }

        public E next() {
            if(hasNext()) {
                Node<E> tempNode = this.currentNode;
                currentNode = currentNode.getNextNode();
                return tempNode.getItem();
            }
            else {
                throw new IndexOutOfBoundsException("no next node");
            }
        }

        public boolean hasNext() {
            if(currentNode == null) {
                return false;
            }
            return true;
        }

    }

    public class Node<G> {

        private G item;
        private Node<G> nextNode;

        public Node(G item, Node<G> nextPerson) {
            this.item = item;
            this.nextNode = nextPerson;
        }

        public void setNextNode(Node<G> nextPerson) {
            this.nextNode = nextPerson;
        }

        public G getItem() {
            return this.item;
        }

        public Node<G> getNextNode() {
            return this.nextNode;
        }

        public boolean equals(Object other) {
            if(other.getClass() != this.getClass()) {
                return false;
            }
            Node<G> otherNode = (Node<G>) other;
            if(this.item.equals(otherNode)) {
                return true;
            }
            return false;
        }

    }
}

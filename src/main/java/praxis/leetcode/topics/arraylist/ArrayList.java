package praxis.leetcode.topics.arraylist;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elementData;

    private int size;

    public ArrayList() {

        super();
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {

        super();
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];

    }

    public int size() {

        return this.size;
    }

    public boolean isEmpty() {

        return this.size == 0;
    }

    public boolean add(E e) {

        this.ensureCapacity();
        this.elementData[size++] = e;
        return true;

    }

    private void ensureCapacity() {

        if (this.elementData.length == size) {
            this.elementData = Arrays.copyOf(this.elementData, this.size + (this.size * 2));
        }
    }

    public void add(int index, E element) {

        rangeCheck(index);
        this.ensureCapacity();
        System.arraycopy(this.elementData, index, this.elementData, index + 1, size - index);
        this.elementData[index] = element;
        size++;

    }

    public E get(int index) {

        rangeCheck(index);
        return this.elementData[index];
    }

    public E remove(int index) {

        rangeCheck(index);
        E oldValue = this.get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, numMoved);
        }
        this.elementData[--size] = null;
        return oldValue;
    }

    public boolean remove(Object o) {

        return true;
    }

    private void rangeCheck(int index) {

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Illegal index: " + index);
    }

    public Object[] toArray() {

        return Arrays.copyOf(this.elementData, size);
    }

    @Override
    public Iterator<E> iterator() {

        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        int index = -1;

        @Override
        public boolean hasNext() {

            return (index < (size - 1));
        }

        @Override
        public E next() {

            return elementData[++index];
        }

    }

}

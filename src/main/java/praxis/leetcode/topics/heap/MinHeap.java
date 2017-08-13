package praxis.leetcode.topics.heap;

import java.util.Iterator;

class MinHeap<E extends Comparable<E>> implements Iterable<E> {

    private E[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    public MinHeap() {
        data = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public boolean isFull() {
        return (size == data.length);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void display() {

        for (E val : this) {
            System.out.print(val + " ");
        }

        System.out.println();

    }

    public void add(E val) {

        if (isFull()) {
            throw new IllegalStateException("Heap is full.");
        }

        data[size++] = val;
        percolateUp(size - 1);

    }

    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        E val = data[0];
        data[0] = data[--size];
        data[size + 1] = null;
        percolateDown(0);
        return val;
    }

    public void percolateUp(int index) {

        rangeCheck(index);

        while (index > 0) {

            int parentIndex = parentIndex(index);
            if (data[index].compareTo(data[parentIndex]) < 0) {
                E temp = data[parentIndex];
                data[parentIndex] = data[index];
                data[index] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }

    }

    public void percolateDown(int index) {

        rangeCheck(index);

        while (index < size) {

            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);
            int minIndex = -1;

            if (leftChildIndex != -1 && rightChildIndex != -1) {

                minIndex = leftChildIndex;
                if (data[rightChildIndex].compareTo(data[leftChildIndex]) < 0) {
                    minIndex = rightChildIndex;
                }

            } else if (leftChildIndex != -1 && rightChildIndex == -1) {
                minIndex = leftChildIndex;
            } else if (leftChildIndex == -1 && rightChildIndex != -1) {
                minIndex = rightChildIndex;
            } else { // neither leftchild nor rightchild present
                break;
            }

            if (data[minIndex].compareTo(data[index]) < 0) {
                swap(minIndex, index);
            } else {
                break;
            }

            index = minIndex;

        }
    }

    private void swap(int index1, int index2) {

        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    private int parentIndex(int index) {

        rangeCheck(index);

        return (index - 1) / 2;

    }

    private int leftChildIndex(int index) {

        rangeCheck(index);

        int leftChildIndex = (2 * index) + 1;

        return (leftChildIndex >= size) ? -1 : leftChildIndex;

    }

    private int rightChildIndex(int index) {

        rangeCheck(index);

        int rightChildIndex = (2 * index) + 2;

        return (rightChildIndex >= size) ? -1 : rightChildIndex;

    }

    @Override
    public Iterator<E> iterator() {

        return new MinHeapIterator();
    }

    private class MinHeapIterator implements Iterator<E> {

        private int index = -1;

        @Override
        public boolean hasNext() {
            return (index < (size - 1));
        }

        @Override
        public E next() {

            return data[++index];
        }

    }

}

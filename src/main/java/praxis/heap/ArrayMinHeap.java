package praxis.heap;

import java.util.Arrays;
import java.util.List;

public class ArrayMinHeap<E extends Comparable<E>> {

    public static void main(final String[] args) {

        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);

        ArrayMinHeap<Integer> heap = new ArrayMinHeap<>(2);
        for (Integer i : list) {
            heap.add(i);
        }

        heap.display();

        System.out.println(heap.peek());

        System.out.println(heap.pop());

        heap.display();

        System.out.println(heap.pop());

        heap.display();

    }

    private E[] data;
    private int size;

    public ArrayMinHeap(final int capacity) {

        data = (E[]) new Comparable[capacity];
        size = 0;
    }

    public E pop() {

        if (size <= 0)
            return null;

        E element = data[0];

        int lastIndex = size - 1;
        data[0] = data[lastIndex];
        size--;

        int index = 0;

        while (this.hasLeftChild(index)) {

            int smallerChildIndex = this.getLeftChild(index);

            if (this.hasRightChild(index)) {
                int rightChildIndex = this.getRightChild(index);
                if (this.smallerIndex(smallerChildIndex, rightChildIndex) == rightChildIndex)
                    smallerChildIndex = rightChildIndex;
            }

            if (data[index].compareTo(data[smallerChildIndex]) > 0) {

                this.swap(index, smallerChildIndex);
                index = smallerChildIndex;
            } else {
                break;
            }

        }
        return element;
    }

    public void add(final E element) {

        // check for resize
        if (this.size == data.length) {
            System.out.println("resizing..........");
            data = Arrays.copyOf(data, data.length * 2);

        }
        int index = size - 1;
        data[++index] = element;
        size++;
        percolateUp(index);

    }

    public E peek() {

        if (size <= 0)
            return null;
        else
            return data[0];

    }

    public void percolateUp(final int index) {

        int temp = index;

        while (temp > 0) {
            int parentIndex = this.getParentIndex(temp);

            // min-heap
            if (data[parentIndex].compareTo(data[temp]) > 0) {
                swap(parentIndex, temp);
                temp = parentIndex;
            } else {
                break;
            }
        }
    }

    public void display() {

        for (int i = 0; i < size; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void swap(final int i, final int j) {

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public int getParentIndex(final int index) {

        if (index <= 0)
            return 0;

        return (index - 1) / 2;
    }

    public int getLeftChild(final int index) {
        if (index < 0)
            return -1;

        int leftChildIndex = (2 * index) + 1;
        if (leftChildIndex > size - 1)
            return -1;
        return leftChildIndex;
    }

    public int getRightChild(final int index) {
        if (index < 0)
            return -1;

        int rightChildIndex = (2 * index) + 2;
        if (rightChildIndex > size - 1)
            return -1;

        return rightChildIndex;
    }

    public boolean hasLeftChild(final int index) {
        return (this.getLeftChild(index) != -1);
    }

    public boolean hasRightChild(final int index) {
        return (this.getRightChild(index) != -1);
    }

    public int smallerIndex(final int index1, final int index2) {
        if (index1 < 0 || index2 < 0 || index1 > size - 1 || index2 > size - 1)
            throw new RuntimeException("invalid argument");

        if (data[index1].compareTo(data[index2]) > 0)
            return index2;
        else
            return index1;
    }

}

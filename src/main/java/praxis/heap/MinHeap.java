package praxis.heap;

public class MinHeap<E extends Comparable<E>> {

    public static void main(final String[] args) {
        tester();
    }

    public static void tester() {

        MinHeap<Integer> minHeap = new MinHeap<>(10);

        for (int i = 10; i > 0; --i) {
            minHeap.add(i);
        }

        minHeap.display();

        minHeap.pop();

        minHeap.display();

        minHeap.pop();

        minHeap.display();

    }

    private E[] data;
    private int size;

    public MinHeap(final int capacity) {
        this.data = (E[]) new Comparable[capacity];
    }

    private void display() {

        for (int i = 0; i < size; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

    }

    private E pop() {

        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }

        E element = data[0];
        int index = size - 1;
        data[0] = data[index];
        size--;
        this.percolateDown(0);

        return element;

    }

    private void percolateDown(final int index) {

        int iter = index;
        if (iter < 0 || iter > size - 1) {
            return;
        }

        while (this.hasLeftChild(iter)) {
            int smallerChildIndex = this.getLeftChildIndex(iter);

            if (this.hasRightChild(iter)) {
                smallerChildIndex = this.getIndexWithMinValue(smallerChildIndex, this.getRightChildIndex(iter));
            }

            if (data[iter].compareTo(data[smallerChildIndex]) > 0) {
                this.swap(iter, smallerChildIndex);
                iter = smallerChildIndex;
            } else {
                break;
            }

        }

    }

    private void add(final E element) {

        if (size == 0)
            data[0] = element;
        else {

            if (size >= data.length) {
                // double capacity of data array
            }
            int index = size;
            data[index] = element;
            this.percolateUp(index);
        }
        size++;
    }

    private void percolateUp(final int index) {

        int iter = index;

        while (iter > 0) {
            int parentIndex = this.getParentIndex(iter);

            if (parentIndex != -1) {
                if (data[parentIndex].compareTo(data[iter]) > 0) {
                    this.swap(parentIndex, iter);
                    iter = parentIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

    }

    private void swap(final int index1, final int index2) {

        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }

    private int getParentIndex(final int index) {

        if (index <= 0)
            return -1;
        else
            return (index - 1) / 2;
    }

    private int getLeftChildIndex(final int index) {

        if (index < 0) {
            return -1;
        } else {
            int leftChildIndex = (index * 2) + 1;
            if (leftChildIndex > size - 1)
                return -1;
            else
                return leftChildIndex;
        }
    }

    private int getRightChildIndex(final int index) {

        if (index < 0) {
            return -1;
        } else {
            int rightChildIndex = (index * 2) + 2;
            if (rightChildIndex > size - 1)
                return -1;
            else
                return rightChildIndex;
        }

    }

    private boolean hasLeftChild(final int index) {
        return this.getLeftChildIndex(index) != -1;
    }

    private boolean hasRightChild(final int index) {
        return this.getRightChildIndex(index) != -1;
    }

    private int getIndexWithMinValue(final int index1, final int index2) {

        return (data[index1].compareTo(data[index2]) > 0) ? index2 : index1;

    }

}

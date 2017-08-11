package praxis.leetcode.topics.queue;

import java.util.Iterator;

public class Queue<E> implements Iterable<E> {

    private E[] data;
    private int size;
    // index where the first element is present or where the first element will be available if queue empty.
    private int head;
    // index where the new element should be placed in rear
    private int tail;

    private static final int DEFAULT_CAPACITY = 16;

    public Queue() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public Queue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void enqueue(E val) {

        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        size++;
        data[tail] = val;
        tail = (tail + 1) % data.length;

    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        --size;
        E val = data[head];
        head = (head + 1) % data.length;
        return val;
    }

    @Override
    public Iterator<E> iterator() {

        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {

        int index = -1;

        @Override
        public boolean hasNext() {

            return (index < (size - 1));
        }

        @Override
        public E next() {

            return data[(++index + head) % data.length];
        }

    }

}

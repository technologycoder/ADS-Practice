package praxis.leetcode.topics.stack;

import java.util.Arrays;
import java.util.Iterator;

/*
 * If you want T in BinaryNode to be the same type as the enclosing T associated with AVLTree, remove the declaration of T in BinaryNode.

If you want the T in BinaryNode to be different than the enclosing T associated with AVLTree, but you want to be able to access properties of the parent AVLTree, rename T to something else.

If you don't need to access properties of the enclosing AVLTree, make BinaryNode static.
 */
public class Stack<E> implements Iterable<E> {

    private E[] arr;
    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        arr = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E pop() {

        if (size > 0) {
            E result = arr[--size];
            arr[size] = null;
            return result;
        }
        return null;
    }

    public E peek() {
        if (size > 0) {
            return arr[--size];
        }
        return null;
    }

    private void ensureCapacity() {
        if (arr.length == size) {
            arr = Arrays.copyOf(arr, (2 * size) + 1);
        }
    }

    public void push(E element) {
        ensureCapacity();
        arr[size++] = element;

    }

    private class StackIterator implements Iterator<E> {

        private int index = -1;

        @Override
        public boolean hasNext() {
            return (index < size - 1);
        }

        @Override
        public E next() {
            return arr[++index];
        }

    }

}

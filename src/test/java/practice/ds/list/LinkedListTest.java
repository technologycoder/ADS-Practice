package practice.ds.list;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void linkedListAdd() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 10;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9",
                linkedList.toString());

        assertArrayEquals(IntStream.range(min, max)
                        .toArray(),
                linkedList.toArray());

    }

    @Test
    public void removeHead() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 10;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9",
                linkedList.toString());

        linkedList.removeHead();

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9",
                linkedList.toString());

    }

    @Test
    public void reverseList() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 10;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9",
                linkedList.toString());

        linkedList.reverseList();

        assertEquals("9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0",
                linkedList.toString());
    }

    @Test
    public void reverseListRecursive() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 10;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9",
                linkedList.toString());

        linkedList.reverseListRecursive();

        assertEquals("9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0",
                linkedList.toString());
    }

    @Test
    public void removeTail() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 10;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9",
                linkedList.toString());

        linkedList.removeTail();

        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8",
                linkedList.toString());

    }

    @Test
    public void removeTail_one_element_in_list() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 1;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0", linkedList.toString());

        linkedList.removeTail();

        assertEquals("EMPTY", linkedList.toString());

    }

    @Test
    public void removeTail_two_elements_in_list() {

        LinkedList linkedList = new LinkedList();

        int min = 0;
        int max = 2;

        IntStream.range(min, max)
                .forEach(i -> linkedList.addNode(i));

        assertEquals("0 -> 1", linkedList.toString());

        linkedList.removeTail();

        assertEquals("0", linkedList.toString());

    }

}

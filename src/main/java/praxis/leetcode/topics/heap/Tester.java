package praxis.leetcode.topics.heap;

public class Tester {
    public static void main(String[] args) {

        testMinHeap();

    }

    public static void testMinHeap() {

        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.add(10);

        minHeap.display();

        minHeap.add(7);
        minHeap.display();
        minHeap.add(4);
        minHeap.display();
        minHeap.add(6);
        minHeap.display();
        minHeap.add(3);
        minHeap.display();
        minHeap.remove();
        minHeap.display();

    }

}

package praxis.leetcode.topics.queue;

public class Tester {
    public static void main(String[] args) {

        testQueue();

    }

    public static void testQueue() {

        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < 10; ++i)
            queue.enqueue(i);

        for (Integer val : queue) {
            System.out.println(val);
        }
        System.out.println();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println();
        for (Integer val : queue) {
            System.out.println(val);
        }

    }

}

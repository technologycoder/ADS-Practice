package praxis.leetcode.topics.linkedlist;

public class Tester {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }

        System.out.println(list);

        list.reverseList();

        System.out.println(list);

        list.reverseListRecursive();

        System.out.println(list);

    }

}

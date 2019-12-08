package practice.misc;

public class TopQuestions {
    private static Node head;

    public static void main(String[] args) {

        // middleElementLL();
        // checkForLoopInLL();
        // thirdElementFromEnd();

        createLL();
        reverseLLRecursive(head);
        displayLL();
    }

    private static void middleElementLL() {

        createLL();

        Node slow = head;
        Node fast = head;

        int len = 1;
        while (fast.next != null) {

            if (len % 2 == 0) {
                slow = slow.next;
            }

            fast = fast.next;
            len++;

        }

        System.out.println("---------------");
        System.out.println(fast.num);
        System.out.println(slow.num);

    }

    private static void checkForLoopInLL() {

        createLLWithLoop();
        // createLL();

        Node fast = head;
        Node slow = head;

        int len = 1;

        while (fast.next != null) {

            if (len % 2 == 0) {
                slow = slow.next;
            }

            fast = fast.next;
            len++;

            if (fast == slow || fast.next == slow) {
                System.out.println("Loop found in LL");
                break;
            }

        }

        if (fast.next == null) {
            System.out.println("Loop NOT found in LL");
        }

    }

    private static void thirdElementFromEnd() {

        createLL();

        Node front = head;
        Node back = head;

        int length = 1;
        while (front.next != null) {
            front = front.next;
            length++;

            if (length > 3) {
                back = back.next;
            }
        }

        System.out.println("Third element from end: " + back.num);

    }

    private static void reverseLLRecursive(Node node) {

        if (node == null) {
            return;
        }

        if (node.next == null) {

            head = node;
            return;
        }

        reverseLLRecursive(node.next);
        node.next.next = node;
        node.next = null;

    }

    private static Node insert(int num) {

        Node node = new Node(num);

        if (head == null) {

            head = node;
        } else {

            Node iter = head;

            while (iter.next != null) {
                iter = iter.next;
            }

            iter.next = node;
        }
        return node;
    }

    private static void createLLWithLoop() {

        insert(23);
        Node node = insert(13);
        insert(45);
        insert(65);
        insert(25).next = node;

    }

    private static void createLL() {

        insert(23);
        insert(13);
        insert(45);
        insert(65);
        insert(25);

        displayLL();

    }

    private static void displayLL() {

        Node iter = head;

        while (iter != null) {
            System.out.println(iter.num);
            iter = iter.next;
        }

        System.out.println("---------------");

    }

    private static class Node {
        public int num;

        public Node next;

        public Node(int num) {

            this.num = num;

        }
    }

}

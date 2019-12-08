package praxis.leetcode.topics.stack;

public class Tester {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        for (String str : stack) {
            System.out.println(str);
        }
    }

}

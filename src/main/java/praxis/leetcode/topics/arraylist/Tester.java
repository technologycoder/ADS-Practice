package praxis.leetcode.topics.arraylist;

public class Tester {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {

            list.add(i);
        }

        for (Integer val : list) {
            System.out.println(val);
        }

        //list.remove(10);

        list.add(4, 25);

        for (Integer val : list) {
            System.out.println(val);
        }
    }

}

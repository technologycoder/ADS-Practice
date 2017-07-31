package praxis.leetcode.disjointsets;

import java.util.Arrays;

public class Sample {

    public static void main(String[] args) {

        Sample sample = new Sample(9);

        sample.display();

        sample.union(1, 2);
        sample.display();

        sample.union(5, 6);
        sample.display();

        sample.union(1, 8);
        sample.display();

        sample.union(3, 4);
        sample.display();

        sample.union(5, 8);
        sample.display();
    }

    private int[] parents;
    private int[] rank;

    private void display() {
        System.out.println(Arrays.toString(this.parents));
        System.out.println(Arrays.toString(this.rank));
        System.out.println();
    }

    public Sample(int size) {
        this.parents = new int[size];

        for (int i = 0; i < size; ++i) {
            parents[i] = i;
        }
        this.rank = new int[size];
    }

    public int find(int num) {

        if (parents[num] != num) {
            parents[num] = find(parents[num]);
        }

        return parents[num];

    }

    public void union(int x, int y) {

        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY)
            return;

        if (rank[parentX] > rank[parentY])
            parents[parentY] = parentX;
        else if (rank[parentX] < rank[parentY])
            parents[parentX] = parentY;
        else {
            parents[parentX] = parentY;
            rank[parentY]++;
        }
    }

}

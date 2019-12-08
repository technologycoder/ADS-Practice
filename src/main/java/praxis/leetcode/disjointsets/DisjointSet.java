package praxis.leetcode.disjointsets;

public class DisjointSet {
    private int[] parents;

    private int[] rank;

    public DisjointSet(int size) {

        parents = new int[size];

        for (int i = 0; i < size; ++i) {
            parents[i] = i;
        }

        rank = new int[size];

    }

    public int find(int num) {

        if (parents[num] != num) {

            parents[num] = find(parents[num]);
        }

        return parents[num];

    }

    public void union(int x, int y) {

        System.out.println(x + " - " + y);

        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY)
            return;

        if (rank[parentX] < rank[parentY]) {
            parents[parentX] = parentY;
        } else if (rank[parentY] < rank[parentX]) {
            parents[parentY] = parentX;
        } else {
            parents[parentX] = parentY;
            rank[parentY]++;
        }

    }

    public int[] getParents() {

        return this.parents;
    }

    public int[] getRanks() {

        return this.rank;
    }

}

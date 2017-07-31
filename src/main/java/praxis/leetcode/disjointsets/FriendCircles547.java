package praxis.leetcode.disjointsets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FriendCircles547 {

    public static void main(String[] args) {
        int[][] M = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };

        int[][] N = {
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 }
        };

        System.out.println(findCircleNum(N));

    }

    public static int findCircleNum(int[][] M) {

        int size = M.length;

        DisjointSet ds = new DisjointSet(size);

        // DisjointUnionSet ds = new DisjointUnionSet(size);

        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M.length; ++j) {

                if (i == j)
                    continue;

                if (M[i][j] == 1) {
                    ds.union(i, j);
                    System.out.println(Arrays.toString(ds.getParents()));
                    System.out.println(Arrays.toString(ds.getRanks()));
                }

            }
        }

        System.out.println(Arrays.toString(ds.getParents()));

        Set<Integer> disjointSets = new HashSet<>();

        for (int i = 0; i < size; ++i) {
            disjointSets.add(ds.find(i));
        }

        return disjointSets.size();
    }

}

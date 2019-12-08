package praxis.leetcode.dfs;

import java.util.Arrays;

public class FriendsCircles547 {
    public static void main(String[] args) {

        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(M));
    }

    public static int findCircleNum(int[][] M) {

        int size = M.length;

        int[] parents = new int[size];
        Arrays.fill(parents, -1);

        State[] state = new State[size];
        Arrays.fill(state, State.UNVISITED);

        for (int i = 0; i < size; ++i) {
            if (state[i] == State.UNVISITED) {
                state[i] = State.VISITING;
                dfs(M, i, parents, state);
            }
        }

        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (parents[i] == -1)
                count++;
        }

        // System.out.println(Arrays.toString(parents));
        return count;
    }

    ;

    public static void dfs(int[][] M, int node, int[] parents, State[] state) {

        for (int i = 0; i < M.length; ++i) {
            // same node
            if (node == i)
                continue;

            // neighbor
            if (M[node][i] == 1 && state[i] == State.UNVISITED) {

                parents[i] = node;
                state[i] = State.VISITING;
                dfs(M, i, parents, state);

            }
        }

        state[node] = State.VISITED;

    }

    public enum State {
        UNVISITED, VISITING, VISITED
    }

}

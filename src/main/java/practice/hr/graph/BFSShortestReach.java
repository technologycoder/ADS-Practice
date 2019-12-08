package practice.hr.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReach {
    public static void main(final String[] args) {

        // readInputUsingScannerAndProcessBFS();
        createGraphAndProcessBFS();
    }

    public static void createGraphAndProcessBFS() {

        int nodeCount = 4;

        int[][] graph = new int[nodeCount + 1][nodeCount + 1];

        graph[1][2] = 6;
        graph[2][1] = 6;

        graph[1][3] = 6;
        graph[3][1] = 6;

        int startNode = 1;
        bfs(graph, startNode, nodeCount);

    }

    public static void readInputUsingScannerAndProcessBFS() {

        Scanner in = new Scanner(System.in);

        int testCount = in.nextInt();

        for (int i = 0; i < testCount; ++i) {

            int nodeCount = in.nextInt();
            int edgeCount = in.nextInt();

            int[][] graph = new int[nodeCount + 1][nodeCount + 1];

            for (int j = 0; j < edgeCount; ++j) {

                int firstNode = in.nextInt();
                int secondNode = in.nextInt();

                graph[firstNode][secondNode] = 6;
                graph[secondNode][firstNode] = 6;

            }

            int startNode = in.nextInt();
            bfs(graph, startNode, nodeCount);

        }

    }

    private static void bfs(final int[][] graph, final int startNode, final int nodeCount) {

        // System.out.println(Arrays.deepToString(graph) + " - " + startNode);

        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, 0);

        State[] states = new State[nodeCount + 1];
        Arrays.fill(states, State.UNVISITED);

        Queue<Integer> queue = new ArrayDeque<>();

        states[startNode] = State.VISITING;
        queue.add(startNode);

        while (!queue.isEmpty()) {

            int node = queue.remove();

            for (int i = 1; i < nodeCount + 1; ++i) {

                int neighbor = i;

                // edge not present or neighbor has already been visited/visting
                if (graph[node][neighbor] == 0 || states[neighbor] != State.UNVISITED)
                    continue;

                states[neighbor] = State.VISITING;
                queue.add(neighbor);

                distance[neighbor] += distance[node] + graph[node][neighbor];

            }

            states[node] = State.VISITED;
        }

        // print result
        for (int i = 1; i < distance.length; ++i) {

            if (i == startNode)
                continue;

            if (distance[i] == 0)
                System.out.print("-1 ");
            else
                System.out.print(distance[i] + " ");
        }
        System.out.println("");

    }

    private static enum State {
        UNVISITED, VISITING, VISITED;
    }

}

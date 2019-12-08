package praxis.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DFS {
    private static int time = 0;

    public static void main(final String[] args) {

        int size = 6;
        Map<Character, Integer> map = new HashMap<>();
        int[][] graph = createGraph(map, size);

        char[] vertices = new char[size];

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            vertices[entry.getValue()] = entry.getKey();
        }

        System.out.println(Arrays.toString(vertices));

        dfs(graph, size);

    }

    ;

    public static void dfs(final int[][] graph, final int size) {

        State[] state = new State[size];
        Arrays.fill(state, State.UNVISITED);

        int[] distance = new int[size];

        int[] parent = new int[size];
        Arrays.fill(parent, -1);

        int[] finalDistance = new int[size];

        for (int i = 0; i < size; ++i) {

            if (state[i] == State.UNVISITED)
                dfs(graph, i, state, distance, parent, finalDistance, size);
        }

        System.out.println(Arrays.toString(state));
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(finalDistance));

    }

    public static void dfs(final int[][] graph, final int node, final State[] state,
                           final int[] distance,
                           final int[] parent,
                           final int[] finalDistance, final int size) {

        state[node] = State.VISTING;
        distance[node] = ++time;

        for (int i = 0; i < size; ++i) {
            int neighbor = i;

            if (graph[node][neighbor] == 1 && state[neighbor] == State.UNVISITED) {

                parent[neighbor] = node;
                dfs(graph, neighbor, state, distance, parent, finalDistance, size);
            }
        }

        state[node] = State.VISITED;
        finalDistance[node] = ++time;

    }

    public static int[][] createGraph(final Map<Character, Integer> map, final int size) {

        char c = 'u';
        for (int i = 0; i < size; ++i) {
            map.put(c, i);
            c++;
        }

        System.out.println(map);

        int[][] graph = new int[size][size];

        addDirectedEdge(graph, 'u', 'v', map);
        addDirectedEdge(graph, 'u', 'x', map);
        addDirectedEdge(graph, 'x', 'v', map);
        addDirectedEdge(graph, 'v', 'y', map);
        addDirectedEdge(graph, 'y', 'x', map);
        addDirectedEdge(graph, 'w', 'y', map);
        addDirectedEdge(graph, 'w', 'z', map);
        addDirectedEdge(graph, 'z', 'z', map);

        System.out.println(Arrays.deepToString(graph)
                .replaceAll("],", "]\n"));

        return graph;

    }

    public static void addDirectedEdge(final int[][] graph, final char node1,
                                       final char node2, final Map<Character, Integer> map) {

        graph[map.get(node1)][map.get(node2)] = 1;

    }

    public static void addUndirectedEdge(final int[][] graph, final char node1,
                                         final char node2, final Map<Character, Integer> map) {

        graph[map.get(node1)][map.get(node2)] = 1;
        graph[map.get(node2)][map.get(node1)] = 1;

    }

    static enum State {
        UNVISITED, VISTING, VISITED
    }

}

package praxis.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BFS {
    public static void main(final String[] args) {

        int size = 8;
        Map<Character, Integer> map = new HashMap<>();
        int[][] graph = createGraph(map, size);

        char[] vertices = new char[size];

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            vertices[entry.getValue()] = entry.getKey();
        }

        System.out.println(Arrays.toString(vertices));

        bfs(graph, map.get('s'), size);

    }

    public static void bfs(final int[][] graph, final int startNode, final int size) {

        Queue<Integer> queue = new ArrayDeque<>();

        State[] state = new State[size];
        Arrays.fill(state, State.UNVISITED);

        int[] distance = new int[size];
        int[] parent = new int[size];

        state[startNode] = State.VISTING;
        distance[startNode] = 0;
        queue.add(startNode);

        while (!queue.isEmpty()) {

            int node = queue.remove();

            for (int i = 0; i < size; ++i) {

                int neighbor = i;

                if (graph[node][neighbor] == 1 && state[neighbor] == State.UNVISITED) {
                    state[neighbor] = State.VISTING;
                    distance[neighbor] = distance[node] + graph[node][neighbor];
                    parent[neighbor] = node;

                    queue.add(neighbor);
                }

            }

            state[node] = State.VISITED;

        }

        System.out.println(Arrays.toString(state));
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));

    }

    ;

    public static int[][] createGraph(final Map<Character, Integer> map, final int size) {

        char c = 'r';
        for (int i = 0; i < size; ++i) {
            map.put(c, i);
            c++;
        }

        System.out.println(map);

        int[][] graph = new int[size][size];

        addUndirectedEdge(graph, 'r', 's', map);
        addUndirectedEdge(graph, 'r', 'v', map);
        addUndirectedEdge(graph, 's', 'w', map);
        addUndirectedEdge(graph, 'w', 't', map);
        addUndirectedEdge(graph, 'w', 'x', map);
        addUndirectedEdge(graph, 't', 'x', map);
        addUndirectedEdge(graph, 't', 'u', map);
        addUndirectedEdge(graph, 'x', 'u', map);
        addUndirectedEdge(graph, 'x', 'y', map);
        addUndirectedEdge(graph, 'u', 'y', map);

        System.out.println(Arrays.deepToString(graph)
                .replaceAll("],", "]\n"));

        return graph;

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

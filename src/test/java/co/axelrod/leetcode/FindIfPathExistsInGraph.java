package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 */
class FindIfPathExistsInGraph {
    @Test
    void validPathTest() {
        assertTrue(validPath(3,
                new int[][]{
                        {0, 1}, {1, 2}, {2, 0}
                },
                0, 2));

        assertFalse(validPath(6,
                new int[][]{
                        {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}
                },
                0, 5));

        assertTrue(validPath(10,
                new int[][]{
                        {4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}
                },
                5, 9));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                graph.put(edge[0], new ArrayList<>(List.of(edge[1])));
            }
            if (graph.containsKey(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                graph.put(edge[1], new ArrayList<>(List.of(edge[0])));
            }
        }

        return dfs(visited, graph, source, destination);
    }

    private boolean dfs(boolean[] visited, Map<Integer, List<Integer>> graph, int vertex, int destination) {
        if (vertex == destination) {
            return true;
        }

        visited[vertex] = true;

        for (Integer target : graph.get(vertex)) {
            if (!visited[target]) {
                if (dfs(visited, graph, target, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}

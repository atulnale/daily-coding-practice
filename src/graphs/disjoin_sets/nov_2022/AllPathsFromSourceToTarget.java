package graphs.disjoin_sets.nov_2022;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph == null || graph.length == 0) {
            return paths;
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph.length-1, paths, path, graph);
        return paths;

    }

    private void dfs(int src, int dest, List<List<Integer>> paths, List<Integer> path, int[][] graph) {
        if(src == dest) {
            paths.add(new ArrayList<>(path));
            return ;
        }
        int[] connectedNodes = graph[src];
        for(int ele : connectedNodes) {
            path.add(ele);
            dfs(ele,dest, paths, path, graph);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(obj.allPathsSourceTarget(graph));
    }
}

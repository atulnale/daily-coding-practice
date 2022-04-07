package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckBipartiteGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] nodes = new ArrayList[A];
        for(int i = 0; i<nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i<B.size(); i++) {
            nodes[B.get(i).get(0)].add(B.get(i).get(1));
            nodes[B.get(i).get(1)].add(B.get(i).get(0));
        }
        Map<Integer,Integer> map = new HashMap<>();
        boolean[] vst = new boolean[A];
        int[] colors = new int[A];
        for(int i = 0; i< A; i++) {
            if(!vst[i]) {
                if(!dfs(i,vst,colors,nodes,0)) return 0;
            }
        }
        return 1;
    }

    private boolean dfs(int src, boolean[] vst, int[] colors, ArrayList<Integer>[] nodes, int color) {
        vst[src] = true;
        colors[src] = color;
        for(int ele: nodes[src]){
            if(!vst[ele]){
                if(!dfs(ele, vst, colors, nodes, 1^color)){
                    return false;
                }
            } else {
                if(color == colors[ele]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckBipartiteGraph obj = new CheckBipartiteGraph();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2, 5)));
        list.add(new ArrayList<>(Arrays.asList(6, 7)));
        list.add(new ArrayList<>(Arrays.asList(4, 8)));
        list.add(new ArrayList<>(Arrays.asList(2, 3)));
        list.add(new ArrayList<>(Arrays.asList(0, 3)));
        list.add(new ArrayList<>(Arrays.asList(4, 7)));
        list.add(new ArrayList<>(Arrays.asList(1, 8)));
        list.add(new ArrayList<>(Arrays.asList(3,8)));
        list.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(obj.solve(9,list));
    }
}

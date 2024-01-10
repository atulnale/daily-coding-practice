package graphs.disjoin_sets.nov_2022;

import java.util.*;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for(int i = 0; i< parent.length; i++) {
            parent[i] = i;
        }
        for(List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1), parent);
        }
        HashMap<Integer, PriorityQueue<Character> > map = new HashMap<>();
        for(int i = 0; i< parent.length ; i++) {
            int xParent = find(i, parent);
            map.putIfAbsent(xParent, new PriorityQueue<>());
            map.get(xParent).add(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            int xParent = find(i, parent);
            builder.append(map.get(xParent).poll());
        }
        return builder.toString();
    }
    public int find(int x, int[] parent) {
        if( x == parent[x]) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public void union(int x, int y, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if(xParent != yParent) parent[xParent] = yParent;
    }
    public static void main(String[] args) {
       String s = "dcab";
       List<List<Integer>> pairs = new ArrayList<>();
       pairs.add(new ArrayList<>(Arrays.asList(0,3)));
        pairs.add(new ArrayList<>(Arrays.asList(1,2)));
        SmallestStringWithSwaps obj = new SmallestStringWithSwaps();
        System.out.println(obj.smallestStringWithSwaps(s,pairs));
    }
}

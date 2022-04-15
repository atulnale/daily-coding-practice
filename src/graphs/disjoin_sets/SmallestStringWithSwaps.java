package graphs.disjoin_sets;

import java.util.*;

/***
 * @question: https://leetcode.com/problems/smallest-string-with-swaps/solution/
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for(int i = 0; i< parent.length; i++) {
            parent[i] = i;
        }
        for(List<Integer> list: pairs){
            union(list,parent);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i< parent.length; i++) {
            int parent_i = find(i,parent);
            map.putIfAbsent(parent_i,new ArrayList<>());
            map.get(parent_i).add(i);
        }
        char[] result = new char[s.length()];
        for(List<Integer> indexes: map.values()){
            List<Character> characters = new ArrayList<>();
            for(int index: indexes){
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            for(int i = 0; i<indexes.size(); i++) {
                result[indexes.get(i)] = characters.get(i);
            }
        }
        return new String(result);
    }

    private void union(List<Integer> list, int[] parent) {
        int parent_i = find(list.get(0), parent);
        int parent_j = find(list.get(1), parent);
        if(parent_i != parent_j) parent[parent_j] = parent_i;
    }

    private int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0,3)));
        pairs.add(new ArrayList<>(Arrays.asList(1,2)));
        pairs.add(new ArrayList<>(Arrays.asList(0,2)));
        SmallestStringWithSwaps obj = new SmallestStringWithSwaps();
        System.out.println(obj.smallestStringWithSwaps(s, new ArrayList<>(pairs)));
    }
}

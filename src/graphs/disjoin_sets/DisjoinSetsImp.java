package graphs.disjoin_sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjoinSetsImp {
    public void solve(List<List<Integer>> list, List<List<Integer>> q, int n) {
        int[] parent = new int[n];
        for(int i = 0; i< n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i<list.size(); i++) {
            union(list.get(i),parent);
        }
        for(int i = 0; i<q.size(); i++) {
            System.out.println(q.get(i).get(0) + "   " + q.get(i).get(1) +"   -->   "+find(q.get(i),parent));
        }
    }

    private boolean find(List<Integer> list, int[] parent) {
        int parent_x = parent(list.get(0),parent);
        int parent_y = parent(list.get(1), parent);
        if(parent_x != parent_y) return false;
        return true;
    }

    private void union(List<Integer> list, int[] parent) {
        int parent_x = parent(list.get(0),parent);
        int parent_y = parent(list.get(1), parent);
        if(parent_x == parent_y) return;
        parent[list.get(1)] = parent_x;
    }

    private int parent(Integer num, int[] parent) {
        if(parent[num] == num) return num;
        return parent(parent[num],parent);
    }




    public static void main(String[] args) {
        DisjoinSetsImp obj = new DisjoinSetsImp();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0,1)));
        list.add(new ArrayList<>(Arrays.asList(0,2)));
        list.add(new ArrayList<>(Arrays.asList(1,3)));
        list.add(new ArrayList<>(Arrays.asList(4,8)));
        list.add(new ArrayList<>(Arrays.asList(5,6)));
        list.add(new ArrayList<>(Arrays.asList(5,7)));

        List<List<Integer>> q = new ArrayList<>();
        q.add(new ArrayList<>(Arrays.asList(0,3)));
        q.add(new ArrayList<>(Arrays.asList(1,5)));
        q.add(new ArrayList<>(Arrays.asList(7,8)));

        obj.solve(list,q,9);
    }


}

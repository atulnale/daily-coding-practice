package array;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 1, 2));
        FirstMissingPositive obj = new FirstMissingPositive();
        System.out.println(obj.firstMissingPositive(list));
    }
    public int firstMissingPositive(ArrayList<Integer> list) {
        int max = 1000000;
        for(int i = 0 ; i< list.size(); i++){
            int ele = list.get(i);
            if(ele == i + 1) continue;
            if(ele >0 && ele <list.size()+1 && ele != list.get(ele-1)){
                list.set(i, list.get(ele-1));
                list.set(ele-1, ele);
                i--;
            }
        }
        for(int i = 0; i< list.size(); i++){
            if(list.get(i) != i+1){
                return i+1;
            }
        }
        return list.size()+1;
    }
}

package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * @question: https://leetcode.com/problems/brace-expansion/solution/
 */
public class BracesExpansion {
    List<String> list = new ArrayList<>();
    public String[] expand(String s) {
        solve(s,0,s.length() - 1,"");
        Collections.sort(list);
        String[] result = new String[list.size()];
        for(int i = 0; i<list.size() ; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void solve(String s, int start, int end, String curr) {
        if(start>end) {
         list.add(curr);
         return;
        }

        if(s.charAt(start) == '{'){
            int i ;
          for(i=start+1; i<end; i++) {
              if(s.charAt(i) == '}') break;
          }
          String temp = s.substring(start+1,i);
          String[] arr = temp.split(",");
          for(String str : arr) {
              solve(s,i,end,curr + str);
          }
        } else if( s.charAt(start) == ',' || s.charAt(start) == '}') {
            solve(s,start+1,end, curr);
        } else {
            solve(s, start + 1, end, curr + s.charAt(start));
        }
    }

    public static void main(String[] args) {
        BracesExpansion obj = new BracesExpansion();
        String s = "{a,b}c{d,e}f";
        obj.expand(s);
    }

}

package problems;

import java.util.HashMap;
import java.util.Map;

/***
 * @question: https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+ 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for(int i = 0;i<s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();
        String s= "leetcode";
        System.out.println(obj.firstUniqChar(s));
    }
}

package problems;

import java.util.*;

/***
 * @question: https://leetcode.com/problems/group-anagrams/
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        LinkedHashMap<String,List<String>> map = new LinkedHashMap<>();
        for(String ele: strs){
            char[] arr= ele.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if(map.containsKey(sorted)) {
                map.get(sorted).add(ele);
            } else {
                map.put(sorted,new ArrayList<>(Arrays.asList(ele)));
            }
        }
        for(String ele: map.keySet()){
            result.add(map.get(ele));
        }
        System.out.println(map.values());
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.groupAnagrams(strs));
    }
}

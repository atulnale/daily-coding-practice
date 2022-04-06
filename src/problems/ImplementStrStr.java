package problems;

import java.util.HashMap;
import java.util.Map;

/***
 * @question: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2968/
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 1;
        map.put(0,0);
        while(j<needle.length()) {
            if(needle.charAt(i) == needle.charAt(j)){
                i++;
                map.put(j,i);
                j++;
            } else {
                if(i != 0 ) {
                    i = map.get(i - 1);
                } else {
                    map.put(j,0);
                    j++;
                }
            }
        }

        i = 0;
        j = 0;
        while(i<haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j== needle.length() ){ return i - j;}
            }
            else {
                if(j != 0){
                    j = map.get(j-1);
                }
                else {
                    i++;
                }

            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = "aabaaabaaac", needle = "aabaaac";
        ImplementStrStr obj = new ImplementStrStr();
        System.out.println(obj.strStr(haystack,needle));
    }
}
/***
 * "aabaaabaaac"
 * "aabaaac"
 */
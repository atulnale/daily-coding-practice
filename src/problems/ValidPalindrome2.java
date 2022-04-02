package problems;

/**
 * @question: https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome2 {
    public static void main(String[] args) {
        ValidPalindrome2 obj = new ValidPalindrome2() ;
        System.out.println(obj.validPalindrome("abc"));
    }

    private boolean validPalindrome(String s) {
        return helper(s, 0, s.length() -1, true);
    }
    public boolean helper(String s, int left, int right, boolean deleteAllowed) {
        if(left >= right) return true;
        if(s.charAt(left) == s.charAt(right)) {
            return helper(s, left+1, right -1, deleteAllowed);
        } else {
            if(!deleteAllowed) return false;
            return helper(s,left + 1, right , false) || helper(s,left, right -1, false);
        }
    }
}

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */

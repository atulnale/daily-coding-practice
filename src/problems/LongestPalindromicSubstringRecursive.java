package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstringRecursive {
    Map<String, Boolean>  dp = new HashMap<>();
    public String longestPalindrome(String s) {
        helper(s,0,s.length() - 1);
        int max = 0;
        int i = 0;
        int j = 0;
        for(String value : dp.keySet()){
            String[] arr = value.split(":");
            if(dp.get(value)){
                if(Integer.valueOf(arr[1]) - Integer.valueOf(arr[0]) > max) {
                    i = Integer.valueOf(arr[0]);
                    j = Integer.valueOf(arr[1]);
                    max = j - i;
                }
            }
        }
        return s.substring(i, j + 1);
    }

    private boolean helper(String s, int i, int j) {
        if(j<i || i== j) {
            dp.put(i+":"+j,true);
            return true;
        }
        if(dp.containsKey(i+":"+j)) return dp.get(i+":"+j);
        if(s.charAt(i) == s.charAt(j)){
            dp.put(i+":"+j, helper(s,i + 1, j - 1));
        } else {
            dp.put(i + ":" + j, false);
        }
            helper(s,i + 1, j);
            helper(s,i,j-1);
            return dp.get(i+":"+j);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstringRecursive obj = new LongestPalindromicSubstringRecursive();
        String s = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
        System.out.println(obj.longestPalindrome(s));
    }
}

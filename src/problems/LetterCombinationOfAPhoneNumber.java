package problems;

import java.util.*;

public class LetterCombinationOfAPhoneNumber {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Character,List<Character>> map = new HashMap<>();
        map.put('2',new ArrayList<>(Arrays.asList('a','b','c')));
        map.put('3',new ArrayList<>(Arrays.asList('d','e','f')));
        map.put('4',new ArrayList<>(Arrays.asList('g','h','i')));
        map.put('5',new ArrayList<>(Arrays.asList('j','k','l')));
        map.put('6',new ArrayList<>(Arrays.asList('m','n','o')));
        map.put('7',new ArrayList<>(Arrays.asList('p','q','r','s')));
        map.put('8',new ArrayList<>(Arrays.asList('t','u','v')));
        map.put('9',new ArrayList<>(Arrays.asList('w','x','y','z')));
        helper(map,digits,0,"");
        return res;
    }

    private void helper(Map<Character, List<Character>> map, String digits, int i, String s) {
        if(i == digits.length()) {
            if(!s.isEmpty())res.add(s);
            return;
        }
        char ch = digits.charAt(i);
        for(char ele: map.get(ch)){
            helper(map, digits, i + 1, s + ele);
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfAPhoneNumber obj = new LetterCombinationOfAPhoneNumber();
        System.out.println(obj.letterCombinations(""));
    }
}

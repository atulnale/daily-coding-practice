package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty() || map.get(s.charAt(i)) != stack.pop()){
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        return false;

    }
    public static void main(String[] args) {
        ValidParantheses obj = new ValidParantheses();
        String s = "]";
        System.out.println(obj.isValid(s));
    }
}

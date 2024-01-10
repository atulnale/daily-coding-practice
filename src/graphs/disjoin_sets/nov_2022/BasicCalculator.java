package graphs.disjoin_sets.nov_2022;

import java.util.Stack;

public class BasicCalculator {
    int calculate(String a, String b, String operation) {
        int num1 = Integer.valueOf(a);
        int num2 = Integer.valueOf(b);
        switch(operation) {
           case "+": return num1 + num2;
           case "-": return num1 - num2;
            default: return 0;
        }
    }
    public void calculateStackOper(Stack<String> stack) {
        while(stack.size() >= 2 && stack.peek() != "("){
            String b = stack.pop();
            String oper = stack.pop();
            if(oper.equals("(")){
                stack.push(b);
                break;
            }
            String a = stack.pop();
            int res = calculate(a,b,oper);
            stack.push(String.valueOf(res));
        }
        if(stack.size() == 2){
            String val = stack.pop();
            stack.pop();
            stack.push(val);
        }
    }
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        String sign = "+";
        int i = 0;
        if(s.charAt(0) == '-') {
            sign = "-";
            i = 1;
        }
        StringBuilder builder = new StringBuilder();
        while(i < s.length()) {
            if(s.charAt(i) == '(' || s.charAt(i)=='+' || s.charAt(i) == '-'){

                if(s.charAt(i) == '-'){
                    if(builder.length() != 0){
                        stack.push(builder.toString());
                        builder = new StringBuilder();
                    }
                    builder.append('-');
                    stack.push("+");
                } else if(s.charAt(i) == '(' && builder.toString().equals("-")) {
                    stack.pop();
                    stack.push("-");
                    builder = new StringBuilder();
                    stack.push("(");
                }
                else{if(builder.length() != 0){
                    stack.push(builder.toString());
                    builder = new StringBuilder();
                }
                    stack.push(String.valueOf(s.charAt(i)));
                }

            } else if ( s.charAt(i) != ' ' && s.charAt(i) != ')') {
                builder.append(s.charAt(i));

            } else if (s.charAt(i) == ' ') {
                if(builder.length() !=0) {
                    stack.push(builder.toString());
                    builder = new StringBuilder();
                }
            } else if(s.charAt(i) == ')') {
                if(builder.length() != 0){
                    stack.push(builder.toString());
                    builder = new StringBuilder();
                }
                calculateStackOper(stack);
            }
            i++;
        }
        if(builder.length() != 0){
            stack.push(builder.toString());
        }
        if(stack.size()!=1) {
            calculateStackOper(stack);
        }
        int signValue = Integer.valueOf(sign + "1");
        int res = Integer.valueOf(stack.pop());
        return (signValue * res);

    }
    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();
        String s = "1-(1+1)";
        System.out.println(obj.calculate(s));
    }
}

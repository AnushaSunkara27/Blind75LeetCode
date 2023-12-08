package Strings;

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {

        if(s.length()%2 !=0) return false;
        Stack<Character> stack = new Stack<>();
        for(char i: s.toCharArray()) {
            if(i == '(' || i == '{' || i =='[') {
                stack.push(i);
            } else if(i == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if(i == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if(i == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        return stack.isEmpty();
    }
}

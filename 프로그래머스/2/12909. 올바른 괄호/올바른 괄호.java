import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(Character ch : s.toCharArray()){
            if(ch == '(') stack.push('(');
            else {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
import java.util.*;

class Solution {
    public int solution(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String rs = s.substring(i) + s.substring(0, i);
            if (canCorrect(rs)) count++;
        }
        return count;
    }
    
    public boolean canCorrect(String rs) {

        Stack<String> stack = new Stack<>();

        for (String s : rs.split("")) {
            if (stack.isEmpty()) stack.push(s);
            else {
                switch (stack.peek() + s) {
                    case "()", "[]", "{}" -> stack.pop();
                    default -> stack.push(s);
                }
            }
        }

        return stack.isEmpty();
    }
}
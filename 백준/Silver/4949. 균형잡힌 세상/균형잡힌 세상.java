import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] c = br.readLine().toCharArray();
            if (c[0] == '.') break;
            Stack<Character> stack = new Stack<>();
            for (char ch : c) {
                if (ch == '(' || ch == '[') stack.add(ch);
                else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        stack.add(ch);
                        break;
                    }
                }
                else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        stack.add(ch);
                        break;
                    }
                }
            }
            sb.append(stack.size() == 0 ? "yes" : "no").append('\n');
        }
        System.out.println(sb);
    }
}
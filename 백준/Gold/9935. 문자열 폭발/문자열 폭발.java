import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int strLen = str.length, bombLen = bomb.length;
        for (int i = 0; i < strLen; i++) {
            stack.push(str[i]);

            int bdx = bombLen - 1;
            while (!stack.isEmpty() && bdx >= 0 && stack.peek() == bomb[bdx]) {
                stack.pop();
                bdx--;
            }
            while (bdx >= 0 && bdx < bombLen - 1) stack.push(bomb[++bdx]);
        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) sb.append(stack.pop());
            System.out.println(sb.reverse());
        }
    }
}
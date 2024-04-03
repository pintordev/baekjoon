import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> deque = new ArrayDeque<>();
        Pattern pattern = Pattern.compile("\\[|,|\\]");
        while (t-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] numbers = pattern.split(br.readLine());
            for (int i = 1; i <= n; i++) deque.add(numbers[i]);
            int commandsLen = commands.length;
            boolean dirFlag = true, isError = false;
            for (int i = 0; i < commandsLen; i++) {
                if (commands[i] == 'R') dirFlag = !dirFlag;
                else {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (dirFlag) deque.pollFirst();
                    else deque.pollLast();
                }
            }
            if (isError) continue;
            sb.append('[');
            while (!deque.isEmpty()) {
                if (dirFlag) sb.append(deque.pollFirst());
                else sb.append(deque.pollLast());
                if (!deque.isEmpty()) sb.append(',');
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb);
    }
}
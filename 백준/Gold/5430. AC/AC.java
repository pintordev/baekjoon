import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] numbers = br.readLine().split("\\[|,|\\]");
            int commandsLen = commands.length;
            boolean dirFlag = true, isError = false;
            int start = 1, end = numbers.length - 1;
            for (int i = 0; i < commandsLen; i++) {
                if (commands[i] == 'R') dirFlag = !dirFlag;
                else {
                    if (start > end) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (dirFlag) start++;
                    else end--;
                }
            }
            if (isError) continue;
            sb.append('[');
            if (dirFlag) {
                for (int i = start; i <= end; i++) {
                    sb.append(numbers[i]);
                    if (i < end) sb.append(',');
                }
            } else {
                for (int i = end; i >= start; i--) {
                    sb.append(numbers[i]);
                    if (i > start) sb.append(',');
                }
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb);
    }
}
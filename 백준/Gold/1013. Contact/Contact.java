import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Pattern pattern = Pattern.compile("(100+1+|01)+");
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            if (pattern.matcher(br.readLine()).matches()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] bits = br.readLine().replaceAll("::", ":-:").split(":");

        StringBuilder sb = new StringBuilder();
        int count = bits.length, bias = 0;
        for (int i = 0; i < count; i++) {
            if (bits[i].isEmpty()) {
                bias = 1;
                continue;
            }
            if (bits[i].equals("-")) sb.append("0000:".repeat(9 - count + bias));
            else {
                int len = bits[i].length();
                sb.append("0".repeat(4 - len)).append(bits[i]).append(":");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
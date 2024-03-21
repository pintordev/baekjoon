import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        while (true) {
            int c = System.in.read();
            if (c == 32 || c == 10) {
                max = Math.max(max, Integer.parseInt(sb.reverse().toString()));
                sb.delete(0, sb.length());
            } else {
                sb.append(c - 48);
            }
            if (c == 10) break;
        }
        System.out.println(max);
    }
}
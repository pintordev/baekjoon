import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int[] stack = new int[n];
        int idx = -1;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String command = readString();
            if (command.equals("push")) stack[++idx] = read();
            else if (command.equals("pop")) {
                if (idx == -1) sb.append(idx).append('\n');
                else {
                    sb.append(stack[idx]).append('\n');
                    stack[idx--] = 0;
                }
            }
            else if (command.equals("size")) sb.append(idx + 1).append('\n');
            else if (command.equals("empty")) sb.append(idx == -1 ? 1 : 0).append('\n');
            else if (command.equals("top")) {
                if (idx == -1) sb.append(idx).append('\n');
                else sb.append(stack[idx]).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}
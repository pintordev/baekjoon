import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        char[][] c = new char[5][15];
        for (int i = 0; i < 5; i++) c[i] = read();

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (c[i][j] > 32) sb.append(c[i][j]);
            }
        }
        System.out.println(sb);
    }

    public static char[] read() throws IOException {
        char[] c = new char[15];
        int i = 0, ch;
        while ((ch = System.in.read()) > 32) c[i++] = (char) ch;
        return c;
    }
}
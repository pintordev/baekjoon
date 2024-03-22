import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(Integer.parseInt(read(), Integer.parseInt(read())));
    }

    public static String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) sb.append((char) c);
        return sb.toString();
    }
}
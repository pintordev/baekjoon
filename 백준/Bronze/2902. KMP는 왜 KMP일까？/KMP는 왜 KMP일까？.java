import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) != 10) {
            if (c >= 65 && c <= 90) sb.append((char) c);
        }
        System.out.println(sb);
    }
}
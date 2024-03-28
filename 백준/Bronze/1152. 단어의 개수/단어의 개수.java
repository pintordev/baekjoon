import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int cnt = 0;
        int p = System.in.read();
        int c;
        while (true) {
            c = System.in.read();
            if (c == 32 && p != 32) cnt++;
            if (c == 10) {
                if (p != 32) cnt++;
                break;
            } 
            p = c;
        }
        System.out.println(cnt);
    }
}
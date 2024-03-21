import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        
        int n = read();
        
        int sum = 0;
        while(n-- > 0) sum += readUnit();
        
        System.out.println(sum);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }

    public static int readUnit() throws IOException {
        int n;
        if ((n = System.in.read()) == 13) n = System.in.read();
        return n & 15;
    }
}
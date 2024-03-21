import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        
        int sum = 0;
        while(--n >= 0) sum += c[n] - 48;
        
        System.out.println(sum);
    }
}
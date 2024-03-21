import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] map = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
                     7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        
        int sum = 0, c;
        while ((c = System.in.read()) != 10) sum += map[c - 65] + 1;
        System.out.println(sum);
    }
}
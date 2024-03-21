import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] num = new int[2];
        int i = 0, j = 1, c;
        while ((c = System.in.read()) != 10) {
            if (c == 32) {
                i++;
                j = 1;
            } else {
                num[i] += (c - 48) * j;
                j *= 10;
            }
        }
        System.out.println(Math.max(num[0], num[1]));
    }
}
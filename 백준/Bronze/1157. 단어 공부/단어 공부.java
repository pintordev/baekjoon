import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] chars = new int[26];
        int c, max = 0;
        while ((c = System.in.read()) != 10) {
            if (c >= 'a') c -= 32;
            chars[c - 'A']++;
            max = Math.max(max, chars[c - 'A']);
        }

        int count = 0, idx = 0;
        for (int i = 0; i < 26; i++) {
            if (chars[i] == max) {
                count++;
                idx = i;
            }
        }

        if (count == 1) System.out.println((char) (idx + 'A'));
        else System.out.println('?');
    }
}
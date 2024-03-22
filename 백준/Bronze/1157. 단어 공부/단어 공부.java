import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] chars = new int[26];
        int c;
        while ((c = System.in.read()) != 10) {
            if (c >= 'a') c -= 32;
            chars[c - 'A']++;
        }

        int max = 0, ch = '?';
        for (int i = 0; i < 26; i++) {
            if (chars[i] > max) {
                max = chars[i];
                ch = i + 'A';
            } else if (chars[i] == max) {
                ch = '?';
            }
        }

        System.out.println((char) ch);
    }
}
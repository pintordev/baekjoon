import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int[] chars = new int[26];

        int c;
        while ((c = System.in.read()) != 10) chars[c - 65]++;

        StringBuilder sb = new StringBuilder();
        char hasOdd = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 65);
            sb.append((ch + "").repeat(chars[i] / 2));
            
            if (chars[i] % 2 == 0) continue;
            
            if (hasOdd == 0) hasOdd = ch;
            else {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        System.out.print(sb);
        if (hasOdd != 0) System.out.print(hasOdd);
        System.out.println(sb.reverse());
    }
}
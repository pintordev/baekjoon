import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int count = 0, ch, chp = -1, chpp = -1;
        while ((ch = System.in.read()) != 10) {
            count++;
            if (ch == 61 && chp == 'z' && chpp == 'd') count -= 2;
            else if (ch == 61 && (chp == 'c' || chp == 's' || chp == 'z')) count--;
            else if (ch == 45 && (chp == 'c' || chp == 'd')) count--;
            else if (ch == 106 && (chp == 'l' || chp == 'n')) count--;
            chpp = chp;
            chp = ch;
        }

        System.out.println(count);
    }
}
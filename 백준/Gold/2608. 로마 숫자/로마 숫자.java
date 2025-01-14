import java.io.IOException;
import java.util.*;

public class Main {
    public static Map<String, Integer> rti;
    public static Map<Integer, String> itr;

    public static void main(String[] args) throws IOException {
        init();

        int a = romanToInt(readChars(15));
        int b = romanToInt(readChars(15));

        StringBuilder sb = new StringBuilder();
        sb.append(a + b).append('\n');
        sb.append(intToRoman(a + b));
        System.out.println(sb);
    }

    public static void init() {
        rti = new HashMap<>();
        rti.put("I", 1);
        rti.put("IV", 4);
        rti.put("V", 5);
        rti.put("IX", 9);
        rti.put("X", 10);
        rti.put("XL", 40);
        rti.put("L", 50);
        rti.put("XC", 90);
        rti.put("C", 100);
        rti.put("CD", 400);
        rti.put("D", 500);
        rti.put("CM", 900);
        rti.put("M", 1000);

        itr = new TreeMap<>(Comparator.comparingInt(i -> -i));
        itr.put(1, "I");
        itr.put(4, "IV");
        itr.put(5, "V");
        itr.put(9, "IX");
        itr.put(10, "X");
        itr.put(40, "XL");
        itr.put(50, "L");
        itr.put(90, "XC");
        itr.put(100, "C");
        itr.put(400, "CD");
        itr.put(500, "D");
        itr.put(900, "CM");
        itr.put(1000, "M");
    }

    public static int romanToInt(char[] roman) {
        int n = 0;
        for (int i = 0, len = roman.length; i < len; i++) {
            StringBuilder sb = new StringBuilder().append(roman[i]);
            char c = roman[i];
            if ((c == 'I' || c == 'X' || c == 'C') && i + 1 < len) {
                String s = sb.append(roman[i + 1]).toString();
                if (rti.containsKey(s)) {
                    n += rti.get(s);
                    i++;
                    continue;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            n += rti.get(sb.toString());
        }
        return n;
    }

    public static String intToRoman(int i) {
        StringBuilder sb = new StringBuilder();
        for (int n : itr.keySet()) {
            sb.append(itr.get(n).repeat(i / n));
            i %= n;
        }
        return sb.toString();
    }

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] name = br.readLine().toCharArray();

        Map<Character, Integer> map = new TreeMap<>();
        int len = name.length;
        for (int i = 0; i < len; i++) {
            Integer value = map.putIfAbsent(name[i], 1);
            if (value != null) map.put(name[i], value + 1);
        }

        StringBuilder sb = new StringBuilder();
        boolean canMake = true;
        char hasOdd = 0;
        for (var entry : map.entrySet()) {
            sb.append((entry.getKey() + "").repeat(entry.getValue() / 2));
            if (entry.getValue() % 2 == 0) continue;
            if (hasOdd == 0) hasOdd = entry.getKey();
            else {
                canMake = false;
                break;
            }
        }

        if (!canMake) System.out.println("I'm Sorry Hansoo");
        else {
            System.out.print(sb);
            if (hasOdd != 0) System.out.print(hasOdd);
            System.out.println(sb.reverse());
        }
    }
}
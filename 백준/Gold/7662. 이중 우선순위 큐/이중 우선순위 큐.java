import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> dpq = new TreeMap<>();
        String[] input;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                input = br.readLine().split(" ");
                if (input[0].equals("I")) {
                    int key = Integer.parseInt(input[1]);
                    Integer value = dpq.putIfAbsent(key, 1);
                    if (value != null) {
                        dpq.put(key, value + 1);
                    }
                } else if (!dpq.isEmpty()) {
                    int key;
                    if (input[1].equals("1")) {
                        key = dpq.lastKey();
                    } else {
                        key = dpq.firstKey();
                    }
                    int value = dpq.get(key);
                    if (value == 1) {
                        dpq.remove(key);
                    } else {
                        dpq.put(key, value - 1);
                    }
                }
            }

            if (dpq.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(dpq.lastKey()).append(' ').append(dpq.firstKey()).append('\n');
            }

            dpq.clear();
        }
        System.out.println(sb);
    }
}
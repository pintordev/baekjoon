import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> clothes = new HashMap<>();
        String[] input;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                Integer value = clothes.putIfAbsent(input[1], 1);
                if (value != null) {
                    clothes.put(input[1], value + 1);
                }
            }

            int cases = 1;
            for (int value : clothes.values()) {
                cases *= (value + 1);
            }
            sb.append(cases - 1).append('\n');

            clothes.clear();
        }
        System.out.println(sb);
    }
}
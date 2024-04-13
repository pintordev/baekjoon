import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Wire[] wires = new Wire[n];
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            wires[i] = new Wire(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(wires);

        int[] memo = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[i].b > wires[j].b) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }
        System.out.println(n - max);
    }
}

class Wire implements Comparable<Wire> {
    int a;
    int b;

    public Wire(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Wire o) {
        return this.a - o.a;
    }
}
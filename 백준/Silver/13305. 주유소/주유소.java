import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] road;
    public static int[] station;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        int fee = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int j = i;
            for (; j < n && station[i] <= station[j]; j++) {
                sum += road[j];
            }
            fee += sum * station[i];
            i = j - 1;
        }
        System.out.println(fee);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) - 1;

        String[] input = br.readLine().split(" ");
        road = new int[n];
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        station = new int[n];
        for (int i = 0; i < n; i++) {
            station[i] = Integer.parseInt(input[i]);
        }
    }
}
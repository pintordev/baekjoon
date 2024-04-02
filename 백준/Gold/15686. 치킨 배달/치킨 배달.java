import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static int m;
    public static List<int[]> house;
    public static int houseSize;
    public static List<int[]> chicken;
    public static int chickenSize;
    public static boolean[] chosen;
    public static int chickenLen = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("1")) house.add(new int[]{i, j});
                else if (input[j].equals("2")) chicken.add(new int[]{i, j});
            }
        }

        houseSize = house.size();
        chickenSize = chicken.size();
        chosen = new boolean[chickenSize];

        chose(0, 0);
        System.out.println(chickenLen);
    }

    public static void chose(int depth, int start) {

        if (depth == m) {
            int localChickenLen = 0;
            for (int i = 0; i < houseSize; i++) localChickenLen += calChickenLen(i);
            chickenLen = Math.min(chickenLen, localChickenLen);
            return;
        }

        for (int i = start; i < chickenSize; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                chose(depth + 1, i + 1);
                chosen[i] = false;
            }
        }
    }

    public static int calChickenLen(int i) {
        int len = Integer.MAX_VALUE;
        int x = house.get(i)[0];
        int y = house.get(i)[1];
        for (int j = 0; j < chickenSize; j++) {
            if (!chosen[j]) continue;
            len = Math.min(len, Math.abs(x - chicken.get(j)[0]) + Math.abs(y - chicken.get(j)[1]));
        }
        return len;
    }
}
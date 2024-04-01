import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static int[][] a = new int[100][100];
    public static int maxR = 3;
    public static int maxC = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]) - 1;
        int c = Integer.parseInt(input[1]) - 1;
        int k = Integer.parseInt(input[2]);


        for (int i = 0; i < maxR; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < maxC; j++) a[i][j] = Integer.parseInt(input[j]);
        }

        int t = 0;
        while (a[r][c] != k) {
            if (t > 100) {
                t = -1;
                break;
            }
            if (maxR >= maxC) row();
            else col();
            t++;
        }

        System.out.println(t);
    }

    public static void row() {
        int maxJdx = 0;
        for (int i = 0; i < maxR; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < maxC; j++) {
                if (a[i][j] == 0) continue;
                Integer value = map.putIfAbsent(a[i][j], 1);
                if (value != null) map.put(a[i][j], value + 1);
                a[i][j] = 0;
            }

            Set<int[]> set = new TreeSet<>((o1, o2) -> {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            });
            for (var entry : map.entrySet()) {
                set.add(new int[]{entry.getKey(), entry.getValue()});
            }

            int jdx = 0;
            for (int[] sub : set) {
                a[i][jdx] = sub[0];
                a[i][jdx + 1] = sub[1];
                if (jdx + 2 >= 100) break;
                jdx += 2;
            }
            maxJdx = Math.max(maxJdx, jdx);
        }
        maxC = maxJdx;
    }

    public static void col() {
        int maxIdx = 0;
        for (int j = 0; j < maxC; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < maxR; i++) {
                if (a[i][j] == 0) continue;
                Integer value = map.putIfAbsent(a[i][j], 1);
                if (value != null) map.put(a[i][j], value + 1);
                a[i][j] = 0;
            }

            Set<int[]> set = new TreeSet<>((o1, o2) -> {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            });
            for (var entry : map.entrySet()) {
                set.add(new int[]{entry.getKey(), entry.getValue()});
            }

            int idx = 0;
            for (int[] sub : set) {
                a[idx][j] = sub[0];
                a[idx + 1][j] = sub[1];
                if (idx + 2 >= 100) break;
                idx += 2;
            }
            maxIdx = Math.max(maxIdx, idx);
        }
        maxR = maxIdx;
    }
}
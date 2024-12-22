import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static int limit = 2000;
    public static boolean[] complex;
    public static int size;
    public static int[] left;
    public static int[] right;
    public static List<Integer>[] candidate;
    public static boolean[] visited;
    public static int[] leftMatched;
    public static int[] rightMatched;

    public static void main(String[] args) throws IOException {
        findPrime();

        int n = read();
        size = n >> 1;
        left = new int[size];
        right = new int[size];

        int first = read();
        left[0] = first;
        boolean f = first % 2 == 0;
        int ldx = 1, rdx = 0;
        for (int i = 1; i < n; i++) {
            int num = read();
            try {
                if (f^(num % 2 == 0)) right[rdx++] = num;
                else left[ldx++] = num;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("-1");
                return;
            }
        }

        candidate = new List[size];
        for (int i = 0; i < size; i++) {
            candidate[i] = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (!complex[left[i] + right[j]]) candidate[i].add(j);
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        visited = new boolean[size];
        leftMatched = new int[size];
        rightMatched = new int[size];
        for (int num : candidate[0]) {
            Arrays.fill(leftMatched, -1);
            Arrays.fill(rightMatched, -1);
            leftMatched[0] = num;
            rightMatched[num] = 0;

            int cnt = 1;
            for (int i = 1; i < size; i++) {
                Arrays.fill(visited, false);
                if (dfs(i)) cnt++;
            }
            if (cnt == size) set.add(right[num]);
        }

        if (set.isEmpty()) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : set) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    public static void findPrime() {
        complex = new boolean[limit];
        complex[0] = complex[1] = true;

        for (int i = 2; i < limit; i++) {
            if (complex[i]) continue;
            for (int j = i * i; j < limit; j += i) {
                complex[j] = true;
            }
        }
    }

    public static boolean dfs(int cur) {
        for (int next : candidate[cur]) {
            if (cur == 0 || visited[next]) continue;
            visited[next] = true;
            if (rightMatched[next] == -1 || dfs(rightMatched[next])) {
                leftMatched[cur] = next;
                rightMatched[next] = cur;
                return true;
            }
        }
        return false;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
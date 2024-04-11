import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Node> sharks = new ArrayList<>();
        List<Node> blanks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (input[j].equals("1")) {
                    sharks.add(new Node(i, j));
                } else {
                    blanks.add(new Node(i, j));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (Node blank : blanks) {
            int min = Integer.MAX_VALUE;
            for (Node shark : sharks) {
                int d = Math.abs(blank.r - shark.r) + Math.abs(blank.c - shark.c) - Math.min(Math.abs(blank.r - shark.r), Math.abs(blank.c - shark.c));
                min = Math.min(min, d);
            }
            max = Math.max(max, min);
        }
        System.out.println(max);
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
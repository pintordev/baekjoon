import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Tower> towers = new Stack<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            Tower tower = new Tower(i + 1, Integer.parseInt(input[i]));
            while (!towers.isEmpty() && towers.peek().height < tower.height) towers.pop();
            if (towers.isEmpty()) sb.append('0').append(' ');
            else sb.append(towers.peek().idx).append(' ');
            towers.push(tower);
        }
        System.out.println(sb);
    }
}

class Tower {
    int idx;
    int height;

    public Tower(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}
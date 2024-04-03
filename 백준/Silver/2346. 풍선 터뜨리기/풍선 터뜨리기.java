import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Balloon> balloons = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) balloons.add(new Balloon(i + 1, Integer.parseInt(input[i])));
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true) {
            Balloon balloon = balloons.get(idx);
            sb.append(balloon.idx).append(' ');

            balloons.remove(idx);
            if (balloons.isEmpty()) break;

            int move = balloon.move;
            int size = balloons.size();
            if (move > 0) move--;
            idx = (idx + move) % size;
            while (idx < 0 ) idx += size;
        }
        System.out.println(sb);
    }
}

class Balloon {
    int idx;
    int move;

    public Balloon(int idx, int move) {
        this.idx = idx;
        this.move = move;
    }
}
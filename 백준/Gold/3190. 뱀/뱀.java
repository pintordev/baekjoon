import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;

class Main {
    public static void main(String[] args) throws IOException {

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1];

        int k = Integer.parseInt(br.readLine());
        String[] input;
        while (k-- > 0) {
            input = br.readLine().split(" ");
            board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 2;
        }

        int l = Integer.parseInt(br.readLine());
        ArrayDeque<Turn> commands = new ArrayDeque<>();
        while (l-- > 0) {
            input = br.readLine().split(" ");
            commands.add(new Turn(Integer.parseInt(input[0]), input[1].charAt(0)));
        }

        int d = 0;
        int time = 0;
        int r = 1;
        int c = 1;
        ArrayDeque<Part> snake = new ArrayDeque<>();
        snake.add(new Part(r, c));
        board[r][c] = 1;
        while (true) {
            r += dir[d][0];
            c += dir[d][1];
            time++;

            if (r < 1 || r > n || c < 1 || c > n) break;
            if (board[r][c] == 1) break;

            if (board[r][c] == 0) {
                Part tail = snake.poll();
                board[tail.r][tail.c] = 0;
            }

            snake.add(new Part(r, c));
            board[r][c] = 1;

            if (!commands.isEmpty() && commands.peek().time == time) {
                Turn turn = commands.poll();
                if (turn.dir == 'D') d = (d + 1) % 4;
                else d = (d + 3) % 4;
            }
        }
        System.out.println(time);
    }
}

class Part {
    int r;
    int c;

    public Part(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Turn {
    int time;
    char dir;

    public Turn(int time, char dir) {
        this.time = time;
        this.dir = dir;
    }
}
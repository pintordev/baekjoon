import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static Group group;
    public static Group candidateGroup;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int score;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        while (true) {
            findGroup();
            if (group == null) {
                break;
            }
            removeBlocks();
            forceGravity();
            rotateBoard();
            forceGravity();
        }
        System.out.println(score);
    }

    public static void findGroup() {
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] <= 0 || visited[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }
    }

    public static void bfs(int r, int c) {
        candidateGroup = new Group();
        int color = board[r][c];

        Queue<Block> queue = new ArrayDeque<>();
        Block block = new Block(r, c, board[r][c]);
        queue.add(block);
        visited[r][c] = true;
        candidateGroup.add(block);
        while (!queue.isEmpty()) {
            Block now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (!canMove(nr, nc, color)) {
                    continue;
                }
                Block next = new Block(nr, nc, board[nr][nc]);
                queue.add(next);
                visited[nr][nc] = true;
                candidateGroup.add(next);
            }
        }

        resetRainbowVisit();
        if (candidateGroup.blocks.size() < 2) {
            return;
        }
        if (group == null) {
            group = candidateGroup;
        }
        else if (!group.compareTo(candidateGroup)) {
            group = candidateGroup;
        }
    }

    public static boolean canMove(int nr, int nc, int color) {
        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
            return false;
        }
        if (board[nr][nc] < 0) {
            return false;
        }
        if (visited[nr][nc]) {
            return false;
        }
        if (board[nr][nc] != 0 && board[nr][nc] != color) {
            return false;
        }
        return true;
    }

    public static void resetRainbowVisit() {
        for (Block block : candidateGroup.blocks) {
            if (block.color != 0) {
                continue;
            }
            visited[block.r][block.c] = false;
        }
    }

    public static void removeBlocks() {
        for (Block block : group.blocks) {
            board[block.r][block.c] = -2;
        }
        score += group.blocks.size() * group.blocks.size();
        group = null;
    }

    public static void forceGravity() {
        for (int j = 0; j < n; j++) {
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j] == -1) {
                    idx = i - 1;
                    continue;
                }
                if (board[i][j] == -2) {
                    continue;
                }
                board[idx][j] = board[i][j];
                if (idx != i) {
                    board[i][j] = -2;
                }
                idx--;
            }
        }
    }

    public static void rotateBoard() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - 1 - j][i] = board[i][j];
            }
        }
        board = temp;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}

class Group {
    public int rainbow;
    public int stdRow;
    public int stdCol;
    public List<Block> blocks;

    public Group() {
        this.rainbow = 0;
        this.blocks = new ArrayList<>();
    }

    public void add(Block block) {
        if (this.blocks.isEmpty()) {
            this.stdRow = block.r;
            this.stdCol = block.c;
        }
        this.blocks.add(block);
        if (block.color == 0) {
            this.rainbow++;
        }
    }

    public boolean compareTo(Group candidateGroup) {
        if (this.blocks.size() > candidateGroup.blocks.size()) {
            return true;
        } else if (this.blocks.size() == candidateGroup.blocks.size()) {
            if (this.rainbow > candidateGroup.rainbow) {
                return true;
            } else if (this.rainbow == candidateGroup.rainbow) {
                if (this.stdRow > candidateGroup.stdRow) {
                    return true;
                } else if (this.stdRow == candidateGroup.stdRow) {
                    if (this.stdCol > candidateGroup.stdCol) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Block {
    int r;
    int c;
    int color;

    public Block(int r, int c, int color) {
        this.r = r;
        this.c = c;
        this.color = color;
    }
}
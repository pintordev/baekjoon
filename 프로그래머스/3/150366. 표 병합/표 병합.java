import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        Cell.init();
        for (String command : commands) {
            Cell.run(command);
        }
        return Cell.flush();
    }
}

class Cell {
    public static Cell[] table;
    public static List<String> buffer;

    public static void init() {
        table = new Cell[2500];
        for (int i = 0; i < 2500; i++) {
            table[i] = new Cell();
        }
        buffer = new ArrayList<>();
    }

    public static void run(String command) {
        String[] bits = command.split(" ");
        if (bits[0].equals("UPDATE") && bits.length == 4) {
            int r = Integer.parseInt(bits[1]);
            int c = Integer.parseInt(bits[2]);
            update(r, c, bits[3]);
        } else if (bits[0].equals("UPDATE") && bits.length == 3) {
            update(bits[1], bits[2]);
        } else if (bits[0].equals("MERGE")) {
            int r1 = Integer.parseInt(bits[1]);
            int c1 = Integer.parseInt(bits[2]);
            int r2 = Integer.parseInt(bits[3]);
            int c2 = Integer.parseInt(bits[4]);
            merge(r1, c1, r2, c2);
        } else if (bits[0].equals("UNMERGE")) {
            int r = Integer.parseInt(bits[1]);
            int c = Integer.parseInt(bits[2]);
            unmerge(r, c);
        } else if (bits[0].equals("PRINT")) {
            int r = Integer.parseInt(bits[1]);
            int c = Integer.parseInt(bits[2]);
            print(r, c);
        }
    }

    public static void update(int r, int c, String value) {
        int idx = rcToIdx(r, c);
        find(table[idx]).value = value;
    }

    public static void update(String value1, String value2) {
        for (Cell cell : table) {
            if (cell.value.equals(value1)) cell.value = value2;
        }
    }

    public static void merge(int r1, int c1, int r2, int c2) {
        int idx1 = rcToIdx(r1, c1);
        int idx2 = rcToIdx(r2, c2);

        Cell root1 = find(table[idx1]);
        Cell root2 = find(table[idx2]);

        union(root1, root2);
    }

    public static void unmerge(int r, int c) {
        int idx = rcToIdx(r, c);
        Cell root = find(table[idx]);
        table[idx] = new Cell(root.value);

        List<Cell> toUnmerge = new ArrayList<>();
        for (int i = 0; i < 2500; i++) {
            if (find(table[i]) == root) toUnmerge.add(table[i]);
        }

        for (Cell cell : toUnmerge) {
            cell.parent = cell;
            cell.rank = 1;
            cell.value = "";
        }
    }

    public static void print(int r, int c) {
        int idx = rcToIdx(r, c);
        Cell root = find(table[idx]);
        buffer.add(root.value.isBlank() ? "EMPTY" : root.value);
    }

    public static int rcToIdx(int r, int c) {
        return (r - 1) * 50 + c - 1;
    }

    public static Cell find(Cell cell) {
        if (cell.parent == cell) return cell;
        return find(cell.parent);
    }

    public static void union(Cell root1, Cell root2) {
        if (root1 == root2) return;

        String value = root1.value.isBlank() ? root2.value : root1.value;

        if (root1.rank > root2.rank) {
            root1.rank += root2.rank;
            root1.value = value;
            root2.parent = root1;
            root2.value = "";
        } else {
            root2.rank += root1.rank;
            root2.value = value;
            root1.parent = root2;
            root1.value = "";
        }
    }

    public static String[] flush() {
        return buffer.toArray(String[]::new);
    }

    public Cell parent;
    public int rank;
    public String value;

    public Cell() {
        this("");
    }

    public Cell(String value) {
        this.parent = this;
        this.rank = 1;
        this.value = value;
    }
}
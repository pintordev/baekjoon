import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        TreeSet<Problem> problems = new TreeSet<>();
        int n = read();
        while (n-- > 0) {
            problems.add(new Problem(read(), read()));
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> solved = new HashSet<>();
        int m = read();
        while (m-- > 0) {
            String cmd = readString();
            if (cmd.equals("recommend")) {
                if (read() == 1) {
                    sb.append(problems.last().number).append('\n');
                } else {
                    sb.append(problems.first().number).append('\n');
                }
            } else if (cmd.equals("add")) {
                Problem p = new Problem(read(), read());
                problems.add(p);
                solved.remove(p.number);
            } else {
                solved.add(read());
                while (!problems.isEmpty() && solved.contains(problems.last().number)) {
                    problems.pollLast();
                }
                while (!problems.isEmpty() && solved.contains(problems.first().number)) {
                    problems.pollFirst();
                }
            }
        }

        System.out.println(sb);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
    
    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}

class Problem implements Comparable<Problem> {
    int number;
    int level;

    public Problem(int number, int level) {
        this.number = number;
        this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
        if (this.level == o.level) {
            return this.number - o.number;
        }
        return this.level - o.level;
    }
}
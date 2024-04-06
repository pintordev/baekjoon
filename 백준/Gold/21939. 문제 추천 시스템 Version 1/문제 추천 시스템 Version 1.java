import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        TreeSet<Problem> problems = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            input = br.readLine().split(" ");
            problems.add(new Problem(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> solved = new HashSet<>();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            input = br.readLine().split(" ");
            if (input[0].equals("recommend")) {
                if (input[1].equals("1")) {
                    sb.append(problems.last().number).append('\n');
                } else {
                    sb.append(problems.first().number).append('\n');
                }
            } else if (input[0].equals("add")) {
                Problem p = new Problem(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                problems.add(p);
                solved.remove(p.number);
            } else {
                solved.add(Integer.parseInt(input[1]));
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
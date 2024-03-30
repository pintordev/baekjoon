import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<String> in = new LinkedList<>();
        for (int i = 0; i < n; i++) in.add(br.readLine());

        Set<String> over = new HashSet<>();
        while (!in.isEmpty()) {
            String car = br.readLine();
            if (in.peek().equals(car)) in.poll();
            else over.add(car);
            while (over.contains(in.peek())) in.poll();
        }
        System.out.println(over.size());
    }
}
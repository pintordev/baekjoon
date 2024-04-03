import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input[i]);

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) result[stack.pop()] = arr[i];
            stack.push(i);
        }
        while (!stack.isEmpty()) result[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(result[i]).append(' ');
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if (!stack.isEmpty() && a == 0) sum -= stack.pop();
            else {
                sum += a;
                stack.add(a);
            }
        }
        
        System.out.println(sum);
    }
}
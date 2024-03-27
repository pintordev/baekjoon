import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (j > i) sb.append(' ');
                else sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
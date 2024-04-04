import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] eq = br.readLine().split("-");
        int eqLen = eq.length;
        int sum = 0;
        for (int i = 0; i < eqLen; i++) {
            int localSum = 0;
            String[] plus = eq[i].split("\\+");
            for (String s : plus) {
                localSum += Integer.parseInt(s);
            }
            if (i >= 1) {
                sum -= localSum;
            } else {
                sum += localSum;
            }
        }
        System.out.println(sum);
    }
}
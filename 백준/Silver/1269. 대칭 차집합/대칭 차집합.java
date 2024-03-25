import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>(), B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) A.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int i = Integer.parseInt(st.nextToken());
            if (A.contains(i)) A.remove(i);
            else B.add(i);
        }

        System.out.println(A.size() + B.size());
    }
}
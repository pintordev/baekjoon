import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] date = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        int yDate = 0;
        for (int i = 0; i < x - 1; i++) yDate += date[i];
        yDate += y;
        System.out.println(day[yDate % 7]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Reservation[] reservations = new Reservation[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            reservations[i] = new Reservation(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(reservations, (a, b) -> {
            if (a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        int cnt = 0, end = 0;
        for (int i = 0; i < n; i++) {
            if (end <= reservations[i].start) {
                end = reservations[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

class Reservation {
    int start;
    int end;

    public Reservation(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
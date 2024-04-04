import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = read();
        Reservation[] reservations = new Reservation[n];
        for (int i = 0; i < n; i++) {
            reservations[i] = new Reservation(read(), read());
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

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
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
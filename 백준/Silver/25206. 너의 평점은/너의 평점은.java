import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        Map<String, Double> map = Map.of(
                "A+", 4.5,
                "A0", 4.0,
                "B+", 3.5,
                "B0", 3.0,
                "C+", 2.5,
                "C0", 2.0,
                "D+", 1.5,
                "D0", 1.0,
                "F", 0.0
        );

        double avg = 0, den = 0;
        int n = 0;
        for (int i = 0; i < 20; i++) {
            read();
            double credit = Double.parseDouble(read());
            String grade = read();
            if (!grade.equals("P")) {
                avg += credit * map.get(grade);
                den += credit;
            }
        }

        System.out.println(avg / den);
    }

    public static String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}
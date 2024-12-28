import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double x = read();
        double y = read();
        double c = read();

        double left = 0;
        double right = Math.min(x, y);
        while (right - left >= 0.001) {
            double mid = (left + right) / 2;
            double h1 = Math.sqrt(x * x - mid * mid);
            double h2 = Math.sqrt(y * y - mid * mid);
            double h = (h1 * h2) / (h1 + h2);
            if (h >= c) left = mid;
            else right = mid;
        }
        System.out.printf("%.3f", left);
    }

    public static Double read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return Double.parseDouble(sb.toString());
    }
}
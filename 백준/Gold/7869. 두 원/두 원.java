import java.io.IOException;

public class Main {
    public static double pi = Math.PI;

    public static void main(String[] args) throws IOException {
        Circle a = new Circle(readD(), readD(), readD());
        Circle b = new Circle(readD(), readD(), readD());

        double d = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        double area = 0;
        if (Math.abs(a.r - b.r) >= d) {
            area = pi * Math.pow(Math.min(a.r, b.r), 2);
        } else if (a.r + b.r > d) {
            double t1 = 2 * Math.acos((Math.pow(d, 2) + Math.pow(a.r, 2) - Math.pow(b.r, 2)) / (2 * d * a.r));
            double t2 = 2 * Math.acos((Math.pow(d, 2) + Math.pow(b.r, 2) - Math.pow(a.r, 2)) / (2 * d * b.r));

            double s1 = (a.r * a.r * (t1 - Math.sin(t1))) / 2;
            double s2 = (b.r * b.r * (t2 - Math.sin(t2))) / 2;

            area = s1 + s2;
        }

        System.out.printf("%.3f\n", area);
    }

    public static double readD() throws IOException {
        return Double.parseDouble(readString());
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}

class Circle {
    double x;
    double y;
    double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
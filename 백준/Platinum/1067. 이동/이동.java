import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] x = new int[n << 1];
        for (int i = 0; i < n; i++) {
            x[i] = read();
            x[i + n] = x[i];
        }

        int[] y = new int[n];
        for (int i = 1; i <= n; i++) {
            y[n - i] = read();
        }

        int[] res = mul(x, y);
        int max = 0;
        for (int i = n - 1; i < n + n - 1; i++) {
            max = Math.max(max, res[i]);
        }
        System.out.println(max);
    }

    public static int[] mul(int[] x, int[] y) {
        int len = 1;
        while (len < x.length + y.length) {
            len <<= 1;
        }

        Complex[] a = new Complex[len];
        Complex[] b = new Complex[len];
        for (int i = 0; i < len; i++) {
            a[i] = new Complex(i < x.length ? x[i] : 0, 0);
            b[i] = new Complex(i < y.length ? y[i] : 0, 0);
        }

        fft(a, false);
        fft(b, false);
        for (int i = 0; i < len; i++) {
            a[i] = a[i].mul(b[i]);
        }

        fft(a, true);

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = (int) Math.round(a[i].real);
        }
        return res;
    }

    public static void fft(Complex[] a, boolean inverted) {
        int n = a.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            while (j >= bit) {
                j -= bit;
                bit >>= 1;
            }
            j += bit;
            if (i < j) {
                Complex tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double angle = 2 * Math.PI / len * (inverted ? -1 : 1);
            Complex wlen = new Complex(Math.cos(angle), Math.sin(angle));
            for (int i = 0; i < n; i += len) {
                Complex w = new Complex(1, 0);
                for (int j = 0; j < len / 2; j++) {
                    Complex u = a[i + j];
                    Complex v = a[i + j + len / 2].mul(w);
                    a[i + j] = u.add(v);
                    a[i + j + len / 2] = u.sub(v);
                    w = w.mul(wlen);
                }
            }
        }

        if (inverted) {
            for (int i = 0; i < n; i++) {
                a[i] = a[i].div(n);
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Complex {
    double real, imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex c) {
        return new Complex(real + c.real, imag + c.imag);
    }

    public Complex sub(Complex c) {
        return new Complex(real - c.real, imag - c.imag);
    }

    public Complex mul(Complex c) {
        return new Complex(real * c.real - imag * c.imag, real * c.imag + imag * c.real);
    }

    public Complex div(double d) {
        return new Complex(real / d, imag / d);
    }
}
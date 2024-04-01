import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int n;
    public static int m;
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) matrix[i][j] = Integer.parseInt(input[j]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < r; i++) {
            int op = Integer.parseInt(input[i]);
            switch (op) {
                case 1: op1(); break;
                case 2: op2(); break;
                case 3: op3(); break;
                case 4: op4(); break;
                case 5: op5(); break;
                case 6: op6(); break;
                default: break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) sb.append(matrix[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void op1() {
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
    }

    public static void op2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }
        }
    }

    public static void op3() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n - 1 - i] = matrix[i][j];
            }
        }

        matrix = temp;
        n = matrix.length;
        m = matrix[0].length;
    }

    public static void op4() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[m - 1 - j][i] = matrix[i][j];
            }
        }

        matrix = temp;
        n = matrix.length;
        m = matrix[0].length;
    }

    public static void op5() {
        int halfN = n / 2;
        int halfM = m / 2;
        int[][] temp = new int[halfN][halfM];
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                temp[i][j] = matrix[i + halfN][j];
            }
        }

        for (int i = halfN; i < n; i++) {
            for (int j = 0; j < halfM; j++) {
                matrix[i][j] = matrix[i][j + halfM];
            }
        }

        for (int i = halfN; i < n; i++) {
            for (int j = halfM; j < m; j++) {
                matrix[i][j] = matrix[i - halfN][j];
            }
        }

        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < m; j++) {
                matrix[i][j] = matrix[i][j - halfM];
            }
        }

        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    public static void op6() {
        int halfN = n / 2;
        int halfM = m / 2;
        int[][] temp = new int[halfN][halfM];
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                temp[i][j] = matrix[i + halfN][j];
            }
        }

        for (int i = halfN; i < n; i++) {
            for (int j = 0; j < halfM; j++) {
                matrix[i][j] = matrix[i - halfN][j];
            }
        }

        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                matrix[i][j] = matrix[i][j + halfM];
            }
        }

        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < m; j++) {
                matrix[i][j] = matrix[i + halfN][j];
            }
        }

        for (int i = halfN; i < n; i++) {
            for (int j = halfM; j < m; j++) {
                matrix[i][j] = temp[i - halfN][j - halfM];
            }
        }
    }
}
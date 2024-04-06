import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int c;
        while ((c = System.in.read()) != 10) {
            sb.append((char) c);
            while (sb.length() >= 4 && sb.substring(sb.length() - 4).equals("PPAP")) {
                sb.setLength(sb.length() - 4);
                sb.append('P');
            }
        }

        if (sb.length() == 1 && sb.charAt(0) == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
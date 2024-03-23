import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) members[i] = new Member(read(), readChars());
        Arrays.sort(members, (o1, o2) -> {
            if (o1.age == o2.age) return o1.id - o2.id;
            return o1.age - o2.age;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(members[i].age).append(' ')
                    .append(members[i].name).append('\n');
        }
        System.out.println(sb);
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[100];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Member {
    public static int size = 0;
    public int id;
    public int age;
    public String name;

    public Member(int age, char[] names) {
        this.id = ++size;
        this.age = age;
        this.name = new String(names);
    }
}
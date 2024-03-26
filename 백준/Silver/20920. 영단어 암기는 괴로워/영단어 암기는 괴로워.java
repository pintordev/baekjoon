import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String s = br.readLine();
            if (s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq == o2.freq && o1.word.length() == o2.word.length()) return o1.word.compareTo(o2.word);
            else if (o1.freq == o2.freq) return o2.word.length() - o1.word.length();
            else return o2.freq - o1.freq;
        });
        for (String key : map.keySet()) pq.add(new Word(key, map.get(key)));

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll().word).append('\n');
        System.out.println(sb);
    }
}

class Word {
    int freq;
    String word;

    public Word(String word, int freq) {
        this.freq = freq;
        this.word = word;
    }
}
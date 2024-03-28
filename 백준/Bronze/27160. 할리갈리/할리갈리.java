import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Card> cards = new HashSet<>();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            cards.add(new Card(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        boolean isMade = false;
        for (Card card : cards) {
            if (card.cnt == 5) {
                isMade = true;
                System.out.println("YES");
                break;
            }
        }
        if (!isMade) System.out.println("NO");
    }
}

class Card {
    public String name;
    public int cnt;

    public Card(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card)) return false;
        Card card = (Card) obj;
        if (this.name.charAt(0) == card.name.charAt(0)) {
            card.cnt += this.cnt;
            return true;
        }
        return false;
    }
}
import java.util.*;

class Solution {
    public static int n;
    public static int coin;

    public int solution(int coin, int[] cards) {
        n = cards.length;
        this.coin = coin;

        Set<Integer> origin = new HashSet<>();
        for (int i = 0; i < n / 3; i++) {
            origin.add(cards[i]);
        }

        Set<Integer> extra = new HashSet<>();
        int idx = n / 3;
        int rnd = 1 + 0;
        while (idx < n) {
            extra.add(cards[idx]);
            extra.add(cards[idx + 1]);
            idx += 2;
            rnd++;

            if (canMade(origin, 0)) continue;
            if (canMade(origin, extra)) continue;
            if (canMade(extra, 2)) continue;
            rnd--;
            break;
        }

        return rnd;
    }

    public boolean canMade(Set<Integer> set, int type) {
        if (coin < type) return false;
        for (int a : set) {
            if (!set.contains(n + 1 - a)) continue;
            set.remove(a);
            set.remove(n + 1 - a);
            coin -= type;
            return true;
        }
        return false;
    }

    public boolean canMade(Set<Integer> setA, Set<Integer> setB) {
        if (coin < 1) return false;
        for (int a : setA) {
            if (!setB.contains(n + 1 - a)) continue;
            setA.remove(a);
            setB.remove(n + 1 - a);
            coin -= 1;
            return true;
        }
        return false;
    }
}
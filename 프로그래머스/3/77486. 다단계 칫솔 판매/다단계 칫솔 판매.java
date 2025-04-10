import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Node> map = new HashMap<>();
        map.put("-", new Node("-", null));
        int n = enroll.length;
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], new Node(enroll[i], map.get(referral[i])));
        }

        int m = seller.length;
        for (int i = 0; i < m; i++) {
            map.get(seller[i]).earn(amount[i] * 100);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(enroll[i]).earning;
        }
        return result;
    }
}

class Node {
    Node parent;
    String name;
    int earning;

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
        this.earning = 0;
    }

    public void earn(int price) {
        int fee = price / 10;
        this.earning += price - fee;
        if (this.parent != null) {
            this.parent.earn(fee);
        }
    }
}
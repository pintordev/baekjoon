import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] bits = operation.split(" ");
            if (bits[0].equals("I")) {
                minQ.add(Integer.parseInt(bits[1]));
                maxQ.add(Integer.parseInt(bits[1]));
            } else if (bits[0].equals("D") && Integer.parseInt(bits[1]) == -1) {
                maxQ.remove(minQ.poll());
            } else {
                minQ.remove(maxQ.poll());
            }
        }

        return new int[]{maxQ.isEmpty() ? 0 : maxQ.poll(),
                minQ.isEmpty() ? 0 : minQ.poll()};
    }
}
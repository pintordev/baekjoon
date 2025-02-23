import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        Stack<Integer> dstack = new Stack<>();
        Stack<Integer> pstack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) dstack.add(i);
            if (pickups[i] != 0) pstack.add(i);
        }

        long result = 0;
        while (!dstack.isEmpty() || !pstack.isEmpty()) {

            int e = Math.max(!dstack.isEmpty() ? dstack.peek() : 0,
                    !pstack.isEmpty() ? pstack.peek() : 0);
            result += 2 * (e + 1);

            remove(dstack, deliveries, cap);
            remove(pstack, pickups, cap);
        }

        return result;
    }

    public void remove(Stack<Integer> stack, int[] arr, int cap) {
        while (!stack.isEmpty() && cap > 0) {
            if (arr[stack.peek()] <= cap) cap -= arr[stack.pop()];
            else {
                arr[stack.peek()] -= cap;
                cap = 0;
            }
        }
    }
}
import java.util.*;

class Solution {
    public static Map<Long, Long> reserved;

    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;

        reserved = new HashMap<>();
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            result[i] = reserve(room_number[i]);
        }
        return result;
    }

    public long reserve(long rm) {
        var value = reserved.putIfAbsent(rm, rm + 1);
        if (value == null) return rm;

        long nextRm = reserve(value);
        reserved.put(rm, nextRm + 1);
        return nextRm;
    }
}
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        int busTime = timeStringToMin("09:00");
        int busNum = 0;
        PriorityQueue<Integer> crewTime = new PriorityQueue<>();
        for (String time : timetable) {
            crewTime.add(timeStringToMin(time));
        }

        while (busNum < n) {
            int passenger = 0;
            while (!crewTime.isEmpty() && crewTime.peek() <= busTime && passenger < m) {
                if (busNum == n - 1 && passenger == m - 1) return minToTimeString(crewTime.poll() - 1);
                crewTime.poll();
                passenger++;
            }
            busNum++;
            busTime += t;
        }

        return minToTimeString(busTime - t);
    }

    public int timeStringToMin(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public String minToTimeString(int min) {
        return String.format("%02d:%02d", min / 60, min % 60);
    }
}
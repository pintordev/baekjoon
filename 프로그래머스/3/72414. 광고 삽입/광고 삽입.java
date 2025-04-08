class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        int n = timeToSec(play_time) + 1;
        long[] accTime = new long[n];
        for (String log : logs) {
            int start = timeToSec(log.substring(0, 8));
            int end = timeToSec(log.substring(9));
            accTime[start]++;
            accTime[end]--;
        }

        for (int i = 1; i < n; i++) {
            accTime[i] += accTime[i - 1];
        }

        for (int i = 1; i < n; i++) {
            accTime[i] += accTime[i - 1];
        }

        int advTime = timeToSec(adv_time);
        long maxView = accTime[advTime - 1];
        int maxTime = 0;
        for (int i = 0; i + advTime < n; i++) {
            long view = accTime[i + advTime] - accTime[i];
            if (view > maxView) {
                maxView = view;
                maxTime = i + 1;
            }
        }
        return secToTime(maxTime);
    }

    public int timeToSec(String playTime) {
        int hr = Integer.parseInt(playTime.substring(0, 2));
        int min = Integer.parseInt(playTime.substring(3, 5));
        int sec = Integer.parseInt(playTime.substring(6, 8));

        return hr * 3600 + min * 60 + sec;
    }

    public String secToTime(int sec) {
        int hr = sec / 3600;
        int min = sec % 3600 / 60;
        sec = sec % 60;

        return String.format("%02d:%02d:%02d", hr, min, sec);
    }
}
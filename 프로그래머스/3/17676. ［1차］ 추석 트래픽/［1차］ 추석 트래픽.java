class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(lines[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (jobs[j].start - jobs[i].end < 1000) cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}

class Job {
    int start;
    int end;

    public Job(String line) {
        int hr = Integer.parseInt(line.substring(11, 13));
        int min = Integer.parseInt(line.substring(14, 16));
        int sec = Integer.parseInt(line.substring(17, 19));
        int ms = Integer.parseInt(line.substring(20, 23));
        int duration = (int) (Double.parseDouble(line.substring(24, line.length() - 1)) * 1000);

        this.end = (hr * 3600 + min * 60 + sec) * 1000 + ms;
        this.start = this.end - duration + 1;
    }
}
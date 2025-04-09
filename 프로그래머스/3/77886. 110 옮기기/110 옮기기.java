class Solution {
    public String[] solution(String[] s) {

        for (int i = 0, n = s.length; i < n; i++) {
            s[i] = move110(s[i]);
        }
        return s;
    }

    public String move110(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c != '0') continue;
            int len = sb.length();
            if (len >= 3 && sb.substring(len - 3).equals("110")) {
                sb.delete(len - 3, len);
                cnt++;
            }
        }

        int idx = sb.lastIndexOf("0");
        sb.insert(idx + 1, "110".repeat(cnt));
        return sb.toString();
    }
}
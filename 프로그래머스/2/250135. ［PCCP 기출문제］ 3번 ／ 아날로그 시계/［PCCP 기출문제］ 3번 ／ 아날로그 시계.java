class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        double ds1 = h1 * 3600 + m1 * 60 + s1;
        double ds2 = h2 * 3600 + m2 * 60 + s2;
        
        int count = 0;
        count += (int) (ds2 / 360 / 120 * 719) 
            - (int) (ds1 / 360 / 120 * 719)
            + (ds1 == 0 || ds1 == 43200 ? 1 : 0);
        count += (int) (ds2 / 360 / 10 * 59) 
            - (int) (ds1 / 360 / 10 * 59)
            + (ds1 == 0 || ds1 == 43200 ? 1 : 0);
        if (ds1 <= 0 && ds2 >= 0) count--;
        if (ds1 <= 43200 && ds2 >= 43200) count--;
        
        return count;
    }
}
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ");
        int[] numbers = new int[ss.length];
        
        for (int i = 0; i < ss.length; i++) {
            numbers[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(numbers);
        
        return numbers[0] + " " + numbers[numbers.length-1];
    }
}
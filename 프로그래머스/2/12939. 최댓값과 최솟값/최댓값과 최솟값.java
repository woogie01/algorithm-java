import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] strArr = s.split(" ");
        int[] numArr = new int[strArr.length];
        
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(numArr);
        
        String min = String.valueOf(numArr[0]);
        String max = String.valueOf(numArr[numArr.length - 1]);
        String answer = min + " " + max;
        return answer;
    }
}
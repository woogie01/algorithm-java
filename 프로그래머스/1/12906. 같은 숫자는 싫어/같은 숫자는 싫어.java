import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        StringBuilder sb = new StringBuilder();
        int temp = -1;
        for (int num : arr) {
            if (num != temp) {
                sb.append(num);
            }
            temp = num;
        }
        int len = sb.length();
        
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = sb.charAt(i) - '0';
        }

        return answer;
    }
}
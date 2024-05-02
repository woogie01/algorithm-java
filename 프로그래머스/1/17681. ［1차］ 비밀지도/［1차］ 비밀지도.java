import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String binA = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binB = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int tmpA = binA.charAt(j) - '0';
                int tmpB = binB.charAt(j) - '0';
                
                if (tmpA == 1 || tmpB == 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();            
        }   
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String t, String p) {
        
        int tLen = t.length();
        int pLen = p.length();
        long pNum = Long.parseLong(p); 
        
        int answer = 0;
        for (int i = 0; i < tLen - pLen + 1; i++) {

            // substring(시작 인덱스, 제외 인덱스)
            Long tNum = Long.parseLong(t.substring(i, i + pLen));
            
            if (tNum <= pNum) {
                answer++;
            }
        }    
        return answer;
    }
}

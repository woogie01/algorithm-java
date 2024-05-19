import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[3];
        int idx = -1;
        
        char[] result = dartResult.toCharArray();
        for (int i = 0; i < result.length; i++){
           
            // 점수 확인
            if (isDigit(result[i])) {
               if (isDigit(result[i + 1])) {
                   scores[++idx] = 10;
                   i++;
               } else {
                   scores[++idx] = result[i] - '0';  
               }
            }
            
            // 보너스 및 옵션 확인
            switch(result[i]) {
                case 'D' :
                    scores[idx] = (int)Math.pow(scores[idx], 2);
                    break;
                case 'T' :
                    scores[idx] = (int)Math.pow(scores[idx], 3);
                    break;
                case '*' :
                    scores[idx] *= 2;
                    if (idx != 0) {
                        scores[idx - 1] *= 2;
                    }
                    break;
                case '#' :
                    scores[idx] *= -1;
                    break;
            }
        }
        
        for (int score : scores) {
            answer += score;
        }
        
        return answer;
    }
    
    public boolean isDigit(char ch) {
        
        int num = ch - '0';
        if (0 <= num && num <= 9) {
            return true;
        } 
        
        return false;
    }
}
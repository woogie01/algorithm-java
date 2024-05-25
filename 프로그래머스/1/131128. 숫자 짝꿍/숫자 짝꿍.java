import java.util.*;

class Solution {
    public String solution(String X, String Y) {
               
        // 각 digit 개수
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(String x : X.split("")){
            int num = Integer.parseInt(x);
            xArr[num]++;
        }
        for(String y : Y.split("")){
            int num = Integer.parseInt(y);
            yArr[num]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9 ; i >= 0 ; i--){
            
            while(xArr[i]-- > 0 && yArr[i]-- > 0){
                sb.append(i);
            }
        }
        
        String answer = sb.toString();
        if(answer.startsWith("0")){
            return "0";
        }
        if(answer.equals("")){
            return "-1";
        }
        
        return answer;
    }
}
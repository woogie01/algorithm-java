import java.util.*;

// 배열 활용
public String solution01(String X, String Y) {

    // <Digit, 개수>
    Map<Integer, Integer> xMap = new HashMap<>();
    Map<Integer, Integer> yMap = new HashMap<>();

    for (String str : X.split("")) {
        int num = Integer.parseInt(str);
        xMap.put(num, xMap.getOrDefault(num, 0) + 1);
    }
    for (String str : Y.split("")) {
        int num = Integer.parseInt(str);
        yMap.put(num, yMap.getOrDefault(num, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 9; i >= 0; i--) {
        if (xMap.containsKey(i) && yMap.containsKey(i)) {
            int cnt = Math.min(xMap.get(i), yMap.get(i));
            for (int j = 0; j < cnt; j++) {
                sb.append(i);
            }
        }
    }

    String answer = sb.toString();
    if (answer.startsWith("0")) {
        return "0";
    }
    if (answer.equals("")) {
        return "-1";
    }

    return answer;
}

// HashMap 활용
class Solution02 {
    public String solution(String X, String Y) {
               
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

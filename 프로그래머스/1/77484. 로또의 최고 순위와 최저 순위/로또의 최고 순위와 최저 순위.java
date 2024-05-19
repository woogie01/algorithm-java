import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0; // 모르는 번호 개수
        int match = 0; // 일치하는 번호 개수
        
        List<Integer> winList = new ArrayList<>();
        for (int num : win_nums) {
            winList.add(num);
        }
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            } 
            
            if (winList.contains(lotto)) {
                match++;
            }
        }
        
        int max = match + zero;
        int min = match;
        
        // 0도 없고 match도 없는 경우 고려
        answer[0] = max == 0 ? 6 : 7 - max;
        // match가 없는 경우 고려
        answer[1] = min == 0 ? 6 : 7 - match;
        
        return answer;
    }
}
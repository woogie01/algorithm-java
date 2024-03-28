import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> solution(int x, int n) {
        
        // 리스트 선언
        List<Long> answer = new ArrayList<Long>();
        
        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += x;
            answer.add(temp);
        }
        return answer;
    }
}
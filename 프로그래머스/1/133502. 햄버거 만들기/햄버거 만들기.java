import java.util.*;

class Solution {
    public int solution(int[] ingredients) {
        
        int answer = 0;
        Stack<Integer> flow = new Stack<>();
        for (int cur : ingredients) {
            
            flow.push(cur);
            
            if(flow.size() >= 4) {
                
                if (flow.get(flow.size() - 4) == 1
                        && flow.get(flow.size() - 3) == 2
                        && flow.get(flow.size() - 2) == 3
                        && flow.get(flow.size() - 1) == 1) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        flow.pop();
                    }
                }
            }
        }
        return answer;
    }
}
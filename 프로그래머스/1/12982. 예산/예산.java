import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        
        // 크기 순으로 정렬 -> 퀵소트보다 좋은 성능          
        Arrays.sort(d);
        
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            
            if (sum + d[i] <= budget) {
                sum += d[i];
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
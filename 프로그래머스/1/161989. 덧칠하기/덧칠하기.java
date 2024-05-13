class Solution {
    public int solution(int n, int m, int[] section) {
        
        int pin = section[0];
        int answer = 1;
        
        for (int cur : section) {
            
            if (pin + (m - 1) < cur) {
                answer++;
                pin = cur;
            }
        }
        return answer;
    }
}
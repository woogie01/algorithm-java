class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            
            int tmp = 0;
            for (int j = 1; j <= (int)i / j; j++) {
                
                if (j * j == i) {
                    tmp++;
                } else if (i % j == 0) {
                    tmp += 2;
                }
            }
            
            answer += tmp > limit ? power : tmp;
        }
        
        return answer;
    }
}
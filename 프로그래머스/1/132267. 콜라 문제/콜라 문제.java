class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;        
        
        int empty = n;
        do {
            // 보유한 빈 병으로 받을 수 있는 횟수
            int cnt = empty / a;
            answer += cnt * b;
            
            empty = empty % a + cnt * b;
        } while (empty >= a);
        
        return answer;
    }
}
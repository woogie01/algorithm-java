class Solution {
    public long[] solution(int x, int n) {
        
        // 배열 크기 먼저 지정
        long[] answer = new long[n];

        // 개별로 세팅
        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += x;
            answer[i] = temp;  
        }
        return answer;
    }
}

class Solution {
    public int solution(int n) {
        
        // 10진법 -> N진법  
        String trans = Integer.toString(n, 3);

        int answer = 0;
        for (int i = 0; i < trans.length(); i++) {
            int curr = trans.charAt(i) - '0';
            
            // 자동 캐스팅 불가
            int mul = (int) Math.pow(3, i);
            answer += curr * mul;
        }
        return answer;
    }
}
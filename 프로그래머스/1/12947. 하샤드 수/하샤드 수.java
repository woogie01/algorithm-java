class Solution {
    public boolean solution(int x) {
        
        boolean answer = true;
        
        // 문자열 처리
        String numbers = Integer.toString(x);
        
        int harshad = 0;
        
        // Java String은 Enhanced For 사용불가
        for (int i = 0; i < numbers.length(); i++) {
            int temp = numbers.charAt(i) - '0';
            harshad += temp;
        }
        
        if (x % harshad != 0) {
            answer = false;
        }
        return answer;
    }
}
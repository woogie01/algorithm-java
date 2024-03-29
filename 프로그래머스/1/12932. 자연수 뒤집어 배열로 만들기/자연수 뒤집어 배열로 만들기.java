class Solution {
    public int[] solution(long n) {
        
        // 문자열 변환
        String str = Long.toString(n);
        int strLen = str.length();
        int[] answer = new int[strLen];
        
        for (int i = 0 ; i < strLen; i++) {
            // Char -> Int
            int num = str.charAt(strLen -1 -i) - '0';
            answer[i] = num;
        }
        
        return answer;
    }
}
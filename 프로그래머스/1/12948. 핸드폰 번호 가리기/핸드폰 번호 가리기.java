class Solution {
    public String solution(String phone_number) {
        
        // 문자열 변경을 위해 StringBuilder 선언
        StringBuilder stringBuilder = new StringBuilder();
        int numberLen = phone_number.length();
        
        for (int i = 0; i < numberLen; i++) {
            stringBuilder.append(i < numberLen - 4 ? '*' : phone_number.charAt(i));
        }
        
        // 문자열로 변환
        String answer = stringBuilder.toString();
        return answer;
    }
}
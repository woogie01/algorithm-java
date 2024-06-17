class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                do {
                    if (ch < 'z') {
                        ch++;
                    } else {
                        ch = 'a';
                    }
                } while (skip.contains(String.valueOf(ch))); // 특정 값을 String 값으로 변경할 때 사용!!
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}

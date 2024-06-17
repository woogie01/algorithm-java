import java.util.*;

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
                } while (skip.contains(ch+""));
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
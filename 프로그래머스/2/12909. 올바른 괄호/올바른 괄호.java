import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> bracket = new Stack<>();
        char[] charArr = s.toCharArray();
        for (char ch : charArr) {
           if (ch == '(') {
               bracket.push(ch);
           } else {
               if (!bracket.isEmpty()) { 
                   bracket.pop();  
               } else { // 비어있는 경우 : 짝이 안맞는 경우
                   return false;
               }
           }
        }
        if (!bracket.isEmpty()) { // 마지막 예외처리
            return false;
        }
        return answer;
    }
}
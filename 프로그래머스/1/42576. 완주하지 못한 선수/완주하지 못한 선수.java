import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int len = completion.length;
        for (int i = 0; i < len; i++) {
            
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[len];
    }
}
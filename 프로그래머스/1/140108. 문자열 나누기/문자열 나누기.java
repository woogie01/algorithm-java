import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split("");
        
        List<String> same = new ArrayList<>();
        List<String> diff = new ArrayList<>();
        for (String ch : arr) {
            
            // 새로운 문자열인지 확인
            if (same.isEmpty()) {
                same.add(ch);
                continue;
            }
            
            if (same.contains(ch)) {
                same.add(ch);
            } else {
                diff.add(ch);
            }
            
            // 문자열 분리 조건
            if (same.size() == diff.size()) {
                answer++;
                same.clear();
                diff.clear();
            }
        }
        
        // 마지막에 쌍을 이뤘는지 확인
        if (!same.isEmpty()) {
            answer++;
        }
        
        return answer;
    }
}
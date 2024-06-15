import java.util.*;

class Solution {
    public int[] solution(String[] keyMaps, String[] targets) {
        
        int[] answer = new int[targets.length];
        Map<Character, Integer> minCnt = new HashMap<>(); 
        
        // 각 keyPad의 최소 입력값 구하기
        for (String keyMap : keyMaps) {
            for (int i = 0; i < keyMap.length(); i++) {
                char ch = keyMap.charAt(i);
                if (minCnt.containsKey(ch)) {
                    int idx = minCnt.get(ch);
                    int cnt = Math.min(idx, i + 1);
                    minCnt.put(ch, cnt);
                } else {
                    minCnt.put(ch, i + 1);
                } 
            }
        }
        
        // 결과 계산
        int idx = 0;
        for (String target : targets) {
            int cnt = 0;
            boolean exist = true;
            for (char ch : target.toCharArray()) {
                if (minCnt.containsKey(ch)) {
                    cnt += minCnt.get(ch);
                } else {
                    exist = false;
                    break;
                }
            } 
            answer[idx++] = exist == true ? cnt : -1;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 스테이지에 잔류 중인 플레이어
        int[] cur = new int[N + 1];
        // 스테이지에 도달한 모든 플레이어
        int[] reach = new int[N + 1];
        
        for (int stage : stages) {
            cur[stage - 1]++;
            for (int i = 0; i < stage; i++) {
                reach[i]++;
            }
        }
        
        Map<Integer, Double> fail = new HashMap<>();
        for (int i = 0; i < N; i++) {
            
            if (cur[i] == 0 || reach[i] == 0) {
                fail.put(i + 1, 0.0);
            } else {
                fail.put(i + 1, (double)cur[i] / reach[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(fail.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(fail.get(o2), fail.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
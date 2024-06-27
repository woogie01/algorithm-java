import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        // Giver가 각 Receiver들에게 몇개의 선물을 주었는지 기록
        Map<String, Map<String, Integer>> recordMap = new HashMap<>(); 
        // 각 친구들의 선물 지수
        Map<String, Integer> scoreMap = new HashMap<>();
        // 각 친구들의 다음 달에 받을 선물 수
        Map<String, Integer> giftMap = new HashMap<>();
        
        // 해시맵 초기화
        for (String friend : friends) {
            recordMap.put(friend, new HashMap<>());
            scoreMap.put(friend, 0);
            giftMap.put(friend, 0);
        }
        
        for (String gift : gifts) {
            String[] giveAndReceive = gift.split(" ");
            String giver = giveAndReceive[0];
            String receiver = giveAndReceive[1];
            
            // Giver가 해당 Receciver에게 준 횟수
            int cnt = recordMap.get(giver).getOrDefault(receiver, 0) + 1;
            // Giver의 선물 지수
            int giverScore = scoreMap.get(giver) + 1;
            // Receiver 선물 지수
            int receiverScore = scoreMap.get(receiver) - 1;
            
            recordMap.get(giver).put(receiver, cnt);
            scoreMap.put(giver, giverScore);
            scoreMap.put(receiver, receiverScore);
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String friendA = friends[i];
                String friendB = friends[j];
                int recordA = recordMap.get(friendA).getOrDefault(friendB, 0);
                int recordB = recordMap.get(friendB).getOrDefault(friendA, 0);
                
                if (recordA > recordB) {
                    giftMap.put(friendA, giftMap.get(friendA) + 1);
                } else if (recordA == recordB) {
                    if (scoreMap.get(friendA) > scoreMap.get(friendB)) {
                        giftMap.put(friendA, giftMap.get(friendA) + 1);
                    } else if (scoreMap.get(friendA) < scoreMap.get(friendB)) {
                        giftMap.put(friendB, giftMap.get(friendB) + 1);
                    }
                } else {
                    giftMap.put(friendB, giftMap.get(friendB) + 1);
                }
            }
        }
        
        return Collections.max(giftMap.values());
    }
}
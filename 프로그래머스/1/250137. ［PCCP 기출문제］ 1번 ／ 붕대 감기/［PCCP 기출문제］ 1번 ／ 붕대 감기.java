import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        Map<Integer, Integer> attackMap = new HashMap<>();
        int endTime = attacks[attacks.length - 1][0];
        int curHealth = health;
        int successTime = 0;
        
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
        }
        
        for (int i = 1; i <= endTime; i++) {
            if (attackMap.containsKey(i)) { // 공격 O
                curHealth -= attackMap.get(i);
                successTime = 0;
            } else { // 공격 X
                curHealth += bandage[1];
                successTime++;
                
                if (successTime == bandage[0]) { // 추가회복 예외처리
                    curHealth += bandage[2];
                    successTime = 0;
                }
                if (curHealth > health) { // 최대체력 예외처리
                    curHealth = health;
                }
            }
            if (curHealth <= 0) { // 체력이 없는 경우 예외처리
                return -1;
            }
        }
        return curHealth;
    }
}
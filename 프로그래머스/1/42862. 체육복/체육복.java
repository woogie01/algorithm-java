import java.util.*;

class Solution {
    public int solution(int n, int[] lostArr, int[] reserveArr) {
        
        int answer = n - lostArr.length;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int num : reserveArr) {
            reserveSet.add(num);
        }
        
        // 여벌 체육복을 가져온 학생 중 도난 당하는 경우 예외 처리
        for (int num : lostArr) {
            if (reserveSet.contains(num)) {
                reserveSet.remove(num);
                answer++;
            } else {
                lostSet.add(num);
            }
        }
        
        // 빌릴 수 있는 있는 경우 계산
        for (Integer num : lostSet) {
            if (reserveSet.contains(num - 1)) {
                reserveSet.remove(num - 1);
                answer++;
            } else if (reserveSet.contains(num + 1)) {
                reserveSet.remove(num + 1);
                answer++;
            }
        }
        
        return answer;
    }
}
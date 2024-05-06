import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int hap = numbers[i] + numbers[j];
                
                if (!answer.contains(hap)) {
                    answer.add(hap);
                }
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}
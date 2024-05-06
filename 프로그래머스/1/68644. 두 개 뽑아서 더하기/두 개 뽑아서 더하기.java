import java.util.*;

class Solution {
    public Set<Integer> solution(int[] numbers) {
        Set<Integer> answer = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int hap = numbers[i] + numbers[j];
                answer.add(hap);
            }
        }
        
        return answer;
    }
}
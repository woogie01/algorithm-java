import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> haps = new TreeSet();

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                haps.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[haps.size()];
        int index = 0;
        Iterator itor = haps.iterator();
        while(itor.hasNext()){
            answer[index++] = (int)itor.next();
        }

        return answer;
    }
}
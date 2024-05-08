import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> number = new HashSet<>();
        for (int num : nums) {
            number.add(num);
        }
        
        int size1 = number.size();
        int size2 = nums.length / 2;
        
        return size1 < size2 ? size1 : size2;
    }
}
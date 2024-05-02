import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        
        int first = 0;
        int second = 0;
        for (int[] arr : sizes) {
            Arrays.sort(arr);
            
            if (arr[0] > first) {
                first = arr[0];
            } else if (arr[0] > second) {
                second = arr[0];
            } 
            
            if (arr[1] > second) {
                second = arr[1];
            }
        }
        
        int answer = first * second;
        return answer;
    }
}
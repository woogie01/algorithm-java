import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        
        int first = 0;
        int second = 0;
        for (int[] arr : sizes) {
            Arrays.sort(arr);

            // 큰 값끼리 비교
            if (arr[1] > first) {
                first = arr[1];
            }

            // 작은 값끼리 비교
            if (arr[0] > second) {
                second = arr[0];
            } 
        }
        
        int answer = first * second;
        return answer;
    }
}

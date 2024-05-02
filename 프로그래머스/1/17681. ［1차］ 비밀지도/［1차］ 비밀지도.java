class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        int[] binary = new int[n];
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            binary[i] = arr1[i] | arr2[i];
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int remainder = binary[i];
            
            for (int j = 0; j < n; j++) {
                if ((remainder & 1) == 1) {
                    sb.insert(0, '#');
                } else {
                    sb.insert(0, " ");
                }
                remainder >>= 1;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
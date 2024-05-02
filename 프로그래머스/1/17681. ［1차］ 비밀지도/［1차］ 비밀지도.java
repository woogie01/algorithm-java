class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        int[] binary = new int[n];
        String[] answer = new String[n];

        // 비트 연산자 이용해서 각 비트 비교
        for (int i = 0; i < n; i++) {
            binary[i] = arr1[i] | arr2[i];
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int remainder = binary[i];
            
            for (int j = 0; j < n; j++) {
                if ((remainder & 1) == 1) {
                    // StringBuilder - insert : 지정 위치에 집어넣기
                    sb.insert(0, '#');
                } else {
                    sb.insert(0, " ");
                }

                // 오른쪽 비트로 이동
                remainder >>= 1;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}

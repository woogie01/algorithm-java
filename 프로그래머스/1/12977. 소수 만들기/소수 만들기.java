class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    
                    boolean check = true;
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int cur = 2; cur <= (int)sum / cur; cur++) {
                        
                        if (sum % cur == 0)
                            check = false;
                    }
                    
                    if (check) 
                        answer++;
                }
            }
        }
        
        return answer;
    }
}
class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = food.length - 1; i >= 0; i--) {
            
            int cnt = food[i] / 2;
            
            if (cnt > 0) {
                String str = Integer.toString(i);
                for (int j = 0; j < cnt; j++) {
                    sb.insert(0, str);
                    sb.reverse().insert(0, str);
                }
            }    
        }
        
        String answer = sb.toString();    
        
        return answer;
    }
}
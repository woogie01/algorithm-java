class Solution {
    public int solution(String[] babbling) {
       
        String[] valids = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String cur : babbling) {
            
            for (String valid : valids) {
                
                // 같은 발음 연속으로 불가
                if (cur.contains(valid + valid)) {
                    continue;
                }
                
                // 발음 하나씩 제거
                cur = cur.replace(valid, "-");
            }
            cur = cur.replace("-", "");
            
            if (cur.length() == 0) {
                answer++;
            }    
        }
        return answer;
    }
}
class Solution01 {
    public int solution(int[] ingredient) {
        
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int cur : ingredient) {
            stack[sp++] = cur;
            if (sp >= 4 
                    && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}

class Solution02 {
    public int solution(int[] ingredients) {
        
        int answer = 0;
        Stack<Integer> flow = new Stack<>();
        for (int cur : ingredients) {
            
            flow.push(cur);    
            if (flow.size() >= 4 
                    && flow.get(flow.size() - 4) == 1
                    && flow.get(flow.size() - 3) == 2
                    && flow.get(flow.size() - 2) == 3
                    && flow.get(flow.size() - 1) == 1) {
                answer++;
                for (int i = 0; i < 4; i++) {
                    flow.pop();
                }
            }  
        }
        return answer;
    }
}

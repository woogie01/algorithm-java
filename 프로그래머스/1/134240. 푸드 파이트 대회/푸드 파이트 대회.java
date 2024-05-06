import java.util.Stack;

class Solution {
    public String solution(int[] food) {
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        // 앞의 부분 추가
        for (int i = 1; i < food.length; i++) {
            
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j++) {
                sb.append(i);
                stack.push(i);
            }
        }
        
        // 가운데 부분 : 0 추가
        sb.append(0);
        
        // 마지막 부분 추가
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}
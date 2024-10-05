import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        boolean isPossible = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = numArr[i];
            if (input >= cur) {
                while (input >= cur) {
                    stack.push(cur++);
                    sb.append("+\n");
                }
                stack.pop(); // 출력 가능한 지점
                sb.append("-\n");
            } else {
                int top = stack.pop();
                if (top > input) { // 각 숫자는 하나씩만 들어온다.
                    System.out.println("NO");
                    isPossible = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (isPossible) {
            System.out.println(sb.toString());
        }
    }
}
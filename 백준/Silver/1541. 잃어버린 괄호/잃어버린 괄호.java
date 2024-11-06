import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 5주차 개념 : 그리디 알고리즘
     * 백준 1541
     *
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] formula = br.readLine().split("-"); // - 기준으로 분리

        int answer = 0;
        for (int i = 0; i < formula.length; i++) {
            int sum = adder(formula[i]);
            if (i == 0) { // 공식은 숫자로 시작하기 때문에, 첫 번째 수는 덧셈 연산
                answer += sum;
            } else {
                answer -= sum;
            }
        }

        // 출력
        System.out.println(answer);
    }

    private static int adder(String str) {
        int sum = 0;
        String[] adds = str.split("\\+"); // + 기준으로 분리
        for (String add : adds) {
            sum += Integer.parseInt(add);
        }
        return sum;
    }
}

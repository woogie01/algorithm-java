import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 변수 초기화
        int answer = 1;
        int sum = 1;
        int start = 1;
        int end = 1;

        while (end < N) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum == N) {
                answer++;
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        System.out.println(answer);
    }
}
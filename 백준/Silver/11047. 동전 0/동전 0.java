import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 5주차 개념 : 그리디 알고리즘
     * 백준 11047
     *
     */

    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws IOException {

        // 변수 선언 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열에 역순으로 대입
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[N - 1 - i] = Integer.parseInt(br.readLine());
        }

        // 출력
        System.out.println(greedy());
    }

    private static int greedy() {
        int value = K;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int coin = coins[i];
            while (coin <= value) {
                value -= coin;
                count++;
            }
            if (value == 0) {
                break;
            }
        }
        return count;
    }
}
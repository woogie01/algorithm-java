import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 5주차 개념 : 정수론 - 오일러피 개념
     * 백준 11689
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(eulerPhi(N));
    }

    private static long eulerPhi(long n) {
        long result = n;
        for (long p = 2; p <= n / p; p++) {
            if (n % p == 0) {
                // 소인수 p에 대해 n에서 p의 배수를 제거
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        // 마지막 소인수에 대해 처리
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}

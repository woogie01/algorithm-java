import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 5주차 개념 : 유클리드 호제법
     * 백준 1850
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        long gcdLength = gcd(A, B);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < gcdLength; i++) {
            result.append("1");
        }

        // 출력
        System.out.println(result.toString());
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
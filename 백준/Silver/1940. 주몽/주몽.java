import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        int answer = 0;
        int start = 0;
        int end = N - 1;

        while (start < end) {
            if (numArr[start] + numArr[end] < M) {
                start++;
            } else if (numArr[start] + numArr[end] == M) {
                answer++;
                start++;
                end--;
            } else {
                end--;
            }
        }
        System.out.println(answer);
    }
}
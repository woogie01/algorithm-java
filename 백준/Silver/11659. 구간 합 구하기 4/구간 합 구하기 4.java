import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 2주차 개념 : 구간 합
     * 백준 11659
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int numCnt = Integer.parseInt(stringTokenizer.nextToken());
        int repeatCnt = Integer.parseInt(stringTokenizer.nextToken());

        long[] sumArr = new long[numCnt + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= numCnt; i++) {
            sumArr[i] = sumArr[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int R = 0; R < repeatCnt; R++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            long answer = sumArr[j] - sumArr[i - 1];
            System.out.println(answer);
        }
    }
}
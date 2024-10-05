package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz03_11659 {

    /**
     * 2주차 개념 : 구간 합
     * 백준 11659
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // N, M 입력 받기
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // N 개의 숫자 입력 받으면서 합 배열 생성
        long[] sumArr = new long[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // M 개의 구간 합 계산하기
        for (int k = 0; k < M; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            long answer = sumArr[j] - sumArr[i - 1];
            System.out.println(answer);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 2주차 개념 : 버블 정렬
     * 백준 2750
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        for (int i = 0; i < N; i++) { // 배열에 값 넣어주기
            numArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) { // 정렬 시작
            for (int j = 0; j < N - 1 - i; j++) {
                if (numArr[j] > numArr[j + 1]) {
                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = tmp;
                }
            }
        }

        for (int num : numArr) {
            System.out.println(num);
        }
    }
}

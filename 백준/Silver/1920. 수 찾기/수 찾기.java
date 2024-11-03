import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    /**
     * 4주차 개념 : 이진탐색
     * 백준 1920
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 배열 선언 및 초기화 + 정렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean isExist = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int median = arr[mid];
                if (median > target) {
                    end = mid - 1;
                } else if (median < target) {
                    start = mid + 1;
                } else {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

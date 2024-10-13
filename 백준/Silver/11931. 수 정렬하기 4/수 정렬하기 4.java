import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 3주차 개념 : 합병 정렬
     * 백준 11931
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        mergeSort(arr, 0, N - 1);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left  < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);             // 왼쪽 정렬
            mergeSort(arr, mid + 1, right);  // 오른쪽 정렬
            merge(arr, left, mid, right);          // 배열 합치기
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int low = left;     // 왼쪽 배열의 시작 인덱스
        int high = mid + 1; // 오른쪽 배열의 시작 인덱스
        int idx = 0;        // 임시 배열 인덱스

        while (low <= mid && high <= right) { // 두 배열의 요소들을 비교하여 내림차순으로 임시 배열에 삽입
            if (arr[low] >= arr[high]) {
                temp[idx++] = arr[low++];
            } else {
                temp[idx++] = arr[high++];
            }
        }

        while (low <= mid) { // 왼쪽 배열에 남은 요소들을 임시 배열에 복사
            temp[idx++] = arr[low++];
        }

        while (high <= right) { // 오른쪽 배열에 남은 요소들을 임시 배열에 복사
            temp[idx++] = arr[high++];
        }

        for (int i = 0; i < temp.length; i++) { // 정렬된 임시 배열을 원본 배열에 복사
            arr[left + i] = temp[i];
        }
    }
}


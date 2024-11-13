import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 6주차 개념 : 위상 정렬
     * 백준 2252
     * 1 3 = 1 -> 3
     * 2 3 = 2 -> 3
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        int[] count = new int[N + 1];  // 진입 차수 배열
        ArrayList<Integer>[] students = new ArrayList[N + 1]; // 학생 관계 인접리스트
        for (int i = 1; i <= N; i++) {
            students[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            students[start].add(end);
            count[end]++; // 진입 차수 증가
        }

        // 위상 정렬
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) { // 순번이 가장 빠른 학생들 먼저 큐에 넣어주기
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int student : students[cur]) {
                count[student]--; // 진입 차수 감소
                if (count[student] == 0) {
                    queue.offer(student);
                }
            }
        }
    }
}
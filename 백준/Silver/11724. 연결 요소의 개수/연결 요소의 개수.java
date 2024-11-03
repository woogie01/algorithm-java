import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /**
     * 4주차 개념 : DFS
     * 백준 11724
     * requirement : 방문 노드를 체크하는 배열, 그래프를 표현하는 인접 리스트
     */

    static ArrayList<Integer>[] connection;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        connection = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) { // 인접 리스트 선언
            connection[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) { // 인접 리스트 초기화
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 노드의 연결 간에 방향이 없기에 양방향 가능
            connection[start].add(end);
            connection[end].add(start);
        }

        // 각 노드 방문 체크하는 배열
        visited = new boolean[N + 1];

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int node) {

        // 종료 조건
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int cur : connection[node]) {
            if (!visited[cur]) {
                DFS(cur);
            }
        }
    }
}

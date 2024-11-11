import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /**
     * 5주차 개념 : 그래프 개념
     * 백준 1707
     *
     */

    static boolean isPossible;
    static int[] group;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 K

        String[] answers = new String[K];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수 V
            int E = Integer.parseInt(st.nextToken()); // 간선 개수 E

            // 그래프 초기화 작업
            graph = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            // 뵨수 및 배열 초기화 작업
            visited = new boolean[V + 1];
            group = new int[V + 1];
            isPossible = true;

            // 간선 데이터 저장
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            // 각 정점에서 사이클 발생하는지 확인
            for (int j = 1; j <= V; j++) {
                if (isPossible) {
                    findCycle(j);
                } else {
                    break;
                }
            }

            if (isPossible) {
                answers[i] = "YES";
            } else {
                answers[i] = "NO";
            }
        }

        // 출력
        for (String answer : answers) {
            System.out.println(answer);
        }

    }

    private static void findCycle(int start) {
        visited[start] = true;
        for (int node : graph[start]) {
            if (!visited[node]) {
                // 서로 다른 집합임을 표시 : 0 또는 1로 서로 토글
                group[node] = (group[start] + 1) % 2;
                findCycle(node);
            } else {
                // 서로 같은 집합인지 체크
                if (group[start] == group[node]) {
                    isPossible = false;
                }
            }
        }
    }
}

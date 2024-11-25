import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /**
     * 7주차 개념 : 플로이드-워셜 알고리즘
     * 백준 1956
     */

    static final int INF = Integer.MAX_VALUE;

    static int V, E;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점
        E = Integer.parseInt(st.nextToken()); // 간선
        dist = new int[V + 1][V + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dist[i][j] = INF;
            }
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            dist[start][end] = distance; 
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dist[i][i]);
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}
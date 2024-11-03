import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 4주차 개념 : BFS
     * 백준 2178
     * requirement : 방문 노드를 체크하는 배열, 그래프를 표현하는 인접 리스트
     */

    // 시계 방향 회전 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;
    static boolean[][] visited;
    static int[][] connection;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        connection = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                connection[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(connection[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) { // 시계방향으로 인접 노드 탐색
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) { // 배열 범위 체크
                    if (connection[x][y] != 0 && !visited[x][y]) { // 유효 노드 및 방문 여부 체크
                        visited[x][y] = true;
                        connection[x][y] = connection[cur[0]][cur[1]] + 1; // 그래프에 depth 값 반영
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}

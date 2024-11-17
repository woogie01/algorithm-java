import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /**
     * 6주차 개념 : 다익스트라 알고리즘
     * 백준 1753 - 우선순위 큐 활용
     */

    static final int INF = Integer.MAX_VALUE;

    static int V, E, K;
    static int[] distances;
    static ArrayList<Node>[] graph;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 선언 및 초기화
        V = Integer.parseInt(st.nextToken()); // 정점 개수 V
        E = Integer.parseInt(st.nextToken()); // 간선 개수 E
        K = Integer.parseInt(br.readLine());  // 시작 노드 K

        visited = new boolean[V + 1];
        distances = new int[V + 1];
        graph = new ArrayList[V + 1];

        // 최소 거리 배열 및 그래프 생성
        for (int i = 1; i <= V; i++) {
            distances[i] = INF;
            graph[i] = new ArrayList<>();
        }

        // 정점 개수 E 만큼 반복해서 연결 정보 초기화
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, distance));
        }

        // 다익스트라 실행
        dijkstra();

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            System.out.println(distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]);
        }
    }

    private static void dijkstra() {
        distances[K] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNode = cur.end;
            int curDistance = cur.distance;

            if (curDistance > distances[curNode]) {
                continue;
            }

            for (Node node : graph[curNode]) {
                int newNode = node.end;
                int newDistance = curDistance + node.distance;

                if (newDistance < distances[newNode]) {
                    distances[newNode] = newDistance;
                    queue.add(new Node(newNode, newDistance));
                }
            }
        }
    }
}
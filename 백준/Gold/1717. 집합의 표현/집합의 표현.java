import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 6주차 개념 : 유니온 파인드
     * 백준 1717
     */

    static int[] roots; // 각 노드의 시작점인 대표 노드 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 대표 노드 초기화 작업
        roots = new int[N + 1];
        for (int j = 0; j < N + 1; j++) {
            roots[j] = j;
        }

        // 연산 개수 M 만큼 반복
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int setA = Integer.parseInt(st.nextToken());
            int setB = Integer.parseInt(st.nextToken());
            unionFind(op, setA, setB);
        }
    }

    private static void unionFind(int op, int setA, int setB) {
        if (op == 0) {
            union(setA, setB);
        } else {
            if (find(setA) == find(setB)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // 대표 노드 검색 : 경로 압축을 적용
    private static int find(int x) {
        if (x == roots[x]) {
            return x;
        } else {
            return roots[x] = find(roots[x]);
        }
    }

    private static void union(int a, int b) {

        // 합치기 전에 각 대표 노드 찾기
        int rootA = find(a);
        int rootB = find(b);

        // 대표 노드 지정
        if (rootA != rootB) {
            roots[rootB] = rootA;
        }
    }
}
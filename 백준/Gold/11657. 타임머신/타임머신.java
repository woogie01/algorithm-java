import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class City {
        int end;
        long distance;

        public City(int end, long distance) {
            this.end = end;
            this.distance = distance;
        }
    }

    static final int INF = Integer.MAX_VALUE;

    static int N, M;
    static long[] distances;
    static ArrayList<City>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distances = new long[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            distances[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());
            graph[start].add(new City(end, distance));
        }

        boolean hasNegativeCycle = BellmanFord();

        if (hasNegativeCycle) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                bw.write((distances[i] == INF ? -1 : distances[i]) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean BellmanFord() {
        distances[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                for (City city : graph[j]) {
                    if (distances[j] != INF && distances[city.end] > distances[j] + city.distance) {
                        distances[city.end] = distances[j] + city.distance;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (City city : graph[i]) {
                if (distances[i] != INF && distances[city.end] > distances[i] + city.distance) {
                    return true;
                }
            }
        }

        return false;
    }
}

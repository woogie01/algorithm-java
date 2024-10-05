import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 2주차 개념 : 투 포인터 & 슬라이딩
     * 백준 12891
     *
     */

    static int[] ruleArr = new int[4];
    static int[] curArr = new int[4];
    static char[] dnaArr; // 입력받은 DNA 문자열
    static int check = 0; // [A, C, G, T] 중 최소 개수를 만족하는 문자 개수
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        dnaArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ruleArr[i] = Integer.parseInt(st.nextToken());
            if (ruleArr[i] == 0) {
                check++;
            }
        }

        // DNA 문자열 앞에서부터 차례로 넣어보기
        for (int i = 0; i < P; i++) {
            add(dnaArr[i]);
        }
        check();

        // 슬라이드 시작
        for (int end = P; end < S; end++) {
            int start = end - P;
            add(dnaArr[end]);
            sub(dnaArr[start]);
            check();
        }
        System.out.println(answer);
        br.close();
    }

    private static void add(char ch) {
        switch (ch) {
            case 'A':
                curArr[0]++;
                if (curArr[0] == ruleArr[0])
                    check++;
                break;
            case 'C':
                curArr[1]++;
                if (curArr[1] == ruleArr[1])
                    check++;
                break;
            case 'G':
                curArr[2]++;
                if (curArr[2] == ruleArr[2])
                    check++;
                break;
            case 'T':
                curArr[3]++;
                if (curArr[3] == ruleArr[3])
                    check++;
                break;
        }
    }

    private static void sub(char ch) {
        switch (ch) {
            case 'A':
                if (curArr[0] == ruleArr[0])
                    check--;
                curArr[0]--;
                break;
            case 'C':
                if (curArr[1] == ruleArr[1])
                    check--;
                curArr[1]--;
                break;
            case 'G':
                if (curArr[2] == ruleArr[2])
                    check--;
                curArr[2]--;
                break;
            case 'T':
                if (curArr[3] == ruleArr[3])
                    check--;
                curArr[3]--;
                break;
        }
    }

    private static void check() {
        if (check == 4) {
            answer++;
        }
    }
}
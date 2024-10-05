import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 2주차 개념 : 선택 정렬
     * 백준 1427
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charNum = br.readLine().toCharArray();
        int[] numArr = new int[charNum.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = charNum[i] - '0';
        }

        for (int i = 0; i < numArr.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[maxIndex] < numArr[j]) {
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                int tmp = numArr[i];
                numArr[i] = numArr[maxIndex];
                numArr[maxIndex] = tmp;
            }
        }
        for (int num : numArr) {
            System.out.print(num);
        }
    }
}

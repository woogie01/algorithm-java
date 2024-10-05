import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String str = sc.next();
        char[] numArr = str.toCharArray();

        int answer = 0;
        for (char c : numArr) {
            answer += c - '0';
        }
        System.out.println(answer);
    }
}
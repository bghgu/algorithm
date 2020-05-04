package beakjoon;

import java.util.Scanner;

/**
 * Created by ccoli on 2020/03/21.
 */

public class Main_9020 {

    private final static Scanner sc = new Scanner(System.in);
    private final static StringBuilder sb = new StringBuilder();
    private final static int MAX = 10001;

    private static int min = Integer.MAX_VALUE;
    private static int[] prime = new int[MAX];

    public static void main(String... args) {
        getPrime();

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            min = Integer.MAX_VALUE;

            int a = 0;
            int b = 0;

            for (int i = 2; i < n; i++) {
                int temp = n - i;
                if (prime[i] != 0 && prime[temp] != 0 && min > Math.abs(i - temp)) {
                    min = Math.abs(i - temp);
                    a = i;
                    b = temp;
                    if (i > temp) {
                        a = temp;
                        b = i;
                    }
                }
            }
            sb.append(a).append(" ").append(b).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void getPrime() {
        for (int i = 1; i < MAX; i++) {
            prime[i] = i;
        }

        for (int i = 2; i < MAX; i++) {
            if (prime[i] == 0) {
                continue;
            }
            for (int j = i + i; j < MAX; j += i) {
                prime[j] = 0;
            }
        }
    }

    /**
     * 1보다 큰 자연수 중에서 1과 자기 자신을 제외한 약수가 없는 자연수를 소수
     * 5는 1과 5를 제외한 약수가 없기 때문에 소수이다.
     * 6 = 2 * 3
     * 골드 바흐의 추측은 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다
     * 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
     * 4 = 2 + 2
     * 6 = 3 + 3
     * 8 = 3 + 5
     * 10 = 5 + 5
     * 12 = 5 + 7
     * 14 = 3 + 11
     * 14 = 7 + 7
     * 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
     * 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력
     */
}
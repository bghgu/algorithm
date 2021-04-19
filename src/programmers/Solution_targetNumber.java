package programmers;

/**
 * Created by ds on 2021/04/17
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */

public class Solution_targetNumber {

    public static void main(String... args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution(arr, 3));
    }

    private static boolean[] visit;
    private static int[] arr;
    private static int n;
    private static int result;

    public static int solution(int[] numbers, int target) {
        n = numbers.length;
        visit = new boolean[n];
        arr = numbers;
        result = 0;

        func(0, target);

        return result;
    }

    private static void func(final int x, final int target) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                temp += arr[i];
            } else {
                temp -= arr[i];
            }
        }
        if (temp == target) {
            result++;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                func(x + 1, target);
                visit[i] = false;
            } else {
                break;
            }
        }
    }

    /**
     * n개의 음이 아닌 정수가 있습니다.
     *
     * 이 수를 적절히 더하거나 빼서 타켓 넘버를 만들려고 합니다.
     *
     * 예를 들어 1, 1, 1, 1, 1 로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
     *
     * 사용할 수 있는 숫자가 담긴 배열 numbers,
     * 타켓 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 반환.
     *
     * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
     *
     * 각 숫자는 1 이상 50 이하의 자연수 입니다.
     *
     * 타겟 넘버는 1 이상 1000 이하인 자연수 입니다.
     */
}
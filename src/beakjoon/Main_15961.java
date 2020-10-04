package beakjoon;

import java.io.*;
import java.util.*;

/**
 * Created by ccoli on 2020/08/28.
 */

public class Main_15961 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String... args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] check = new int[d + 1];

        check[coupon]++;
        int count = 1;

        for (int i = 0; i < k; i++) {
            if (check[arr[i]] == 0) {
                count++;
            }
            check[arr[i]]++;
        }

        int max = count;

        for (int i = k; i < n + k; i++) {
            int start = i - k;
            int end = i % n;

            --check[arr[start]];
            if (check[arr[start]] == 0) {
                count--;
            }

            if (check[arr[end]] == 0) {
                count++;
            }
            check[arr[end]]++;

            if (count > max) {
                max = count;
            }
        }

        bw.write(max + "");
        bw.close();
        br.close();
    }

    /**
     * 회전 초밥
     * 회전 초밥 음식점에는 회전하는 벨트 위에 여러 가지 종류의 초밥이 접시에 담겨 놓여 있고, 손님은 이 중에서 자기가 좋아하는 초밥을 골라서 먹는다.
     * 초밥의 정류를 번호로 표현할 때, 다음 그림은 회전 초밥 음식점의 벨트 상태의 예를 보여주고 있다.
     *
     * 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다.
     *
     * 새로 문을 연 회전 초밥 음식점이 불경기로 영업이 어려워서, 다음과 같이 두 가지 행사를 통해서 매상을 올리고자 한다.
     *
     * 1. 원래 회전 초밥은 손님이 마음대로 초밥을 고르고, 먹은 초밥만큼 식대를 계산하지만,
     * 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다.
     * 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공한다.
     * 만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공한다.
     *
     * 위 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 한다.
     * k = 4이고 30번 초밥을 쿠폰으로 받았을 경우
     * 쿠폰을 고려하지 않으면 4가지 다른 초밥을 먹을 수 있는 경우는 9, 7, 30, 2 / 30, 2, 7, 9 / 2, 7, 9. 25 세가지이다.
     * 30번 초밥을 추가로 쿠폰으로 먹을 수 있으므로 2, 7, 9, 25 를 고르면 5가지 종류의 초밥을 먹을 수 있다.
     *
     * 회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호가 주어졌을 때, 손님이 먹을 수 있는 초밥 가짓수의 최대값
     *
     * 2 <= N <= 3,000,000
     * 2 <= d <= 3,000
     * 2 <= k <= 3,000
     * k <= N
     * 1 <= c <= d
     */
}
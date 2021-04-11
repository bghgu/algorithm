package beakjoon;

/**
 * Created by ds on 2021/03/20.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class Main2 {

    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        boolean result = false;

        LocalTime startTime = null;
        LocalTime endTime = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken(); // 앞 시간
            String t = st.nextToken(); // ~
            String r = st.nextToken(); // 뒤 시간
            String[] w = s.split(":");
            String[] p = r.split(":");
            LocalTime localTime1 = LocalTime.of(Integer.parseInt(w[0]), Integer.parseInt(w[1]));
            LocalTime localTime2 = LocalTime.of(Integer.parseInt(p[0]), Integer.parseInt(p[1]));

            if (startTime == null && endTime == null) {
                startTime = localTime1;
                endTime = localTime2;
            } else {
                if (startTime.isAfter(localTime2) || endTime.isBefore(localTime1)) {
                    result = false;
                } else {
                    result = true;
                    if (startTime.compareTo(localTime1) < 0) {
                        startTime = localTime1;
                    }

                    if (endTime.compareTo(localTime2) >= 0) {
                        endTime = localTime2;
                    }
                }
            }

        } // 입력 끝나기

        if (result) {
            if (startTime.toString().equals(endTime.toString())) {
                System.out.print(-1);
            }else {
                System.out.print(startTime.toString() + " ~ " + endTime.toString());
            }
        } else {
            System.out.print(-1);
        }
    }

}

/*
 * 대여 시간을 추천해드립니다
 *
 * 쏘카에서는 여행 시즌을 맞이하여 대여 추천 기능을 제공하고자 한다. 대여 추천 기능은 자가용을 이용하려는 인원 수와 함께 각자 쏘카 존에
 * 도착할 수 있는 시간 구간을 입력하면, 모든 인원이 쏘카존에 올 수 있는 시간 구간을 알아낸 뒤 그 시간에 빌릴 수 있는 자가용을
 * 추천해주는 기능이다.
 *
 * 쏘카의 개발자인 성민이는 먼저 자가용을 이용하려는 인원 모두가 쏘가존에 올 수 있는 시간을 알아내려 한다 예를 들어 이용 인원이 총
 * 3명이며, 각자 가능한 시간이 아래와같이 입력되었다고 가정하자
 *
 * 12: 00 - 23:59 11: 00 - 18:00 14:00 - 20:00
 *
 * 위와 같은 경우 모두가 쏘카존에 올 수 있는 시간이 14:00 - 18:00 이니 이때 탈 수 있는 자가용을 추천해주면 된다 이렇게
 * 자가용을 이용하려는 총 인원 수와 각자 쏘카존에 올 수 있는 시간 구간이 주어졌을떄, 모든 인원이 쏘카존에 올 수 있는 시간을 구해보자
 * 만약에 모두가 만날 수 있는 시간이 없을 경우에는 "-1"를 출력한다.
 *
 * 입력: 첫 줄에 자가용을 이용하려는 총 인원 수를 의미하는 자연수 N이 주어진다 . 두 번쨰 줄부터 총 N줄에 걸쳐 자가용을 이용 인원이
 * 각자 쏘카존에 올 수 있는 시간 구간이 주어진다. 시간 구간은 HH: MM ~ HH:MM 형태로 주어지며 00 이상 23 이하의 시간을
 * 의미하는 정수가, MM은 00 이상 59 이하의 분을 의미하는 정수가 주어진다. 구간의 값은 무조건 앞의 값이 시간 상으로 더 작은 시간
 * 모든 시간은 동일한 날의 시간이므로 시간순으로 자정을 넘기는 일정은 없다.
 *
 * 출력 : 모든 인원이 쏘카존에 모일 수 있는 시간을 찾아 출력한다.
 *
 * 출력시형식은
 *
 * 예시 1 3 12:00 ~ 23:59 11:00 ~ 18:00 14:00 ~ 20:00 출력 14:00 ~ 18:00
 */
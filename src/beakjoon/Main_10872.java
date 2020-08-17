package beakjoon;

/**
 * Created by ccoli on 2020/08/01.
 */

import java.util.Scanner;

public class Main_10872 {
    static int result;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //재귀로 풀기
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt(); //10



        System.out.println(Factorial(N));
    }

    public static int Factorial(int n ) {
        if(n==1) {
            return 1;
        }
        //   Factorial(n-1);

        return n * Factorial(n-1);
    }
}
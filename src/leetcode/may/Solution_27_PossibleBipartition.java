package leetcode.may;

/**
 * Created by ccoli on 2020/05/27.
 */

public class Solution_27_PossibleBipartition {

    public static void main(String... args) {
        int[][] arr1 = {{1, 2}, {1, 3}, {2, 4}};
        int[][] arr2 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] arr3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] arr4 = {{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10},
            {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9},
            {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}};
        System.out.println(possibleBipartition(4, arr1));
        System.out.println(possibleBipartition(3, arr2));
        System.out.println(possibleBipartition(5, arr3));
        System.out.println(possibleBipartition(10, arr4));
    }

    private static int[] check;
    private static int max;
    private static int[][] arr;

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        check = new int[N + 1];
        max = dislikes.length;
        arr = dislikes;

        return func(0);
    }

    private static boolean func(final int x) {
        if (x == max) {
            return true;
        }

        boolean flag = true;
        boolean change = false;

        int a = arr[x][0];
        int b = arr[x][1];

        int indexA = check[a];
        int indexB = check[b];

        if (indexA > 0) {
            if (indexB == 0) {
                if (indexA == 1) {
                    indexB = 2;
                } else {
                    indexB = 1;
                }
                check[b] = indexB;
            } else if (indexA == indexB) {
                flag = false;
            }
        } else {
            if (indexB == 0) {
                check[a] = 1;
                check[b] = 2;
                change = true;
            } else {
                if (indexB == 1) {
                    indexA = 2;
                } else {
                    indexA = 1;
                }
                check[a] = indexA;
            }
        }

        if (flag) {
            if (!func(x + 1)) {
                flag = false;
                if (change) {
                    System.out.println(a + " " + b);
                    check[a] = 2;
                    check[b] = 1;
                    flag = func(x + 1);
                }
            }
        }

        return flag;
    }
}
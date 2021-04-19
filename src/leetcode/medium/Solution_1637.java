package leetcode.medium;

import java.util.Arrays;

/**
 * Created by ds on 2021/04/12.
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 */

public class Solution_1637 {

    public static void main(String... args) {
        System.out.println(maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
        System.out.println(maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] != point2[0])
                return point1[0] - point2[0];
            else
                return point1[1] - point2[1];
        });

        int maxWidth = 0;
        int length = points.length;
        for (int i = 1; i < length; i++) {
            int width = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }

    /**
     * given n points on a 2d plane where points[i] = [x1, y1]
     * return the widest vertical area between two points such that no points are inside the area.
     *
     * a vertical area is an area of fixed-width extending infinitely along the y-axis
     * (i.e., infinite height)
     *
     * the widest vertical area is the one with the maximum width.
     *
     * note the points on the edge of a vertical area are not considered included in the area.
     *
     * 문제가 이해가 안감
     */
}
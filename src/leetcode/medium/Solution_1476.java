package leetcode.medium;

/**
 * Created by ds on 2021/03/30.
 * https://leetcode.com/problems/subrectangle-queries/
 */

public class Solution_1476 {

    public static void main(String... args) {
        String[] commands = new String[]{"SubrectangleQueries", "getValue", "updateSubrectangle", "getValue", "getValue", "updateSubrectangle", "getValue", "getValue"};
        int[][] arr = new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        int[][] params = new int[][]{{0,2},{0,0,3,2,5},{0,2},{3,1},{3,0,3,2,10},{3,1},{0,2}};
        int index = 0;
        SubrectangleQueries subrectangleQueries = null;

        for (String command : commands) {
            switch (command) {
                case "SubrectangleQueries": {
                    subrectangleQueries = new SubrectangleQueries(arr);
                    break;
                }
                case "getValue": {
                    int[] now = params[index++];
                    System.out.println(subrectangleQueries.getValue(now[0], now[1]));
                    break;
                }
                case "updateSubrectangle": {
                    int[] now = params[index++];
                    int x1 = now[0];
                    int y1 = now[1];
                    int x2 = now[2];
                    int y2 = now[3];
                    int value = now[4];
                    subrectangleQueries.updateSubrectangle(x1, y1, x2, y2, value);
                    break;
                }
                default:
                    break;
            }
        }
    }

    static class SubrectangleQueries {
        private int[][] arr;

        public SubrectangleQueries(int[][] rectangle) {
            this.arr = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    arr[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return arr[row][col];
        }
    }

    /**
     * implement the class SubrectangleQueries which receives a row x cols
     *
     * rectangle as a matrix of integers in the constructor and supports two methods
     *
     * 1. updateSubrectangle
     * updates all values with newValue in the subrectangle whose upper left coordinate is (row1, col1)
     * and bottom right coordinate is (row2, col2)
     *
     * 2. getValue
     * returns the current value of the coordinate (row, col) form the rectangle
     */
}
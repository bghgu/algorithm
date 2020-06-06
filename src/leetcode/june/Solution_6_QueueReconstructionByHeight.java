package leetcode.june;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ccoli on 2020/06/06.
 */

public class Solution_6_QueueReconstructionByHeight {

    public static void main(String... args) {
        int[][] arr ={
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        System.out.println(Arrays.deepToString(reconstructQueue(arr)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        Arrays.sort(people, (a1, a2) -> {
            if(a1[0]!=a2[0]){
                return a2[0]-a1[0];
            }else{
                return a1[1]-a2[1];
            }
        });

        ArrayList<int[]> list = new ArrayList<>();

        for (int[] arr : people) {
            list.add(arr[1], arr);
        }

        for(int i=0; i<people.length; i++){
            result[i]=list.get(i);
        }

        return result;
    }
}
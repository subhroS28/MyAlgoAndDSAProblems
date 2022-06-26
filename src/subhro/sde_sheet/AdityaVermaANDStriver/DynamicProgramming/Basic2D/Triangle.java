package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic2D;

import java.util.*;
/**
 * Question - https://leetcode.com/problems/triangle/
 *
 * Blog - https://www.geeksforgeeks.org/minimum-sum-path-triangle/
 */
public class Triangle {
    //Recursively
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        return minimumTotalHelper(triangle, 0, 0, len);
    }

    private int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, int len){
        if(row==len-1){
            return triangle.get(row).get(col);
        }

        int res1 = minimumTotalHelper(triangle, row+1, col, len) + triangle.get(row).get(col);
        int res2 = minimumTotalHelper(triangle, row+1, col+1, len) + triangle.get(row).get(col);

        return Math.min(res1, res2);
    }

    //Memoization
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        return minimumTotalHelper2(triangle, 0, 0, len, new Integer[len][len]);
    }

    private int minimumTotalHelper2(List<List<Integer>> triangle, int row, int col, int len, Integer[][] dp){
        int mod = (int)1e9+7;
        if(row==len-1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col]!=null) return dp[row][col];

        int res1 = minimumTotalHelper2(triangle, row+1, col, len, dp)%mod + triangle.get(row).get(col)%mod;
        int res2 = minimumTotalHelper2(triangle, row+1, col+1, len, dp)%mod + triangle.get(row).get(col)%mod;

        dp[row][col] = Math.min(res1, res2);
        return dp[row][col];
    }

    //Tabulation
    public int minimumTotal3(List<List<Integer>> triangle) {
        int len = triangle.size();
        int mod = (int)1e9+7;

        int[][]dp = new int[len][len];

        //Base Condition
        for(int col=0; col<len; col++){
            dp[len-1][col] = triangle.get(len-1).get(col);
        }

        for(int row=len-2; row>=0; row--){
            for(int col=row; col>=0; col--){
                int res1 = dp[row+1][col]%mod + triangle.get(row).get(col)%mod;
                int res2 = dp[row+1][col+1]%mod + triangle.get(row).get(col)%mod;

                dp[row][col] = Math.min(res1, res2);
            }
        }

        return dp[0][0];
    }

    //Tabulation + Space Optimised
    public int minimumTotal4(List<List<Integer>> triangle) {
        int len = triangle.size();
        int mod = (int)1e9+7;

        int[]dp = new int[len];

        //Base Condition
        for(int col=0; col<len; col++){
            dp[col] = triangle.get(len-1).get(col);
        }

        for(int row=len-2; row>=0; row--){
            int temp[] = new int[len];
            for(int col=row; col>=0; col--){
                int res1 = dp[col]%mod + triangle.get(row).get(col)%mod;
                int res2 = dp[col+1]%mod + triangle.get(row).get(col)%mod;

                temp[col] = Math.min(res1, res2);
            }

            dp = temp;
        }

        return dp[0];
    }
}

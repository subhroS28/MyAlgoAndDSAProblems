package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic2D;

/**
 * Question - https://leetcode.com/problems/unique-paths-ii/submissions/
 *
 * Blog - https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
 */
public class CountPath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return helper(m-1, n-1, new Integer[m][n], obstacleGrid);
    }

    private int helper(int row, int col, Integer[][] dp, int[][] obstacleGrid){
        if(row==0 && col==0 && obstacleGrid[row][col]==0){
            return 1;
        }

        if(row<0 || col<0 || obstacleGrid[row][col]==1){
            return 0;
        }

        if(dp[row][col]!=null) return dp[row][col];

        int left = helper(row, col-1, dp, obstacleGrid);
        int down = helper(row-1, col, dp, obstacleGrid);

        dp[row][col] = left + down;
        return dp[row][col];
    }

    //Tabulation
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int row = 0; row<m; row++){
            for(int col=0; col<n; col++){
                if(row==0 && col==0 && obstacleGrid[row][col]==0){
                    dp[row][col]=1;
                }else{
                    int left = 0;
                    int down = 0;

                    if(row>0 && obstacleGrid[row][col]==0){
                        left = dp[row-1][col];
                    }

                    if(col>0 && obstacleGrid[row][col]==0){
                        down = dp[row][col-1];
                    }

                    dp[row][col] = left + down;
                }
            }
        }

        return dp[m-1][n-1];
    }

    //Tabulation Improved [Because of less if conditions]
    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int row = 0; row<m; row++){
            for(int col=0; col<n; col++){
                if(obstacleGrid[row][col]!=0){
                    dp[row][col]=0;
                }else if(row==0 && col==0){
                    dp[row][col]=1;
                }else{
                    int left = 0;
                    int down = 0;

                    if(row>0){
                        left = dp[row-1][col];
                    }

                    if(col>0){
                        down = dp[row][col-1];
                    }

                    dp[row][col] = left + down;
                }
            }
        }

        return dp[m-1][n-1];
    }

    //Tabulation with Space Optimised [Best Answer]
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        for(int row = 0; row<m; row++){
            int[] temp = new int[n];
            for(int col=0; col<n; col++){
                if(obstacleGrid[row][col]!=0){
                    temp[col]=0;
                }else if(row==0 && col==0){
                    temp[col]=1;
                }else{
                    int left = 0;
                    int down = 0;

                    if(row>0){
                        left = dp[col];
                    }

                    if(col>0){
                        down = temp[col-1];
                    }

                    temp[col] = left + down;
                }
            }
            dp = temp;
        }

        return dp[n-1];
    }


}

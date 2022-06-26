package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic2D;

/**
 * Question - https://leetcode.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return minPathSumHelper(row-1, col-1, grid, new Integer[row][col]);
    }

    private int minPathSumHelper(int row, int col, int[][] grid, Integer[][] dp) {
        if(row==0 && col==0){
            return grid[0][0];
        }

        if(row<0 || col<0) return Integer.MAX_VALUE;

        if(dp[row][col]!=null) return dp[row][col];

        int up = minPathSumHelper(row-1, col, grid, dp) + grid[row][col];
        int left = minPathSumHelper(row, col-1, grid, dp) + grid[row][col];

        dp[row][col] = Math.min(up, left);
        return dp[row][col];
    }

    //Tabulation
    public int minPathSum2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(row==0 && col==0){
                    dp[row][col] = grid[0][0];
                }else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    if(row>0){
                        left = dp[row-1][col] + grid[row][col];
                    }

                    if(col>0){
                        up = dp[row][col-1] + grid[row][col];
                    }

                    dp[row][col] = Math.min(up, left);
                }
            }
        }

        return dp[rows-1][cols-1];
    }

    //Tabulation With Space optimisation
    public int minPathSum3(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] prev = new int[cols];

        for(int row=0; row<rows; row++){
            int[] temp = new int[cols];
            for(int col=0; col<cols; col++){
                if(row==0 && col==0){
                    temp[col] = grid[0][0];
                }else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    if(row>0){
                        left = prev[col] + grid[row][col];
                    }

                    if(col>0){
                        up = temp[col-1] + grid[row][col];
                    }

                    temp[col] = Math.min(up, left);
                }
            }
            prev = temp;
        }

        return prev[cols-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println("Answer is "+minPathSum.minPathSum3(arr));
    }

}

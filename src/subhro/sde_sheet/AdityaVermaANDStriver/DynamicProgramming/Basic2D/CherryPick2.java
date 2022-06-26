package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic2D;

/**
 * Question - https://leetcode.com/problems/cherry-pickup-ii/
 */
public class CherryPick2 {

    //Recursion
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return cherryPickupHelper(grid, 0, 0, col-1, row, col);
    }

    private int cherryPickupHelper(int[][] grid, int row, int col1, int col2, int rows, int cols){
        int mod = (int)1e9+7;

        if(col1<0 || col1>=cols || col2<0 || col2>=cols) return Integer.MIN_VALUE;

        if(row==rows-1){
            if(col1==col2){
                return grid[row][col1];
            }else{
                return grid[row][col1]+grid[row][col2];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int subAns = 0;
                if(col1==col2){
                    subAns = grid[row][col1] + cherryPickupHelper(grid, row+1, col1+i, col2+j, rows, cols)%mod;
                }else{
                    subAns = grid[row][col1] + grid[row][col2] + cherryPickupHelper(grid, row+1, col1+i, col2+j, rows, cols)%mod;
                }

                max = Math.max(max, subAns)%mod;
            }
        }

        return max;
    }

    //Memoization
    public int cherryPickup2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return cherryPickupHelper(grid, 0, 0, col-1, row, col, new Integer[row][col][col]);
    }

    private int cherryPickupHelper(int[][] grid, int row, int col1, int col2, int rows, int cols, Integer[][][] dp){
        int mod = (int)1e9+7;

        if(col1<0 || col1>=cols || col2<0 || col2>=cols) return Integer.MIN_VALUE;

        if(row==rows-1){
            if(col1==col2){
                return grid[row][col1];
            }else{
                return grid[row][col1]+grid[row][col2];
            }
        }

        if(dp[row][col1][col2]!=null) return dp[row][col1][col2];

        int max = Integer.MIN_VALUE;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int subAns = 0;
                if(col1==col2){
                    subAns = grid[row][col1] + cherryPickupHelper(grid, row+1, col1+i, col2+j, rows, cols, dp)%mod;
                }else{
                    subAns = grid[row][col1] + grid[row][col2] + cherryPickupHelper(grid, row+1, col1+i, col2+j, rows, cols, dp)%mod;
                }

                max = Math.max(max, subAns)%mod;
            }
        }

        dp[row][col1][col2] = max;
        return dp[row][col1][col2];
    }

    //Tabulation
    public int cherryPickup3(int[][] grid) {
        int mod = (int)1e9+7;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        //Base case
        for(int col1=0; col1<cols; col1++){
            for (int col2=0; col2<cols; col2++){
                if(col1==col2){
                    dp[rows-1][col1][col2] = grid[rows-1][col1];
                }else{
                    dp[rows-1][col1][col2] = grid[rows-1][col1]+grid[rows-1][col2];
                }
            }
        }

        for(int row=rows-2; row>=0; row--){
            for(int col1=0; col1<cols; col1++){
                for (int col2=0; col2<cols; col2++){
                    int max = Integer.MIN_VALUE;
                    for(int i=-1; i<=1; i++){
                        for(int j=-1; j<=1; j++){
                            int subAns;
                            if(col1==col2){
                                subAns = grid[row][col1];
                            }else{
                                subAns = grid[row][col1] + grid[row][col2];
                            }
                            if(col1+i>=0 && col1+i<cols && col2+j>=0 && col2+j<cols){
                                subAns += dp[row+1][col1+i][col2+j]%mod;
                            }else{
                                subAns += Integer.MIN_VALUE;
                            }

                            max = Math.max(subAns, max);
                        }
                    }
                    dp[row][col1][col2] = max;
                }
            }
        }

        //This is the answer because as in mentioned player1 starts from 0th pos and 2nd from (cols-1)th pos
        return dp[0][0][cols-1];
    }

}

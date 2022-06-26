package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic2D;

/**
 * Question -
 */
public class CountPath {
    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m-1, n-1);
    }

    private int uniquePathsHelper(int row, int col){
        if(row==0 && col==0){
            return 1;
        }

        if(row<0 || col<0){
            return 0;
        }

        int left = uniquePathsHelper(row, col-1);
        int down = uniquePathsHelper(row-1, col);

        return left + down;
    }

    public int uniquePaths2(int m, int n) {
        return uniquePathsHelper2(m-1, n-1, new Integer[m][n]);
    }


    private int uniquePathsHelper2(int row, int col, Integer[][] dp){
        if(row==0 && col==0){
            return 1;
        }

        if(row<0 || col<0){
            return 0;
        }

        if(dp[row][col]!=null) return dp[row][col];

        int left = uniquePathsHelper2(row, col-1, dp);
        int down = uniquePathsHelper2(row-1, col, dp);

        dp[row][col] = left + down;
        return dp[row][col];
    }

    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];

        for(int row = 0; row<m; row++){
            for(int col=0; col<n; col++){
                if(row==0&&col==0){
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

    //Space Optimised
    public static int uniquePaths4(int m, int n) {
        int[] dp = new int[n];

        for(int row = 0; row<m; row++){
            int[] temp = new int[n];
            for(int col=0; col<n; col++){
                if(row==0&&col==0){
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

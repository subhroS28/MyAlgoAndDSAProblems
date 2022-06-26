package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic2D;

public class MaxPathSumVariable {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<col; i++){
            min = Math.min(min, minFallingPathSumHelper(matrix, row-1, i));
        }

        return min;
    }

    private int minFallingPathSumHelper(int[][] matrix, int row, int col) {
        if(row==0){
            return matrix[0][col];
        }

        int res1 = Integer.MAX_VALUE;
        if(col-1>=0){
            res1 = matrix[row][col] + minFallingPathSumHelper(matrix, row-1, col-1);
        }

        int res2 = matrix[row][col] + minFallingPathSumHelper(matrix, row-1, col);

        int res3 = Integer.MAX_VALUE;
        if(col+1<matrix[0].length){
            res3 = matrix[row][col] + minFallingPathSumHelper(matrix, row-1, col+1);
        }

        return Math.min(Math.min(res1, res2) , res3);
    }

    private int minFallingPathSumHelper2(int[][] matrix, int row, int col) {
        if(row==0){
            return matrix[0][col];
        }

        if(col<0 || col>=matrix[0].length) return Integer.MAX_VALUE;

        int res1 = matrix[row][col] + minFallingPathSumHelper2(matrix, row-1, col-1);
        int res2 = matrix[row][col] + minFallingPathSumHelper2(matrix, row-1, col);
        int res3 = matrix[row][col] + minFallingPathSumHelper2(matrix, row-1, col+1);

        return Math.min(Math.min(res1, res2) , res3);
    }

    //Memoization
    public int minFallingPathSum2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<col; i++){
            min = Math.min(min, minFallingPathSumHelper2(matrix, row-1, i, new Integer[row][col], row));
        }

        return min;
    }

    private int minFallingPathSumHelper2(int[][] matrix, int row, int col, Integer[][] dp, int len) {
        int mod = (int)1e9+7;
        if(col<0 || col>=len) return Integer.MAX_VALUE;

        if(row==0){
            return matrix[0][col];
        }

        if(dp[row][col]!=null) return dp[row][col];

        int res1 = matrix[row][col] + minFallingPathSumHelper2(matrix, row-1, col-1, dp, len)%mod;
        int res2 = matrix[row][col] + minFallingPathSumHelper2(matrix, row-1, col, dp, len)%mod;
        int res3 = matrix[row][col] + minFallingPathSumHelper2(matrix, row-1, col+1, dp, len)%mod;

        dp[row][col] = Math.min(Math.min(res1, res2) , res3)%mod;

        return dp[row][col];
    }

    //Tabulaion
    public int minFallingPathSum3(int[][] matrix) {
        int mod = (int)1e9+7;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        //For Base case
        for(int col=0; col<cols; col++){
            dp[0][col] = matrix[0][col];
        }

        for(int row=1; row<rows; row++){
            for(int col=0; col<cols; col++){
                int res1 = Integer.MAX_VALUE;
                if(col-1>=0){
                    res1 = matrix[row][col] + dp[row-1][col-1];
                }

                int res2 = matrix[row][col] + dp[row-1][col];

                int res3 = Integer.MAX_VALUE;
                if(col+1<cols){
                    res3 = matrix[row][col] + dp[row-1][col+1];
                }

                dp[row][col] = Math.min(Math.min(res1, res2) , res3)%mod;
            }
        }

        //As here answer will be the min of the last row
        int res = Integer.MAX_VALUE;
        for(int col=0; col<cols; col++){
            res = Math.min(res, dp[rows-1][col]);
        }

        return res;
    }

    //Tabulaion Space Optimised
    public int minFallingPathSum4(int[][] matrix) {
        int mod = (int)1e9+7;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] prev = new int[cols];

        //For Base case
        for(int col=0; col<cols; col++){
            prev[col] = matrix[0][col];
        }

        for(int row=1; row<rows; row++){
            int[] temp = new int[cols];
            for(int col=0; col<cols; col++){
                int res1 = Integer.MAX_VALUE;
                if(col-1>=0){
                    res1 = matrix[row][col] + prev[col-1];
                }

                int res2 = matrix[row][col] + prev[col];

                int res3 = Integer.MAX_VALUE;
                if(col+1<cols){
                    res3 = matrix[row][col] + prev[col+1];
                }

                temp[col] = Math.min(Math.min(res1, res2) , res3)%mod;
            }
            prev = temp;
        }

        //As here answer will be the min of the last row
        int res = Integer.MAX_VALUE;
        for(int col=0; col<cols; col++){
            res = Math.min(res, prev[col]);
        }

        return res;
    }
}

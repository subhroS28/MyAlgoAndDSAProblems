package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.MatrixChainMultiplication;

/**
 * Question - https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1/
 */
public class MatrixChainMultiplication {
    //Memoization
    int matrixMultiplication(int n, int arr[]) {
        return matrixMultiplicationHelper(arr, 1, n-1, new Integer[n][n]);
    }

    private int matrixMultiplicationHelper(int[] arr, int start, int end, Integer[][] dp) {
        if(start==end) return 0;

        if(dp[start][end]!=null) return dp[start][end];

        int required = Integer.MAX_VALUE;
        for(int k=start; k<end; k++){
            int subRes = arr[start-1] * arr[k] * arr[end] + matrixMultiplicationHelper(arr, start, k, dp) +
                    matrixMultiplicationHelper(arr, k+1, end, dp);

            required = Math.min(required, subRes);
        }

        dp[start][end] = required;
        return dp[start][end];
    }

    //Tabulation
    int matrixMultiplication2(int n, int arr[]) {
        int[][] dp = new int[n][n];

        //Base condition
        for(int i=0; i<n; i++){
            dp[i][i] = 0;
        }

        for(int start= n-1; start>0; start--){
            for(int end=start+1; end<n; end++){
                int required = Integer.MAX_VALUE;
                for(int k=start; k<end; k++){
                    int subRes = arr[start-1] * arr[k] * arr[end] + dp[start][k] + dp[k+1][end];
                    required = Math.min(required, subRes);
                }
                dp[start][end] = required;
            }
        }

        return dp[1][n-1];
    }
}

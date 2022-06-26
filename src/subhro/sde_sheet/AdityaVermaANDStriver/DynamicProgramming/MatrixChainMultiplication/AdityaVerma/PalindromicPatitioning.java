package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.MatrixChainMultiplication.AdityaVerma;

/**
 * Question - https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/
 */
public class PalindromicPatitioning {

    //Memoization
    int palindromicPartition(String str)
    {
        int len = str.length();
        return palindromicPartition(str, 0, len-1, new Integer[len][len]);
    }

    private int palindromicPartition(String str, int start, int end, Integer[][] dp) {
        if(start>=end) return 0; //As for single char or no char the minimum partition required is 0

        if(dp[start][end]!=null) return dp[start][end];

        int minPartition = Integer.MAX_VALUE;
        if(checkPalindrome(str, start, end)){
            minPartition = 0;
        }else{
            for(int k=start; k<end; k++){
                int subRes = 1 + palindromicPartition(str, start, k, dp) +
                        palindromicPartition(str, k+1, end, dp);

                minPartition = Math.min(minPartition, subRes);
            }
        }

        dp[start][end] = minPartition;
        return dp[start][end];
    }

    private boolean checkPalindrome(String str, int start, int end) {
        while(start<end){
            if(str.charAt(start++)!=str.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    //Tabulation
    int palindromicPartition2(String str)
    {
        int len = str.length();
        int[][] dp = new int[len][len];

        for(int i=len-1; i>=0; i--){
            for(int j=i+1; j<len; j++){
                int minPartition = Integer.MAX_VALUE;
                if(checkPalindrome(str, i, j)){
                    minPartition = 0;
                }else{
                    for(int k=i; k<j; k++){
                        int subRes = 1 + dp[i][k]+ dp[k+1][j];
                        minPartition = Math.min(minPartition, subRes);
                    }
                }
                dp[i][j] = minPartition;
            }
        }

        return dp[0][len-1];
    }
}

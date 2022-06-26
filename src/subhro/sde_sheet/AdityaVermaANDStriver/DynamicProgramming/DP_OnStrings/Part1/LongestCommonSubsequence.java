package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * Question - https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    //Memoization 1
    //[NOTE AS HERE, IN THE BASE CASE, THE INDEX IS -1 WHICH WILL BE TOUGH WHILE CONVERTING INTO TABULATION
    // SO, WE WILL CHANGE MEMOIZATION CODE, SEE - longestCommonSubsequence2 AND longestCommonSubsequenceHelper2 METHOD]
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        return longestCommonSubsequenceHelper(text1, text2, len1-1, len2-1, new Integer[len1][len2]);
    }

    private int longestCommonSubsequenceHelper(String text1, String text2, int index1, int index2, Integer[][] dp) {
        if(index1<0 || index2<0) return 0;

        if(dp[index1][index2]!=null) return dp[index1][index2];

        int val;
        if(text1.charAt(index1)==text2.charAt(index2)){
            val = 1 + longestCommonSubsequenceHelper(text1, text2, index1-1, index2-1, dp);
        }else{
            val = Math.max(longestCommonSubsequenceHelper(text1, text2, index1, index2-1, dp),
                    longestCommonSubsequenceHelper(text1, text2, index1-1, index2, dp));
        }

        dp[index1][index2] = val;
        return dp[index1][index2];
    }

    //MEMOIZATION 2 [This is similar to MEMOIZATION 1, just that in this we have shifter index by 1 so that we can
    // form a base case for tabulation based on this]
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        return longestCommonSubsequenceHelper2(text1, text2, len1, len2, new Integer[len1+1][len2+1]);
    }

    private int longestCommonSubsequenceHelper2(String text1, String text2, int index1, int index2, Integer[][] dp) {
        if(index1==0 || index2==0) return 0;

        if(dp[index1][index2]!=null) return dp[index1][index2];

        int val;
        if(text1.charAt(index1-1)==text2.charAt(index2-1)){
            val = 1 + longestCommonSubsequenceHelper2(text1, text2, index1-1, index2-1, dp);
        }else{
            val = Math.max(longestCommonSubsequenceHelper2(text1, text2, index1, index2-1, dp),
                    longestCommonSubsequenceHelper2(text1, text2, index1-1, index2, dp));
        }

        dp[index1][index2] = val;
        return dp[index1][index2];
    }

    //Tabulation
    public int longestCommonSubsequence3(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        //NOTE: AS IN THIS CASE, FOR BASE CONDITION THE VALUE WILL BE 0, WHICH IS THE DEFAULT VALUE OF "int",
        //writing base case is not needed, but for other person's clarity we can write that
        //Thus commenting for now as this is redundant
        /*
        for(int i=0; i<=len1; i++) dp[i][0] = 0;
        for(int i=0; i<=len2; i++) dp[0][i] = 0;
         */

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                int val;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    val = 1 + dp[i-1][j-1];
                }else{
                    val = Math.max(dp[i-1][j], dp[i][j-1]);
                }

                dp[i][j] = val;
            }
        }

        return dp[len1][len2];
    }

    //Tabulation + Space Optimisation
    public int longestCommonSubsequence4(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] dp = new int[len2+1];

        for(int i=1; i<=len1; i++){
            int[] curr = new int[len2+1];
            for(int j=1; j<=len2; j++){
                int val;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    val = 1 + dp[j-1];
                }else{
                    //NOTE THIS BELOW LINE AS HERE INSTEAD OF "dp[j-1]" WE ARE USING "curr[j-1]" because
                    // it was dp[i][j-1] and dp[i] means curr so use curr.
                    val = Math.max(dp[j], curr[j-1]);
                }

                curr[j] = val;
            }
            dp = curr;
        }

        return dp[len2];
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * TRY THIS AGAIN
 * Question - https://leetcode.com/problems/shortest-common-supersequence/
 */
public class ShortestSupersequence {
    /**
     * LOGIC - Supersequence of 2 strings is a string that can form both the 2 string subsequences.
     *         So to get the minimun Supersequence we have to check while forming the Supersequence that
     *         comman part [i.e. the lcs] comes only once.
     *
     *         So in below code we form the lcs 2d array and then print all the chars and lcs only once.
     */

    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] lcs = longestCommonSubsequence(str1, str2, len1, len2);

        StringBuilder requiredStr = new StringBuilder();
        int i = len1;
        int j = len2;
        while (i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                requiredStr.insert(0, str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(lcs[i-1][j]>lcs[i][j-1]){
                    requiredStr.insert(0, str1.charAt(i-1));
                    i--;
                }else{
                    requiredStr.insert(0, str2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i>0) {
            requiredStr.insert(0, str1.charAt(i-1));
            i--;
        }

        while(j>0) {
            requiredStr.insert(0, str2.charAt(j-1));
            j--;
        }

        return requiredStr.toString();
    }

    public int[][] longestCommonSubsequence(String text1, String text2, int len1, int len2) {
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

        return dp;
    }
}

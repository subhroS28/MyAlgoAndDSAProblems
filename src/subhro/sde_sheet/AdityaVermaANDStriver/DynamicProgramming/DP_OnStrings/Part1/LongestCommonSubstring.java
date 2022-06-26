package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * Question - https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1/
 */
public class LongestCommonSubstring {

    /**
     * NOTE :- LongestCommonSubstring is very similar to LongestCommonSubsequence, just that in LongestCommonSubsequence
     * we were not caring about the continuity but in LongestCommonSubstring we care about continuity.
     * So the only change in Recursive code [and similarly for memoization and tabulation] will be :-
     *
     * (A). For LongestCommonSubsequence :-
     *      if(text1.charAt(index1-1)==text2.charAt(index2-1)){
     *             val = 1 + longestCommonSubsequenceHelper2(text1, text2, index1-1, index2-1, dp);
     *      }else{
     *             val = Math.max(longestCommonSubsequenceHelper2(text1, text2, index1, index2-1, dp),
     *                     longestCommonSubsequenceHelper2(text1, text2, index1-1, index2, dp));
     *      }
     *
     *  (B). For LongestCommonSubstring :-
     *       if(text1.charAt(index1-1)==text2.charAt(index2-1)){
     *             val = 1 + longestCommonSubsequenceHelper2(text1, text2, index1-1, index2-1, dp);
     *       }else{
     *             val = 0;
     *       }
     *
     *
     *    And then we have to check in dp what is the max value as in case of longestCommonSubsequence the answer was at
     *    dp[len1][len2], but for LongestCommonSubstring, we have to check for max value as answer will not be there at
     *    dp[len1][len2] position.
     */

    //This is the best solution for interview [If want more space optimisation then use longestCommonSubstr5 as that is also working],
    //other below ways like [recursion etc. are for understanding only]
    //Tabulation
    int longestCommonSubstr(String text1, String text2, int len1, int len2){
        int[][] dp = new int[len1+1][len2+1];

        //NOTE: AS IN THIS CASE, FOR BASE CONDITION THE VALUE WILL BE 0, WHICH IS THE DEFAULT VALUE OF "int",
        //writing base case is not needed, but for other person's clarity we can write that
        //Thus commenting for now as this is redundant
        /*
        for(int i=0; i<=len1; i++) dp[i][0] = 0;
        for(int i=0; i<=len2; i++) dp[0][i] = 0;
         */

        int res = 0;
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                int val;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    val = 1 + dp[i-1][j-1];
                    res = Math.max(res, val);
                }else{
                    val = 0;
                }

                dp[i][j] = val;
            }
        }

        return res;
    }

    //Tabulation + Space Optimisation
    int longestCommonSubstr5(String text1, String text2, int len1, int len2){
        int[] prev = new int[len2+1];

        //NOTE: AS IN THIS CASE, FOR BASE CONDITION THE VALUE WILL BE 0, WHICH IS THE DEFAULT VALUE OF "int",
        //writing base case is not needed, but for other person's clarity we can write that
        //Thus commenting for now as this is redundant
        /*
        for(int i=0; i<=len1; i++) dp[i][0] = 0;
        for(int i=0; i<=len2; i++) dp[0][i] = 0;
         */

        int res = 0;
        for(int i=1; i<=len1; i++){
            int[] curr = new int[len2+1];
            for(int j=1; j<=len2; j++){
                int val;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    val = 1 + prev[j-1];
                    res = Math.max(res, val);
                }else{
                    val = 0;
                }

                curr[j] = val;
            }
            prev = curr;
        }

        return res;
    }




    //Recursion [this is working]
    int longestCommonSubstr2(String text1, String text2, int len1, int len2){
        return longestCommonSubstrHelper(text1, text2, len1, len2, 0);
    }

    private int longestCommonSubstrHelper(String text1, String text2, int len1, int len2, int count) {
        if(len1 == 0 || len2 == 0) return count;

        if(text1.charAt(len1-1) == text2.charAt(len2-1)){
            count = longestCommonSubstrHelper(text1, text2, len1-1, len2-1, count+1);
        }

        count = Math.max(count, Math.max( longestCommonSubstrHelper(text1, text2, len1, len2-1, 0),
                longestCommonSubstrHelper(text1, text2, len1-1, len2, 0) ));
        return count;
    }

    /*
    BELOW Memoization DID NOT WORK
    //Memoization
    int longestCommonSubstr3(String text1, String text2, int len1, int len2){
        return longestCommonSubstrHelper(text1, text2, len1, len2, 0, new Integer[len1+1][len2+1]);
    }

    private int longestCommonSubstrHelper(String text1, String text2, int len1, int len2, int count, Integer[][] dp) {
        if(len1 == 0 || len2 == 0) return count;

        if(dp[len1][len2]!=null) return dp[len1][len2];

        if(text1.charAt(len1-1) == text2.charAt(len2-1)){
            count = longestCommonSubstrHelper(text1, text2, len1-1, len2-1, count+1, dp);
        }

        count = Math.max(count, Math.max( longestCommonSubstrHelper(text1, text2, len1, len2-1, 0, dp),
                longestCommonSubstrHelper(text1, text2, len1-1, len2, 0, dp) ));

        dp[len1][len2] = count;
        return dp[len1][len2];
    }*/
}

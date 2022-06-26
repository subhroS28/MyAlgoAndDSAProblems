package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * Question - https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1/
 */
public class MinInsertionDeletionToConvertOneStringToAnother {
    /**
     * Logic - For this we know that one string can be converted to another string and maximum insetring and deletion
     *         in that case will be (length of 1 string + length of 2nd string) i.e. by deleting all the chars of
     *         the given string and by inserting all the char of the required string.
     *
     *         Now as we want minimum insertion and deletion, for this we have to make sure that we are not deleting the
     *         common portion of these 2 string and that we are also not again inserting that common string .
     *         And this common string is LCS.
     *
     *         Thus, the formula becomes -> [len1 + len2] - 2(lcs)
     *
     *         which is [Total Insertion + total deletion] where
     *         Total Insertion = (str1/str2)'s length - lcs  and
     *         total deletion =  (str2/str1)'s length - lcs
     *
     */

    public int minOperations(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        int lcs = longestCommonSubsequence(str1, str2);

        int numberOfDeletion = len1 - lcs;
        int numberOfInsertion = len2 - lcs;

        return numberOfDeletion + numberOfInsertion;
    }

    public int longestCommonSubsequence(String text1, String text2) {
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

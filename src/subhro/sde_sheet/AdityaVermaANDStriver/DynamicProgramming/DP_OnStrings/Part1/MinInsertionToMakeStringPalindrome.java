package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * Question - https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1/
 *            https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */
public class MinInsertionToMakeStringPalindrome {

    public int minInsertions(String s) {
        return s.length() - longestCommonSubsequence(s, reverseString(s));
    }

    private String reverseString(String s){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            str.insert(0, s.charAt(i));
        }

        return str.toString();
    }

    public int longestCommonSubsequence(String text1, String text2) {
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
}

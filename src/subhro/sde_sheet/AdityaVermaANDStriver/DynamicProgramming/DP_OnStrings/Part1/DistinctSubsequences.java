package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * Question - https://leetcode.com/problems/distinct-subsequences/
 *            https://practice.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1/
 */
public class DistinctSubsequences {
    //Memoization
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        return numDistinctHelper(s, t, len1, len2, new Integer[len1+1][len2+1]);
    }

    private int numDistinctHelper(String text1, String text2, int len1, int len2, Integer[][] dp) {
        if(len2 == 0) return 1;
        if(len1 == 0) return 0;

        if(dp[len1][len2]!=null) return dp[len1][len2];

        //This case is of when we are not picking the char of both the strings
        int res = numDistinctHelper(text1, text2, len1-1, len2, dp);
        if(text1.charAt(len1-1)==text2.charAt(len2-1)){
            //This case is of when the char is matched so we are now reducing len by 1
            //for both so that comparison of words gets reduce.
            res += numDistinctHelper(text1, text2, len1-1, len2-1, dp);
        }

        dp[len1][len2] = res;
        return dp[len1][len2];
    }

    //Tabulation
    public int numDistinct2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        //BASE CONDITION
        for(int i=0; i<=len1; i++){
            dp[i][0] = 1;
        }

        for (int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                int res = dp[i-1][j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //This case is of when the char is matched so we are now reducing len by 1
                    //for both so that comparison of words gets reduce.
                    res += dp[i-1][j-1];
                }

                dp[i][j] = res;
            }
        }

        return dp[len1][len2];
    }

    //Tabulation + Space Optimisation
    public int numDistinct3(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] prev = new int[len2+1];

        //BASE CONDITION
        prev[0] = 1;

        for (int i=1; i<=len1; i++){
            int[] curr = new int[len2+1];
            curr[0] = 1;
            for(int j=1; j<=len2; j++){
                int res = prev[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //This case is of when the char is matched so we are now reducing len by 1
                    //for both so that comparison of words gets reduce.
                    res += prev[j-1];
                }

                curr[j] = res;
            }
            prev = curr;
        }

        return prev[len2];
    }

    //Tabulation + Space Optimisation [1S Array]
    public int numDistinct4(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] prev = new int[len2+1];

        //BASE CONDITION
        prev[0] = 1;

        for (int i=1; i<=len1; i++){
            for(int j=len2; j>=1; j--){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //This case is of when the char is matched, so we are now reducing len by 1
                    //for both so that comparison of words gets reduce.
                    prev[j] = prev[j-1] +  prev[j];
                }
            }
        }

        return prev[len2];
    }


}

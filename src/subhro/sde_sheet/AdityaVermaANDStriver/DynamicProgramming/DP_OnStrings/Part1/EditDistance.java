package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * Do it again
 *
 * Question - https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

    //Memoization
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        return minDistanceHelper(word1, word2, len1, len2, new Integer[len1+1][len2+1]);
    }

    private int minDistanceHelper(String word1, String word2, int len1, int len2, Integer[][] dp) {
        //Base condition
        //len1 == 0 means that first string is finished and the only way to reach string2 is by
        // adding remaining chars of string2 to string 1
        if(len1==0) return len2;

        //len2==0 means string2 has completly matched so now we have to remove all the remaining chars of string1
        if(len2==0) return len1;

        if(dp[len1][len2]!=null) return dp[len1][len2];

        int res = 0;
        if(word1.charAt(len1-1)==word2.charAt(len2-1)){
            res = 0 + minDistanceHelper(word1, word2, len1-1, len2-1, dp);
        }else{
            //First is insertion, second is deletion and 3rd is replacement
            res = 1 + Math.min(Math.min(minDistanceHelper(word1, word2, len1, len2-1, dp), //Insertion
                    minDistanceHelper(word1, word2, len1-1, len2, dp)),  //Deletion
                    minDistanceHelper(word1, word2, len1-1, len2-1, dp)); //Replacement
        }

        dp[len1][len2] = res;
        return dp[len1][len2];
    }

    //Tabulation
    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];

        //Base Condition
        //Base case 1
        for(int i=0; i<=len2; i++)
            dp[0][i] = i;

        //Base Case 2
        for(int i=0; i<=len1; i++)
            dp[i][0] = i;

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                int res;

                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    res = 0 + dp[i-1][j-1];
                }else{
                    //First is insertion, second is deletion and 3rd is replacement
                    res = 1 + Math.min(Math.min(dp[i][j-1], //Insertion
                                    dp[i-1][j]),  //Deletion
                            dp[i-1][j-1]); //Replacement
                }

                dp[i][j] = res;
            }
        }

        return dp[len1][len2];
    }

    //Tabulation + Space Optimisation
    public int minDistance3(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[] dp = new int[len2+1];

        /*
        These 2 below base cases is a great case
        //Base Condition
        //Base Case 1
        for(int i=0; i<=len2; i++)
            dp[0][i] = i;

        //Base Case 2
        for(int i=0; i<=len1; i++)
            dp[i][0] = i;
         */

        for(int i=0; i<=len1; i++)
            dp[i] = i;

        for(int i=1; i<=len1; i++){
            int[] curr = new int[len2+1];
            curr[0] = i;  //This is for base case 2

            for(int j=1; j<=len2; j++){
                int res;
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    res = 0 + dp[j-1];
                }else{
                    //First is insertion, second is deletion and 3rd is replacement
                    res = 1 + Math.min(Math.min(curr[j-1], //Insertion
                                    dp[j]),  //Deletion
                            dp[j-1]); //Replacement
                }

                curr[j] = res;
            }
            dp = curr;
        }

        return dp[len2];
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

/**
 * TRY THIS AGAIN
 * Question - https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {

    //Memoization
    //This below solution was without seeing the answer video of STRIVER.
    public boolean isMatch(String str, String ptn) {
        int len1 = str.length();
        int len2 = ptn.length();
        return isMatchHelper(str, ptn, len1, len2, new Boolean[len1+1][len2+1]);
    }

    private boolean isMatchHelper(String str, String ptn, int len1, int len2, Boolean[][] dp) {
        //Base Cases
        if(len1==0 && len2==0) return true;
        if(len1==0 && len2>0){
            if(ptn.charAt(len2-1)=='*'){
                return isMatchHelper(str, ptn, len1, len2-1, dp);
            }
            return false;
        }
        if(len2==0 && len1>0) return false;

        if(dp[len1][len2]!=null) return dp[len1][len2];
        char ptnChar = ptn.charAt(len2-1);
        boolean res;
        if(ptnChar == '*' || ptnChar == '?'){
            if(ptnChar == '?'){
                res = isMatchHelper(str, ptn, len1-1, len2-1, dp);
            }else{
                //NOTE: - THE FIRST CONDITION [isMatchHelper(str, ptn, len1-1, len2-1, dp)] IS Redundant
                //        AS CONDITION2 AND CONDITION3 ARE BASICALLY COVERING CONDITION1
                res = isMatchHelper(str, ptn, len1-1, len2-1, dp) ||   //This means we are replacing * by the char of str
                        isMatchHelper(str, ptn, len1-1, len2, dp) ||        //This means we are replacing * by multiple char
                        isMatchHelper(str, ptn, len1, len2-1, dp);          //This means we are not considering * and removing it
            }
        }else{
            if(ptnChar!=str.charAt(len1-1)){
                res = false;
            }else{
                res = isMatchHelper(str, ptn, len1-1, len2-1, dp);
            }
        }

        dp[len1][len2] = res;
        return dp[len1][len2];
    }

    //Memoization by Striver [Only little changes are there]
    public boolean isMatch2(String str, String ptn) {
        int len1 = str.length();
        int len2 = ptn.length();
        return isMatchHelper2(str, ptn, len1, len2, new Boolean[len1+1][len2+1]);
    }

    private boolean isMatchHelper2(String str, String ptn, int len1, int len2, Boolean[][] dp) {
        //Base Conditions
        if(len2==0 && len1==0) return true;
        if(len2==0 && len1>0) return false;
        if(len1==0 && len2>0){
            for(int i=len2-1; i>=0; i--){
                if(ptn.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[len1][len2]!=null) return dp[len1][len2];

        char ptnChar = ptn.charAt(len2-1);
        boolean res;

        if(ptnChar == '?' || ptnChar==str.charAt(len1-1)){
            res = isMatchHelper2(str, ptn, len1-1, len2-1, dp);
        }else{
            if(ptnChar == '*'){
                //NOTE: - THE FIRST CONDITION [isMatchHelper(str, ptn, len1-1, len2-1, dp)] IS Redundant
                //        AS CONDITION2 AND CONDITION3 ARE BASICALLY COVERING CONDITION1
                res =   isMatchHelper2(str, ptn, len1-1, len2, dp) ||        //This means we are replacing * by multiple char
                        isMatchHelper2(str, ptn, len1, len2-1, dp);          //This means we are not considering * and removing it
            }else{
                res = false;
            }
        }

        dp[len1][len2] = res;
        return dp[len1][len2];

        /*
        Above has less if else condition

        if(ptnChar == '*' || ptnChar == '?'){
            if(ptnChar == '?'){
                res = isMatchHelper2(str, ptn, len1-1, len2-1, dp);
            }else{
                //NOTE: - THE FIRST CONDITION [isMatchHelper(str, ptn, len1-1, len2-1, dp)] IS Redundant
                //        AS CONDITION2 AND CONDITION3 ARE BASICALLY COVERING CONDITION1
                res =   isMatchHelper2(str, ptn, len1-1, len2, dp) ||        //This means we are replacing * by multiple char
                        isMatchHelper2(str, ptn, len1, len2-1, dp);          //This means we are not considering * and removing it
            }
        }else{
            if(ptnChar!=str.charAt(len1-1)){
                res = false;
            }else{
                res = isMatchHelper2(str, ptn, len1-1, len2-1, dp);
            }
        }

        dp[len1][len2] = res;
        return dp[len1][len2];*/
    }

    //Tabulation
    public boolean isMatch3(String str, String ptn) {
        int len1 = str.length();
        int len2 = ptn.length();

        boolean[][] dp = new boolean[len1+1][len2+1];

        //Base Condition
        //condition1
        dp[0][0] = true;

        //condition2
        for(int i=1; i<=len1; i++){
            dp[i][0] = false;
        }

        //Condition3
        for (int i=1; i<=len2; i++){
            boolean flag = true;
            for(int j=i-1; j>=0; j--){
                if(ptn.charAt(j)!='*'){
                    flag = false;
                    break;
                }
            }
            dp[0][i] = flag;
        }

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                char ptnChar = ptn.charAt(j-1);
                boolean res;

                if(ptnChar == '?' || ptnChar==str.charAt(i-1)){
                    res = dp[i-1][j-1];
                }else{
                    if(ptnChar == '*'){
                        //NOTE: - THE FIRST CONDITION [isMatchHelper(str, ptn, len1-1, len2-1, dp)] IS Redundant
                        //        AS CONDITION2 AND CONDITION3 ARE BASICALLY COVERING CONDITION1
                        res =   dp[i-1][j] ||        //This means we are replacing * by multiple char
                                dp[i][j-1];          //This means we are not considering * and removing it
                    }else{
                        res = false;
                    }
                }
                dp[i][j] = res;
            }
        }

        return dp[len1][len2];
    }

    //Tabulation + Space optimization [It is kind of complex to understand]
    public boolean isMatch4(String str, String ptn) {
        int len1 = str.length();
        int len2 = ptn.length();

        boolean[] dp = new boolean[len2+1];

        //Base Condition
        //condition1
        dp[0] = true;

        /* This has been shifted in main for loop
        //condition2
        for(int i=1; i<=len1; i++){
            dp[i][0] = false;
        }*/

        //Condition3
        for (int i=1; i<=len2; i++){
            boolean flag = true;
            for(int j=i-1; j>=0; j--){
                if(ptn.charAt(j)!='*'){
                    flag = false;
                    break;
                }
            }
            dp[i] = flag;
        }

        for(int i=1; i<=len1; i++){
            boolean[] curr = new boolean[len2+1];
            for(int j=1; j<=len2; j++){
                //base condition 3
                boolean flag = true;
                for(int k=j-1; k>=0; k--){
                    if(ptn.charAt(k)!='*'){
                        flag = false;
                        break;
                    }
                }
                curr[j] = flag;

                char ptnChar = ptn.charAt(j-1);
                boolean res;

                if(ptnChar == '?' || ptnChar==str.charAt(i-1)){
                    res = dp[j-1];
                }else{
                    if(ptnChar == '*'){
                        //NOTE: - THE FIRST CONDITION [isMatchHelper(str, ptn, len1-1, len2-1, dp)] IS Redundant
                        //        AS CONDITION2 AND CONDITION3 ARE BASICALLY COVERING CONDITION1
                        res =   dp[j] ||        //This means we are replacing * by multiple char
                                curr[j-1];          //This means we are not considering * and removing it
                    }else{
                        res = false;
                    }
                }
                curr[j] = res;
            }

            dp = curr;
        }

        return dp[len2];
    }
}

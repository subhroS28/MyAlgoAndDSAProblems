package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part1;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        System.out.print("LCS of "+s1+" and "+s2+" is : "+printLongestCommonSubsequence(s1, s2));
    }
    public static String printLongestCommonSubsequence(String text1, String text2) {
        int[][] dp = longestCommonSubsequence(text1, text2);

        int i = text1.length();
        int j = text2.length();
        StringBuilder lcsString = new StringBuilder();
        while (i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                lcsString.insert(0, text1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        return lcsString.toString();
    }

    public static int[][] longestCommonSubsequence(String text1, String text2) {
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

        return dp;
    }
}

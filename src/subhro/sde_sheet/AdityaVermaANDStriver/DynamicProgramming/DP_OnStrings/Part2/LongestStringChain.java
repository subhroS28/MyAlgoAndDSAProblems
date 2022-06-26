package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part2;

import java.util.Arrays;

/**
 * TRY IT AGAIN
 * Same as LIS
 *
 * Question - https://leetcode.com/problems/longest-string-chain/
 *
 * Blog - https://leetcode.com/problems/longest-string-chain/discuss/1936832/similar-to-LIS-DP
 *        https://leetcode.com/problems/longest-string-chain/discuss/1687507/Java-or-LCS-%2B-LIS-Approach-or-Not-very-efficient-but-very-intuitive
 *
 */
public class LongestStringChain {
    public static void main(String[] args) {
        String[] strs = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        LongestStringChain longestStringChain = new LongestStringChain();
//        System.out.print("value is "+longestStringChain.checkStrings("acda", "abc"));
        System.out.println("value is "+longestStringChain.longestStrChain(strs));

    }
    public int longestStrChain(String[] words) {
//        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int len = words.length;
        int[] dp = new int[len];

        for(int i=0; i<len; i++)
            dp[i] = 1;

        int ans = 1;
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(dp[j]+1>dp[i] && checkStrings(words[i], words[j])){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i]>ans){
                ans = dp[i];
            }
        }
        return ans;
    }

    private boolean checkStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if(len1 != len2+1){
            return false;
        }

        int i=0;
        int j=0;
        while(i<len1){
            if(j==len2){
                return j==i;
            }
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }
        System.out.println();
        System.out.print(word1 +" " +word2+" are : ");
        if(i==len1 && j==len2){
            System.out.println("true");
            return true;
        }else {
            System.out.println("false");
            return false;
        }
    }
}

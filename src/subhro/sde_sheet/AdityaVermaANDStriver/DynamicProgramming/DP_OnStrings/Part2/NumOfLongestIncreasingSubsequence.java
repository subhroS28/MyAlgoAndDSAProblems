package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part2;

/**
 * Question - https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class NumOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        NumOfLongestIncreasingSubsequence numOfLongestIncreasingSubsequence = new NumOfLongestIncreasingSubsequence();
        int[] nums = new int[] {1,3,5,4,7};
//        int[] nums = new int[] {2,2,2,2,2};
        System.out.println("findNumberOfLIS is "+numOfLongestIncreasingSubsequence.findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];

        for (int i=0; i<len; i++) {
            dp[i] = 1;
            count[i] = 1;
        }

        int longest = 1;
        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                }else if(nums[j]<nums[i] && dp[j]+1==dp[i]){
                    count[i] += count[j];
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        int equalLIS = 0;
        for (int i=0; i<len; i++){
            if(dp[i] == longest){
                equalLIS += count[i];
            }
        }

        return equalLIS;
    }
}

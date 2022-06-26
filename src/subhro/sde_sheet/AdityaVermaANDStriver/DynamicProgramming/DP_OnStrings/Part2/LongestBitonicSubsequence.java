package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part2;

/**
 * Question - https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1/
 */
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 11, 2, 10, 4, 5, 2, 1};
        LongestBitonicSubsequence longestBitonicSubsequence = new LongestBitonicSubsequence();
        System.out.print(longestBitonicSubsequence.LongestBitonicSequence(arr));
    }
    public int LongestBitonicSequence(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        for(int i=0; i<len; i++){
            dp1[i] = 1;
            dp2[i] = 1;
        }

        //For DP1
        for(int i=0; i<len; i++){
            for (int j=0; j<i; j++){
                if(nums[j]<nums[i] && dp1[j]+1 > dp1[i]){
                    dp1[i] = dp1[j]+1;
                }
            }
        }

        //For DP2
        for(int i=len-1; i>=0; i--){
            for (int j=len-1; j>i; j--){
                if(nums[j]<nums[i] && dp2[j]+1 > dp2[i]){
                    dp2[i] = dp2[j]+1;
                }
            }
        }

        int longestSeq = 1;
        for(int i=0; i<len; i++){
            longestSeq = Math.max(longestSeq, dp2[i] + dp1[i] - 1);
        }

        return longestSeq;
    }
}

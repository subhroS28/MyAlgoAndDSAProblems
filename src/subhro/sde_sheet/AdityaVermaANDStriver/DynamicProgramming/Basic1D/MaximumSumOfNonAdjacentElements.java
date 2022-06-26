package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

/**
 * Question - https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/
 *            https://leetcode.com/problems/house-robber/
 *            https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
 *
 * Blog - https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
 *        https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class MaximumSumOfNonAdjacentElements {
    int findMaxSum(int arr[], int n) {
        return findMaxSumHelper(n-1, arr, new Integer[n]);
    }

    private int findMaxSumHelper(int index, int[] arr, Integer[] dp) {
        if(index==0) return arr[index];
        if(index<0) return 0;
        if(dp[index]!=null) return dp[index];

        int ans1 = arr[index] + findMaxSumHelper(index-2, arr, dp);
        int ans2 = 0 + findMaxSumHelper(index-1, arr, dp);

        dp[index] = Math.max(ans1, ans2);
        return dp[index];
    }

    int findMaxSumTabulation(int arr[], int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i=1; i<n; i++){
            int pick = arr[i];
            if(i-2>=0){
                pick += dp[i-2];
            }

            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n-1];
    }

    int findMaxSumBest(int[] arr, int n){
        int prev1 = arr[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int pick = arr[i];
            if(i-2>=0){
                pick += prev2;
            }

            int nonPick = prev1;
            int curr = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

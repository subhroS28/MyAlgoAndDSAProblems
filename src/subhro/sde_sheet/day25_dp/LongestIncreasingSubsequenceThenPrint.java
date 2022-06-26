package subhro.sde_sheet.AdityaVerma.DynamicProgramming.DP_OnStrings.Part2;

import java.util.ArrayList;

/**
 * TRY IT AGAIN
 *
 * Question - https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 */
public class LongestIncreasingSubsequenceThenPrint {

    //Recursion
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        return lengthOfLISHelper(nums, 0,len, -1);
    }

    private int lengthOfLISHelper(int[] nums, int index, int len, int lastNum){
        if(index==len){
            return 0;
        }

        int notTake = 0 + lengthOfLISHelper(nums, index+1, len, lastNum);
        int take = 0;
        if(lastNum==-1 || nums[index]>nums[lastNum]){
            take = 1 + lengthOfLISHelper(nums, index+1, len, index);
        }

        return Math.max(notTake, take);
    }

    //Memoization

    /**
     * Explanation -
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        return lengthOfLISHelper(nums, 0,len, -1, new Integer[len][len+1]);
    }

    private int lengthOfLISHelper(int[] nums, int index, int len, int lastNum, Integer[][] dp){
        if(index==len){
            return 0;
        }

        if(dp[index][lastNum+1]!=null) return dp[index][lastNum+1];

        int notTake = 0 + lengthOfLISHelper(nums, index+1, len, lastNum, dp);
        int take = 0;
        if(lastNum==-1 || nums[index]>nums[lastNum]){
            take = 1 + lengthOfLISHelper(nums, index+1, len, index, dp);
        }

        dp[index][lastNum+1] = Math.max(notTake, take);
        return dp[index][lastNum+1];
    }

    //Tabulation [NOT ABLE TO UNDERSTAND]
    //Watch Striver's video for more clarity
    public int lengthOfLIS3(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len+1][len+1];

        for(int i=len-1; i>=0; i--){
            for(int j=i-1; j>=-1; j--){
                int notTake = 0 + dp[i+1][j+1];
                int take = 0;
                if(j==-1 || nums[i]>nums[j]){
                    take = 1 + dp[i+1][i+1];
                }

                dp[i][j+1] = Math.max(notTake, take);
            }
        }

        return dp[0][-1+1];
    }

    //Tabulation + Space Optimisation
    private int lengthOfLIS4(int[] nums){
        int len = nums.length;
        int[] dp = new int[len+1];

        for(int i=len-1; i>=0; i--){
            int[] curr = new int[len+1];
            for(int j=i-1; j>=-1; j--){
                int notTake = 0 + dp[j+1];
                int take = 0;
                if(j==-1 || nums[i]>nums[j]){
                    take = 1 + dp[i+1];
                }

                curr[j+1] = Math.max(notTake, take);
            }
            dp = curr;
        }

        return dp[-1+1];
    }

    //Different Method [This is algorithmic approach]
    private int lengthOfLIS5(int[] nums){
        int len =  nums.length;
        int[] req = new int[len];

        //As lis of any number is itself i.e. 1, so lets set 1 for all
        for(int i=0; i<len; i++){
            req[i] = 1;
        }

        int result = 1; //We are setting result as 1 because even if no number is lis, still itself it will be, i.e. 1
        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    req[i] = Math.max(req[j]+1, req[i]);
                    result = Math.max(result, req[i]);
                }
            }
        }

        return result;
    }

    //PRINT LIS
    private void printLIS(int[] nums){
        int len =  nums.length;
        int[] req = new int[len];
        int[] track = new int[len];
        ArrayList<Integer> path = new ArrayList<>();

        //As lis of any number is itself i.e. 1, so lets set 1 for all
        for(int i=0; i<len; i++){
            req[i] = 1;
            track[i] = i;
        }

        //int lisIndex = -1; //This is not correct. Even if no number is lis, still itself it will be, i.e. 0
        int lisIndex = 0;

        int result = 1; //We are setting result as 1 because even if no number is lis, still itself it will be, i.e. 1
        for(int curr=1; curr<len; curr++){
            for(int prev=0; prev<curr; prev++){
                if(nums[prev]<nums[curr] && req[prev]+1>req[curr]){
                    req[curr] = req[prev]+1;
                    track[curr] = prev;
                }
            }
            if(req[curr]>result){
                result = req[curr];
                lisIndex = curr;
            }
        }

        path.add(lisIndex);
        while (track[lisIndex] != lisIndex){
            lisIndex = track[lisIndex];
            path.add(lisIndex);
        }

        //printing in reverse order
        System.out.print("LIS IS :");
        for (int i=path.size()-1; i>=0; i--){
            System.out.print(" "+nums[path.get(i)]);
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{7,7,7,7,7,7,7};
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequenceThenPrint longestIncreasingSubsequence = new LongestIncreasingSubsequenceThenPrint();
        System.out.println("Length of LIS is "+longestIncreasingSubsequence.lengthOfLIS5(arr));

        longestIncreasingSubsequence.printLIS(arr);
    }
}

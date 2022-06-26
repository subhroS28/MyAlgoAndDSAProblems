package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
 *            https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/
 */
public class MinTheDiff {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum=0;
        for(int num : arr) sum += num;

        boolean[] dp = subSetSum(arr, sum);
        int min=Integer.MAX_VALUE;
        for(int i=sum/2; i>=0; i--){
            if(dp[i]==true){
                //Note as num1 = i then num2 = (sum - i). So we are checking the Math.abs of these 2 num diff
                min = Math.min(min, Math.abs((sum - i) -i));
            }
        }
        return min;
    }

    public static boolean[] subSetSum(int[] nums, int target) {
        int len = nums.length;
        boolean[] prev = new boolean[target+1];

        //Base Condition
        prev[0] = true;
        if(nums[0]<=target) prev[nums[0]] = true;

        for(int i=1; i<len; i++){
            boolean[] temp = new boolean[target+1];
            temp[0] = true;
            for(int j=1; j<target+1; j++){
                boolean res1 = prev[j];
                boolean res2 = false;
                if(nums[i]<=j){
                    res2 = prev[j-nums[i]];
                }
                temp[j] = res1 || res2;
            }
            prev = temp;
        }

        return prev;
    }
}

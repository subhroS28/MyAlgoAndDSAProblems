package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStrings.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TRY IT AGAIN
 *
 * Very similar to LongestIncreasingSubsequenceThenPrint.printLIS()
 *
 * Question - https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,16,8};
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        List<Integer> ans = largestDivisibleSubset.largestDivisibleSubset(arr);
        ans.forEach(num -> System.out.print(num + " "));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[] divisible = new int[len];
        int[] track = new int[len];
        List<Integer> largestDivisible = new ArrayList<>();
        int largestIndex = -1;
        int largestDivisibleSubsetCount = 0;

        for(int i=0; i<len; i++){
            divisible[i] = 1;
            track[i] = i;
        }

        Arrays.sort(nums);

        for(int curr=0; curr<len; curr++){
            for(int prev=0; prev<curr; prev++){
                if(nums[curr]%nums[prev]==0 && (largestIndex == -1 || divisible[prev]+1 > divisible[curr])){
                    divisible[curr] = divisible[prev]+1;
                    track[curr] = prev;
                }
            }
            if(divisible[curr] > largestDivisibleSubsetCount){
                largestDivisibleSubsetCount = divisible[curr];
                largestIndex = curr;
            }
        }

        //Now storing the numbers of the largestDivisibleSubset
        largestDivisible.add(nums[largestIndex]);
        while(largestIndex != track[largestIndex]){
            largestIndex = track[largestIndex];
            largestDivisible.add(nums[largestIndex]);
        }

        return largestDivisible;
    }


    public List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int[] divisible = new int[len];
        int[] track = new int[len];
        List<Integer> largestDivisible = new ArrayList<>();

        for(int i=0; i<len; i++){
            divisible[i] = 1;
            track[i] = i;
        }

        int largestIndex = 0;
        int largestDivisibleSubsetCount = 1;
        for(int curr=1; curr<len; curr++){
            for(int prev=0; prev<curr; prev++){
                if(nums[curr]%nums[prev]==0 && divisible[prev]+1 > divisible[curr]){
                    divisible[curr] = divisible[prev]+1;
                    track[curr] = prev;
                }
            }
            if(divisible[curr] > largestDivisibleSubsetCount){
                largestDivisibleSubsetCount = divisible[curr];
                largestIndex = curr;
            }
        }

        //Now storing the numbers of the largestDivisibleSubset
        largestDivisible.add(nums[largestIndex]);
        while(largestIndex != track[largestIndex]){
            largestIndex = track[largestIndex];
            largestDivisible.add(nums[largestIndex]);
        }

        return largestDivisible;
    }
}

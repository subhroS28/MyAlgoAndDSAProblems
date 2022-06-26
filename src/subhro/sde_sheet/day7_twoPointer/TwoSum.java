package subhro.sde_sheet.day4_hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
    Ways :- a. Brute Force --> TC -> O(N^2) and SC -> O(1)
            b. Sorting + 2 Pointer --> TC -> O(NlogN) and SC -> O(1)
            c. HashMap --> TC -> O(N) and SC -> O(N)

    NOTE: - Thus, if array is sorted then it is better to use 2 pointer approach as here TC -> O(N) and SC -> O(1)
            We can use binary search also but then TC - O(NlogN)

    Ques -  https://leetcode.com/problems/two-sum/
            https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    Video - https://www.youtube.com/watch?v=dRUpbt8vHpo&ab_channel=takeUforward or
     https://www.youtube.com/watch?v=l5Ruk_Ub8B4&ab_channel=Pepcoding

    Blog -https://leetcode.com/problems/two-sum/discuss/7/Java-O(nlogn)-beats-98.85
 */
public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int[] ints = twoSum2(arr, 9);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+" ");
        }
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /*
    Best if array is sorted as for that we don't have to sort the data and thus time complexity will be O(N) with SC - O(N)
     https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        int currentSum = 0;

        Arrays.sort(numbers);

        while(i<j){
            currentSum = numbers[i];

            if(target-currentSum>numbers[j]){
                i++;
            }else if(target-currentSum<numbers[j]){
                j--;
            }else{
                return new int[]{i+1, j+1};
            }
        }

        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> helper = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(helper.containsKey(target-nums[i])){
                return new int[]{i, helper.get(target-nums[i])};
            }else{
                helper.put(nums[i], i);
            }
        }

        return null;
    }
}

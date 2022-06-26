package subhro.sde_sheet.Other.Array.MajorityElement;

import java.util.Arrays;

/**
 *
 * Approaches - 1. Find count of each unique element and then check if the count is greater than n/2.
 *                  TC - O(N^2)
 *              2. Use HashMap and store the occurrence of each element in hash and then return accordingly.
 *                 TC - O(N) and SC - O(N)
 *              3. Sort the data and then check the element present in n/2 th index. [Only for this question as for other different will be there in n/3th or etc places.]
 *                 TC - O(NlogN) SC - O(N) if we are using temp array.
 *              4. Moore Voting Algorithm. [Best] If majority always exists
 *                 TC - O(N) AND SC - O(1)
 *              5. Moore Voting Algorithm. [Best] If majority may/may not exists.
 *  *              TC - O(N) AND SC - O(1)
 *
 * Question Link - If it is mentioned that majority element always exists - https://leetcode.com/problems/majority-element/
 *                 May/Or May not exists. - https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
 *
 * Blog - https://www.geeksforgeeks.org/majority-element/
 *
 * Video - https://www.youtube.com/watch?v=3tbjwaGC-ng&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=5&ab_channel=Pepcoding
 */
public class MajorityElementN_Half {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int maj = majorityElement5(arr);
        System.out.println("Majority element is "+maj);
    }

    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;

        return nums[n];
    }

    //Most Optimal
    //Using Moore Voting Algo
    public static int majorityElement4(int[] nums) {
        int count = 1;
        int ele = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]==ele){
                count++;
            }else{
                count--;
                if(count == 0){
                    ele = nums[i];
                    count = 1;
                }
            }
        }

        return ele;
    }

    public static int majorityElement5(int[] nums) {
        int potentialElement = majorityElement4(nums);

        //Now lets check if the occurrence of this element is more than n/2
        int count=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i] == potentialElement){
                count++;
                if(count> nums.length/2){
                    return potentialElement;
                }
            }
        }

        return -1;
    }
}

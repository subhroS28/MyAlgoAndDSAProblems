package subhro.sde_sheet.day4_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Quest - https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1# or
 *          https://leetcode.com/problems/4sum/
 *
 *  Blog - https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
 *         https://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
 *
 */
public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(arr, 0);
        for (List<Integer> ll: lists){
            System.out.println(ll);
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> required = new ArrayList<>();

        if(len<4){
            return required;
        }

        Arrays.sort(nums);

        for(int i=0;i<len;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }

            int val = nums[i];
            List<List<Integer>> subList = threeSumUsing2Pointer(nums, target-val, i+1, len-1);
            for(List<Integer> innerList: subList){
                innerList.add(0, val);
                required.add(innerList);
            }
        }

        return required;
    }

    //Using 2 pointer approach
    public static List<List<Integer>> threeSumUsing2Pointer(int[] A, int X, int start,int end) {
        int len = A.length;
        List<List<Integer>> required = new ArrayList<>();

        /*These are not needed as these are covered in 4sum main method only
        if(A.length<=2){
            return required;
        }

        Arrays.sort(A);*/

        for(int i=start;i<end;i++){
            if(i!=start && A[i]==A[i-1]){
                continue;
            }

            int val = A[i];
            List<List<Integer>> subList = twoSum(A, i+1, len-1, X-val);
            for(List<Integer> innerList: subList){
                innerList.add(0, val);
                required.add(innerList);
            }
        }

        return required;
    }

    private static List<List<Integer>> twoSum(int[] arr, int start,int end, int target) {
        int i=start;
        int j=end;
        int currentSum=0;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();

        while(i<j){
            if(res.size()>0 && arr[i]==arr[i-1]){
                i++;
                continue;
            }

            currentSum = arr[i];
            if(target-currentSum>arr[j]){
                i++;
            }else if(target-currentSum<arr[j]){
                j--;
            }else{
                subRes.add(arr[i]);
                subRes.add(arr[j]);
                res.add(subRes);
                subRes = new ArrayList<>();

                i++;
                j--;
            }
        }

        return res;
    }
}

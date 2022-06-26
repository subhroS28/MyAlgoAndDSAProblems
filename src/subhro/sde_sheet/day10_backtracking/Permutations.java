package subhro.sde_sheet.day10_backtracking;

import java.util.*;

/**
 * Question - https://leetcode.com/problems/permutations/
 *
 * Approach - 1. Using extra space.
 *               TC - O(!N)*O(N) AND SC - O(!N) for storing n factorial permutation numbers [other than recursion stack space]
 *
 *            2. Using no extra space by swapping the numbers.
 *              TC - O(!N)*O(N) AND SC - O(1) [other than recursion stack space]
 *
 *  Video - [With extra space] https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51&ab_channel=takeUforward
 *          [Without extra space] https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52&ab_channel=takeUforward
 */
public class N1Permutations {
    //Without any extra space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> req = new ArrayList<>();
        permuteHelper2(nums, nums.length, req, 0);
        return req;
    }

    private void permuteHelper2(int[] nums, int len, List<List<Integer>> req, int index) {
        if(index==len){
            ArrayList<Integer> subRes = new ArrayList<>();
            for(int num : nums){
                subRes.add(num);
            }
            req.add(subRes);
            return;
        }

        for(int i=index; i<len; i++){
            swapNum(i, index, nums);
            permuteHelper2(nums, len, req, index+1);
            swapNum(index, i, nums);
        }
    }

    private void swapNum(int pos1, int pos2, int[] arr){
        if(pos1==pos2) return;

        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    //Using Extra Space
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> req = new ArrayList<>();
        boolean[] path = new boolean[nums.length];
        permuteHelper(nums, nums.length, req, path, new ArrayList<>());
        return req;
    }

    private void permuteHelper(int[] nums, int len, List<List<Integer>> req, boolean[] path, ArrayList<Integer> subReq){
        if(subReq.size()==len){
            req.add(new ArrayList<>(subReq));
            return;
        }

        for(int i=0;i<len;i++){
            /**
              Below logic can also be written as
             if(path[i]){
                 continue;
             }
             path[i] = true;
             subAns.add(nums[i]);
             permuteHelper(nums, len, req, path, subReq);
             subAns.remove(subAns.size()-1);
             path[i] = false;
             */

            if(!path[i]){
                path[i]=true;
                subReq.add(nums[i]);
                permuteHelper(nums, len, req, path, subReq);
                subReq.remove(subReq.size()-1);
                path[i]=false;
            }
        }
    }
}

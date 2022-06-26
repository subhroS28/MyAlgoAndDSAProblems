package subhro.sde_sheet.day9_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question - https://leetcode.com/problems/subsets-ii/submissions/
 *            https://practice.geeksforgeeks.org/problems/subsets-1587115621/1/
 *
 * Blog - https://leetcode.com/problems/subsets-ii/discuss/169226/Java-Two-Way-of-Recursive-thinking
 */
public class SubsetSum2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsetsWithDupHelper(nums, nums.length, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void subsetsWithDupHelper(int[] nums, int len, List<List<Integer>> ans, ArrayList<Integer> subAns, int index){
        ans.add(new ArrayList<>(subAns));

        for(int i=index; i<len; i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            subAns.add(nums[i]);
            subsetsWithDupHelper(nums, len, ans, subAns, i+1);
            subAns.remove(subAns.size()-1);
        }
    }
}

package subhro.sde_sheet.day1_array.rangeSumQuery;

/**
 * Question - https://leetcode.com/problems/range-sum-query-immutable/
 *
 * blog - https://leetcode.com/problems/range-sum-query-immutable/discuss/1494994/Java-or-TC%3A-init-greater-O(N)-sumRange-greater-O(1)-or-Using-Prefix-Sum
 *
 * video - https://www.youtube.com/watch?v=BS3PJLi4BYU&ab_channel=NareshGupta   
 */
public class Immutable1D {
    int[] prefixSum;
    public Immutable1D(int[] nums) {
        int len = nums.length;
        prefixSum = new int[len+1];

        for(int i=1; i<=len; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right+1] - prefixSum[left];
    }
}

package subhro.sde_sheet.day1_array.Others;

/**
 * It may look like "LongestSubArrayHavingSumK" where K = SUM - X for this question,but the solution will not work
 * Question - https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * Video - https://www.youtube.com/watch?v=NRamG4Q9LwQ&ab_channel=AyushiSharma
 */
public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero minimumOperationsToReduceXToZero = new MinimumOperationsToReduceXToZero();
        int[] arr= new int[]{3,2,20,1,1,3};
        System.out.println(minimumOperationsToReduceXToZero.minOperations(arr, 10));
    }

    //2 POINTER
    public int minOperations(int[] nums, int x) {
        int len = nums.length;

        int sum=0;
        for(int num : nums){
            sum += num;
        }

        int req = sum - x;
        int i=0,j=0, maxLen = -1;
        sum = 0;
        while(j<len){
            sum += nums[j];

            while(i<=j && sum>req){
                sum -= nums[i];
                i++;
            }
            if(sum==req){
                maxLen = Math.max(maxLen, j-i+1);
            }
            j++;
        }

        return maxLen == -1 ? -1 : len - maxLen;
    }

    /* This solution will not work
    public int minOperations(int[] nums, int x) {
        int len = nums.length;

        int sum=0;
        for(int num : nums){
            sum += num;
        }

        int req = sum - x;
        int i=0,j=0, maxLen = -1;
        sum = 0;
        while(j<len){
            sum += nums[j];
            if(sum<req){
                j++;
            }else if(sum==req){
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }else{
                while(sum>req && i<=j){
                    sum -= nums[i++];
                }
                j++;
            }
        }

        return maxLen == -1 ? -1 : len - maxLen;
    }*/
}

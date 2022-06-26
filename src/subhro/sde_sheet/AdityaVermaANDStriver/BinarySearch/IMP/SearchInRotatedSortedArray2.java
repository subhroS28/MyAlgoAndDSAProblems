package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch.IMP;

/**
 *
 * With Duplicates
 *
 * Question - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Approach - Steps:-
 *             1. Check if mid is the target then return true;
 *             2. if element in end and mid are equal then reduce mid by 1 [mid--]
 *             3. Now look for portions where you are certain.
 *                i.e look for sorted part:-
 *                a. if arr[mid] < arr[end] that means from mid to end array is sorted
 *                   so check if target is between mid and end by:-
 *                      if(target>arr[mid] && target<=arr[end]) {
 *                          start = mid+1;
 *                      }else{
 *                          end = mid-1;
 *                      }
 *
 *                    else it means from start to mid array is sorted and check
 *                       if(target<nums[mid] && target>=nums[start]){
 *                          end=mid-1;
 *                       }else{
 *                          start=mid+1;
 *                       }
 *
 *
 * Blog - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28290/Binary-search-java-solution
 *
 */
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len-1;
        while(start<=end){
            int mid = start + ((end-start)/2);

            if(nums[mid]==target) return true;
            else if(nums[mid]==nums[end]) end--;
            else if(nums[mid] < nums[end]){
                if(target>nums[mid] && target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                if(target<nums[mid] && target>=nums[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }

        return false;
    }
}

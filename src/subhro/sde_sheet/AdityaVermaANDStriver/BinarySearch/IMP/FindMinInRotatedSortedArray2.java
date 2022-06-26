package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch.IMP;

/**
 * With Duplicates - Worst TC O(N) , this will happen if the majority of numbers are duplicate &
 *                   Best TC - O(logN), when no duplicates are there
 *
 * Question - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Video - [Best] https://www.youtube.com/watch?v=K0PjrikGKK4&ab_channel=KnowledgeCenter
 *
 * Blog - https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-rotated-array-with-duplicates/
 */
public class FindMinInRotatedSortedArray2 {

    public int findMinRec(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];
        return findMinRecHelper(nums, 0, len-1);
    }

    public int findMinRecHelper(int[] nums, int start, int end) {
        if(start == end){
            return nums[start];
        }
        int mid = start + ((end - start)/2);
        //Here we are taking start as mid+1 bz mid is bigger then end and as in question we are looking for smallest number
        //so mid can not be the required number.
        if(nums[mid] > nums[end]) return findMinRecHelper(nums, mid+1, end);

            //here we are not taking end as mid-1 bz mid can be a solution
        else if(nums[mid] < nums[end]) return findMinRecHelper(nums, start, mid);

        //Else means if mid and end index has same number
        else return findMinRecHelper(nums, start, end-1);
    }

    //My favorate
    public int findMinIterativly(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];

        int start = 0;
        int end = len-1;
        while(start<end){
            int mid = start +((end-start)/2);

            if(nums[end] < nums[mid]){
                start = mid+1;
            }else if(nums[end] > nums[mid]){
                end = mid;
            }else{
                end--;
            }
        }
        return nums[start];
    }
}

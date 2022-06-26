package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch.IMP;

/**
 * Without Duplicates - Worst TC & Best TC - O(logN)
 *
 * Question - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Video - [BEST VIDEO] https://www.youtube.com/watch?v=OXkLNPalfRs&ab_channel=KnowledgeCenter
 *
 * Blog - https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 *
 */
public class FindMinInRotatedSortedArray {
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
        //Here we are taking start as mid+1 bz mid is bigger than end and as in question we are looking for smallest number
        //so mid can not be the required number.
        if(nums[mid] > nums[end]) return findMinRecHelper(nums, mid+1, end);

        //here we are not taking end as mid-1 bz mid can be a solution
        else if(nums[mid] < nums[end]) return findMinRecHelper(nums, start, mid);
        return nums[start];
    }

    //My favorate
    public int findMinIterativly(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];

        int start = 0;
        int end = len-1;
        while(start<end){
            int mid = start + ((end - start)/2);

            if(nums[mid] > nums[end]) start = mid+1;
            else if(nums[mid] < nums[end]) end = mid;
        }

        return nums[start];
    }

    //Other favorate
    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len-1;

        if(len==1 || nums[start] < nums[end]) return nums[0];

        while(start<=end){
            int mid = start + ((end-start)/2);

            if(mid>=0 && mid<len){
                if(mid-1>=0 && nums[mid-1]>nums[mid] && nums[mid+1]>nums[mid]){
                    return nums[mid];
                }else if(mid+1<len && nums[mid]>nums[mid+1]){
                    return nums[mid+1];
                }else if(nums[start] < nums[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}

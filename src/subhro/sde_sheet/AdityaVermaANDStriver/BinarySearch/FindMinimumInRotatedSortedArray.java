package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question7 same to Number of times sorted array is rotated. Because the position of minimum element is the number of time
 * array is rotated.
 *
 * Question - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Video - https://www.youtube.com/watch?v=Kcj2NGnuSNg&ab_channel=Pepcoding
 *
 * Approach - Use Binary Search and approach is explained in code and video.
 *            TC - O(logN) and SC - O(1)
 *
 * Great Explanation - https://www.youtube.com/watch?v=K0PjrikGKK4&ab_channel=KnowledgeCenter
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int len = nums.length;

        //Checking if array is sorted or not
        if(nums[0]<nums[len-1]){
            return nums[0];
        }

        //checking if array size is 1 then return that element.
        if(len==1){
            return nums[0];
        }

        int start = 0;
        int end = len-1;
        while(start<=end){

            /**
             * EXPLANATION OF THESE BELOW CONDITIONS
             *
             * For first 2 conditions :- take example - 8 0 i.e 8 is greater than 0 so 0 is minimum
             * so if mid is 0 then we check if nums[mid] > nums[mid+1] because if true then it means that next element is smallest
             * but if nums[mid-1] > nums[mid] then it means we are at smallest
             * else we check which part is sorted and change start and end accordingly.
             *
             */

            int mid = (start+end)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }else if(mid>start && nums[mid-1]>nums[mid]){
                return nums[mid];
            }else if(nums[start]<nums[mid]){
                start=mid+1;
            }else if(nums[end]>nums[mid]){
                end=mid-1;
            }
        }

        return -1;
    }

    public int findMin2(int[] nums) {
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

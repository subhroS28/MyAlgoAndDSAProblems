package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch.IMP;

/**
 * Without Duplicates
 * Question - https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Video - Aditya Verma and https://www.youtube.com/watch?v=7XLg8yMdwxw&ab_channel=KnowledgeCenter
 */
public class SearchInRotatedSortedArray {

    //Best way
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==1){
            return nums[0]==target ? 0 : -1;
        }

        if(nums[0]<nums[len-1]){
            return binarySearch(nums, 0, len-1, target);
        }

        int minEleIndex = findMin(nums);
        if(minEleIndex==-1){
            return -1;
        }else if(target == nums[minEleIndex]){
            return minEleIndex;
        }else if(target > nums[len - 1]){
            return binarySearch(nums, 0, minEleIndex, target);
        }else{
            return binarySearch(nums, minEleIndex, len-1, target);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return -1;
    }

    private int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len-1;
        while(start<end){
            int mid = (start+end)/2;

            if(nums[mid] > nums[end]) start = mid+1;
            else if(nums[mid] < nums[end]) end = mid;
        }

        return start;
    }

    //This is my second best way
    /*
        public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==1){
            return nums[0]==target ? 0 : -1;
        }

        if(nums[0]<nums[len-1]){
            return binarySearch(nums, 0, len-1, target);
        }

        int minEleIndex = findMin(nums);
        if(minEleIndex==-1){
            return -1;
        }else if(nums[0]>target){
            return binarySearch(nums, minEleIndex, len-1, target);
        }else{
            return binarySearch(nums, 0, minEleIndex, target);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return -1;
    }

    private int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid+1;
            }else if(mid>start && nums[mid-1]>nums[mid]){
                return mid;
            }else if(nums[start]<nums[mid]){
                start=mid+1;
            }else if(nums[end]>nums[mid]){
                end=mid-1;
            }
        }

        return -1;
    }
     */
}

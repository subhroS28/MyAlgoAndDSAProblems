package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question8
 * Question - https://leetcode.com/problems/search-in-rotated-sorted-array/
 *            https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1/
 *
 * Blog - https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 * Video - Aditya Verma
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        int[] arr = new int[]{4,5,6,7,0,1,2};
//        System.out.println("pos of ele is "+search(arr, 0));
    }

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

    /*
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        if(minIndex==-1) return -1;
        if(target==nums[minIndex]) return minIndex;

        int len = nums.length;
        if(minIndex==0){
            return binarySearch(nums, 0, len-1, target);
        }else if(nums[0]<=target){
            return binarySearch(nums, 0, minIndex-1, target);
        }else{
            return binarySearch(nums, minIndex+1, len-1, target);
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
        if(nums[0]<nums[len-1]){
            return 0;
        }

        if(len==1){
            return 0;
        }

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
    }*/
}

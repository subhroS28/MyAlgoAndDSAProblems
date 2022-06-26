package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question15
 * Approach - 1. Using Binary Search
 *               In this problem, finding ceil and finding floor will be needed.
 *
 *               Steps:-
 *               1. First check if the target number exists in the array, if exists then return that.
 *               2. If target does not exist then find floor and ceil of the number and then return that element whose
 *               absolute difference is the least.
 *
 *               Note: There is a catch here, if element does not exist then it will end in a condition where high is
 *                      greater than low and so high will be floor and low will be ceil.
 */
public class MinimumDifferenceElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 10, 15};
        int target = 12;
        System.out.println(minDiffElementInSortedArray(arr, target));
    }

    public static int minDiffElementInSortedArray(int[] arr, int target){
        int len=arr.length;
        int low=0;
        int high=len-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==target){
                return target;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        if(Math.abs(target - arr[low]) < Math.abs(target - arr[high])){
            return arr[low];
        }else{
            return arr[high];
        }
    }
}

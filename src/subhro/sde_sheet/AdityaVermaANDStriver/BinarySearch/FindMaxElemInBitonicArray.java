package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question18
 * Bitonic array or Mountain Array are same, and it is a type of array where array first increases then decreases.
 *
 * Question - https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *            https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1/
 *
 * Approach - same as finding peek element, just the difference is that in question where we have to find peek numbers
 *            in an array that is not sorted can have multiple peek element, but in Bitonic array, there will be only one
 *            peek element.
 *
 */
public class FindMaxElemInBitonicArray {
    //Leetcode question
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        if(len==1) return 0;

        //These below cases are commented because Bitomic array is strickly incresing then decreasing so below condition
        //are meaningless
//        if(arr[0]>arr[1]) return 0;
//        if(arr[len-1]>arr[len-2]) return len-1;

        int i=0;
        int j=len-1;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid]){
                return mid;
            }else if(arr[mid-1]>arr[mid]){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return -1;
    }

    //GFG Question
    int findMaximum(int[] arr, int n) {
        int len = arr.length;
        if(len==1) return arr[0];
        if(arr[0]>arr[1]) return arr[0];
        if(arr[len-1]>arr[len-2]) return arr[len-1];

        int i=1;
        int j=len-2;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid]){
                return arr[mid];
            }else if(arr[mid-1]>arr[mid]){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return -1;
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question19
 *
 * Question - https://www.interviewbit.com/problems/search-in-bitonic-array/
 *
 * Approach - 1. Linear Search - Scan each element from left to right.
 *            2. Binary Search — Find peak element and then perform a binary search on one of the halves of the array.
 *
 * Blog - https://afteracademy.com/blog/find-an-element-in-a-bitonic-array
 *        https://www.geeksforgeeks.org/find-element-bitonic-array/
 */
public class SearchAnElementInBitonicArray {
    public static void main(String[] args) {
//        int[] arr = new int[]{40, 30, 25, 21, 19 , 15};
//        int i = descendingBinarySearch(arr, 19, 0, arr.length - 1);
//        System.out.println("position is "+i);


        int[] arr = new int[]{1, 3, 7, 9, 12, 14, 45, 40, 30, 25, 21, 19 , 15};
        System.out.println("position is "+ findElementInBitonicArray(arr, 21));
    }

    public static int findElementInBitonicArray(int[] arr, int target) {
        int len = arr.length;
        if(len==0) return -1;
        if(len==1) return arr[0]==target?0:-1;

        int peekIndex = findPeakElement(arr);
        if(target==arr[peekIndex] || peekIndex==-1) return peekIndex;
        else{
            return Math.max(binarySearch(arr, target, 0, peekIndex-1),
                    binarySearch2(arr, target, peekIndex+1, len-1));
        }
    }

    private static int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) end=mid-1;
            else start=mid+1;
        }

        return -1;
    }
    private static int binarySearch2(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) end=mid-1;
            else start=mid+1;
        }

        return -1;
    }
    private static int findPeakElement(int[] arr) {
        int len = arr.length;
        if(len==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[len-1]>arr[len-2]) return len-1;

        int i=1;
        int j=len-2;
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

    //Way2
    /*
    public static int findElementInBitonicArray(int[] arr, int target){
        int peekElementIndex = peakIndexInMountainArray(arr);
        if(peekElementIndex==-1){
            System.out.println("Array is not a bitonic array.");
            return -1;
        }

        int indexInFirstHalf = ascendingBinarySearch(arr, target, 0, peekElementIndex);
        if(indexInFirstHalf!=-1){
            return indexInFirstHalf;
        }else{
            return descendingBinarySearch(arr, target, peekElementIndex+1, arr.length-1);
        }
    }

    private static int descendingBinarySearch(int[] arr, int target, int low, int high) {
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }

    private static int ascendingBinarySearch(int[] arr, int target, int low, int high) {
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        if(len==1) return 0;

        int i=1;
        int j=len-2;
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
    }*/
}

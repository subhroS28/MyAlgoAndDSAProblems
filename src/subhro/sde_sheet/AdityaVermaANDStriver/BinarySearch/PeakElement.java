package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question17 - In this question we use a concept called Binary Search in answer
 *              It can be used in question where array is not sorted.
 *
 *  Question - https://leetcode.com/problems/find-peak-element/submissions/
 *             https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1
 *             [This question is not same] https://practice.geeksforgeeks.org/problems/peak-element/1/
 *
 *  Blog - https://leetcode.com/problems/find-peak-element/discuss/1290642/Intuition-behind-conditions-or-Complete-Explanation-or-Diagram-or-Binary-Search
 *         https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 *         https://www.geeksforgeeks.org/find-local-minima-array/
 *
 */
public class PeakElement {

    public int findPeakElement(int[] arr) {
        int len = arr.length;
        if(len==1) return 0;

        //Checking if first element is a peak element
        if(arr[0]>arr[1]) return 0;

        //checking if last element is a peak element
        if(arr[len-1]>arr[len-2]) return len-1;

        //i=1 and j=len-2 because 1st and last element are already checked
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
}

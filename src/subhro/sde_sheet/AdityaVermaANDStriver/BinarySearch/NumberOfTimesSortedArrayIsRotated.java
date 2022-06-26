package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question - https://practice.geeksforgeeks.org/problems/rotation4723/1/
 *
 *  Based on same logic - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class NumberOfTimesSortedArrayIsRotated {

    int findKRotation(int arr[], int n) {
        if(n<=1){
            return 0;
        }

        int i=0, j=n-1;
        while(i<j){
            int mid = i + (j-i)/2;

            if(mid>0 && arr[mid]<arr[mid-1]){
                return mid;
            }else if(mid<n && arr[mid]>arr[mid+1]){
                return mid+1;
            }else if(arr[mid]>arr[n-1]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return 0;
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question10
 * Question - https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1/
 */
public class FindFloorInSortedArray {

    static int findFloor(long arr[], int n, long x)
    {
        int i=0;
        int j= arr.length-1;
        if(x<arr[0]) return -1;

        long ans = Integer.MIN_VALUE;
        int index=-1;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]<x){
                if(arr[mid]>ans){
                    ans=arr[mid];
                    index=mid;
                }
                i=mid+1;
            }else{
                j=mid-1;
            }
        }

        return index;
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question11
 * Question - https://www.codingninjas.com/codestudio/problems/ceiling-in-a-sorted-array_1825401?leftPanelTab=1
 *
 * Blog - https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
 */
public class FindCeilInSortedArray {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int i=0;
        int j=arr.length-1;

        int possibleCeil = Integer.MAX_VALUE;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid]==x){
                return x;
            }else if(arr[mid]>x){
                possibleCeil = Math.min(possibleCeil, arr[mid]);
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return possibleCeil==Integer.MAX_VALUE ? -1 : possibleCeil;
    }
}


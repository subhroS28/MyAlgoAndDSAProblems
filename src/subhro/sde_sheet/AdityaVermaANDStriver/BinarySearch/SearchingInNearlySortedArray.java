package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question9
 * Blog - https://www.geeksforgeeks.org/search-almost-sorted-array/
 */
public class SearchingInNearlySortedArray {
    //The condition of nearly sorted array is that the element would be in i-1, i or i+1 postion rather then being in ith pos.
    //Here i position is the position if array was sorted.
    //Example array -> 5, 10, 30, 20, 40

    public static void main(String[] args) {
//        int arr[] = new int[]{5, 10, 30, 20, 40};
        int arr[] = new int[]{10, 3, 40, 20, 50, 80, 70};

        /**
         * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
         * Output: 2
         * Output is index of 40 in given array
         *
         * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
         * Output: -1
         * -1 is returned to indicate element is not present
         */

        System.out.println(searchInNearlySortedArray(arr, 40));
    }

    private static int searchInNearlySortedArray(int[] arr, int element) {
        int i=0;
        int j=arr.length-1;

        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid]==element){
                return mid;
            }else if(mid-1>=i && arr[mid-1]==element){
                return mid-1;
            }else if(mid+1<=j && arr[mid+1]==element){
                return mid+1;
            }else if(arr[mid]>element){
                j=mid-2;
            }else{
                i=mid+2;
            }
        }

        return -1;
    }

}

package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch.base;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 5, 15, 20, 35, 48, 65 };
        int[] arr = {5,3,6,1,12};
//        System.out.println("Position is "+binarySearch(arr, 35));
        System.out.println(findFinalValue(arr, 3));

    }
    public static int findFinalValue(int[] nums, int original) {
        int len=nums.length;
        if(len==1){
            if(nums[0]==original){
                return 2*original;
            }else{
                return original;
            }
        }

        while(binarySearch2(nums, original)){
            original *= 2;
        }

        return original;
    }

    private static boolean binarySearch2(int[] arr, int num){
        int i=0;
        int j=arr.length-1;

        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid]==num){
                return true;
            }else if(arr[mid]>num){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return false;
    }

    public static int binarySearch(int[] arr, int ele){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]==ele){
                return mid;
            }else if(arr[mid]<ele){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return -1;
    }
}

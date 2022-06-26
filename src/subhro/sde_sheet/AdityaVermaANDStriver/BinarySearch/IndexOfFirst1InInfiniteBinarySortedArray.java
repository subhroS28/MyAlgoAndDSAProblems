package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

public class IndexOfFirst1InInfiniteBinarySortedArray {
    static class Pair{
        int low;
        int high;

        Pair(int low, int high){
            this.low = low;
            this.high = high;
        }
    }

    public static long firstOne(int[] arr) {
        int ele = 1;
        Pair ranges = getTheRange(arr, ele);

        int i=ranges.low;
        int j=ranges.high;

        if(j==0){
            return 0;
        }

        while(i<=j){
            int mid = i + (j-i)/2;

            if(arr[mid]==ele){
                int pos = mid-1;
                while(arr[pos]==ele) pos--;

                return pos;
            }else if(arr[mid]>ele){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return -1;
    }

    private static Pair getTheRange(int[] arr, int ele) {
        Pair rangePair = new Pair(0, 0);

        int i=0;
        int j=1;

        while(arr[j]<ele){
            i=j;
            j *= 2;
        }

        rangePair.low=i;
        rangePair.high=j;
        return rangePair;
    }
}

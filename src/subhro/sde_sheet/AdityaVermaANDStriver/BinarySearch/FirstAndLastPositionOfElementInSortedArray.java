package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question5
 * Question - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Approachs - https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
 *
 */
public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);

        System.out.print("[");
        for (int i: ints){
            System.out.print(i+ " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] resArr = new int[2];
        resArr[0] = -1;
        resArr[1] = -1;
        if (len == 0) return resArr;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int i = 0;
        int j = len - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                start = mid - 1;
                while (start >= 0 && nums[start] == target) start--;
                start = start + 1;
                end = mid + 1;
                while (end < len && nums[end] == target) end++;
                end = end - 1;

                resArr[0] = start;
                resArr[1] = end;
                return resArr;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        resArr[0] = start != Integer.MAX_VALUE ? start : -1;
        resArr[1] = end != Integer.MIN_VALUE ? end : -1;

        return resArr;
    }

}

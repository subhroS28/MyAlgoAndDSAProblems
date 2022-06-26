package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question6
 * Blog - https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 *
 * Approach - it is a very simple question. can be solved using linear search in O(N) time but better solution is to
 *            use binary search and find first and last index of number and then subtract these indexes and add 1 and that
 *            is the answer. [Finding first and last index is already done.]
 */
public class CountNumberOfOccurrenceInSortedArray {
    int count(int[] nums, int n, int target) {
        int len = n;
        if (len == 0) return 0;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int i = 0;
        int j = len - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                start = mid-1;
                while(start>=0 && nums[start]==target) start--;
                start = start+1;

                end = mid+1;
                while(end<len && nums[end]==target) end++;
                end = end-1;

                return end-start+1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return 0;
    }
}

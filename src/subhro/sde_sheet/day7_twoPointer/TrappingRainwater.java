package subhro.sde_sheet.day7_array;

/**
 * Question - https://leetcode.com/problems/trapping-rain-water/
 *            https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 *
 * Approach - 1. Naive approach --> TC - O(N^2) AND SC - O(1)
 *            2. Finding leftMax and rightMax of a position and then doing the same step as in naive.
 *               TC - O(N) AND SC - O(2N) AS WE ARE STORING 2 EXTRA ARRAY.
 *            3. 2 POINTER APPROACH  [mOST OPTIMAL]
 *               TC - O(N) AND SC - O(1)
 *
 * Video - https://www.youtube.com/watch?v=m18Hntz4go8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=42&ab_channel=takeUforward
 *
 */
public class TrappingRainwater {
    //Using 2 pointer
    public int trap(int[] arr) {
        int len = arr.length;
        if(len <= 2){
            return 0;
        }

        int res=0;
        int left = 0;
        int right = len-1;
        int leftMax = arr[left];
        int rightMax = arr[right];

        while(left<right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=leftMax){
                    leftMax = arr[left];
                }else{
                    res += (leftMax - arr[left]);
                }
                left++;
            }else{
                if(arr[right]>=rightMax){
                    rightMax = arr[right];
                }else{
                    res += (rightMax - arr[right]);
                }
                right--;
            }
        }

        return res;
    }

    //Optimised Naive Approach / By finding leftMax and RightMax array.
    public int trap3(int[] arr) {
        int len = arr.length;
        if(len <= 2){
            return 0;
        }

        int res = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        int leftMaxVal = arr[0];
        leftMax[0]=arr[0];
        for(int i=1;i<len;i++){
            leftMaxVal = Math.max(leftMaxVal, arr[i-1]);
            leftMax[i] = leftMaxVal;
        }


        int rightMaxVal = arr[len-1];
        rightMax[len-1]=rightMaxVal;
        for(int i=len-2;i>=0;i--){
            rightMaxVal = Math.max(rightMaxVal, arr[i+1]);
            rightMax[i] = rightMaxVal;
        }

        for(int i=1; i<len-1; i++){
            int currentRes = Math.min(leftMax[i], rightMax[i]) - arr[i];
            if(currentRes>0) res += currentRes;
        }

        return res;
    }

    //Naive Approach
    public int trap2(int[] arr) {
        int len = arr.length;
        if(len == 0){
            return 0;
        }

        int res = 0;
        for(int i=1; i<len-1; i++){
            int leftMax = 0;
            int rightMax = 0;

            for(int j=0;j<i;j++){
                leftMax = Math.max(leftMax, arr[j]);
            }

            for(int j=i+1;j<len;j++){
                rightMax = Math.max(rightMax, arr[j]);
            }

            int currentRes = Math.min(leftMax, rightMax) - arr[i];
            if(currentRes>0) res += currentRes;
        }

        return res;
    }
}

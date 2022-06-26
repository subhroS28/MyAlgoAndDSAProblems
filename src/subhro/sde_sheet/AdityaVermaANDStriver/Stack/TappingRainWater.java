package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

/**
 * Question - https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 *            https://leetcode.com/problems/trapping-rain-water/
 *
 *  Approach - 2 popular ways to solve this :-
 *             a. Using 2 pointer approach
 *             b. Using Stack
 */
public class TappingRainWater {

    //USING ADITYA VERMA'S SOLUTION
    static long trappingWater(int arr[], int n) {
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        right[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            if(arr[i]>left[i-1]){
                left[i] = arr[i];
            }else{
                left[i] = left[i-1];
            }
        }

        for(int i=n-2; i>=0; i--){
            if(arr[i]>right[i+1]){
                right[i] = arr[i];
            }else{
                right[i] = right[i+1];
            }
        }

        long res=0;
        for(int i=0; i<n; i++){
            int subRes = Math.min(left[i], right[i]) - arr[i];
            res += subRes;
        }

        return res;
    }


    //Using 2 Pointer Appraoch
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


    //Using Brute Force
    static long trappingWater1(int arr[], int n) {
        int len = arr.length;
        if(len == 0){
            return 0;
        }

        long res = 0;
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

    //Some stack way [Adidya Verma]
    static long trappingWater2(int arr[], int n) {
        int len = arr.length;
        if(len <= 2){
            return 0;
        }

        long res = 0;
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

    //Using 2 pointer
    static long trappingWater3(int arr[], int n) {
        int len = arr.length;
        if(len <= 2){
            return 0;
        }

        long res=0;
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
}

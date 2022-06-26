package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.VariableSize;

import java.util.HashMap;

/**
 * Question - https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1/
 *
 * Approach - 1. If array consists of only positive numbers then using sliding window is the best option
 *            2. If array may have negative number then best is to use HashMap
 *               - https://www.youtube.com/watch?v=20v8zSo2v18&ab_channel=Pepcoding
 *               - https://www.youtube.com/watch?v=GrV3MTR_Uk0&ab_channel=Pepcoding
 *
 * Blog - https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 *
 */
public class LongestSubArrayHavingSumK {
    public static int lenOfLongSubarr (int A[], int N, int K) {
        if(N==1){
            return A[0]==K?1:0;
        }

        HashMap<Integer, Integer> helper = new HashMap<>();
        int sum=0;
        int res=0;
        for(int i=0; i<N; i++){
            sum += A[i];

            if(sum==K){
                res = i+1;
            }

            if(!helper.containsKey(sum)){
                helper.put(sum, i);
            }

            if(helper.containsKey(sum-K)){
                int len = i-helper.get(sum-K);
                res = Math.max(res, len);
            }

        }

        return res;
    }

    public static int lenOfLongSubarrWithOnlyPositive (int A[], int N, int K) {
        if(N==1){
            return A[0]==K?1:0;
        }

        int sum=0;
        int res=0;
        int i=0;
        int j=0;
        while(j<N){
            sum += A[j];
            if(sum<K){
                j++;
            }else if(sum==K){
                int size = j-i+1;
                res = Math.max(res, size);
                j++;
            }else{
                while(sum>K&&i>=0){
                    sum -= A[i++];
                }
                j++;
            }
        }

        return res;
    }
}

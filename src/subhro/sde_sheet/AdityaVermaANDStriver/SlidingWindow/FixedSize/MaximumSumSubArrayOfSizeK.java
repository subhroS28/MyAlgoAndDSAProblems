package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.FixedSize;

import java.util.ArrayList;

/**
 * Question - https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 *
 * Blog - https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
 *
 * video - https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3&ab_channel=AdityaVerma
 */
public class MaximumSumSubArrayOfSizeK {

    //Naive Approach
    static int maximumSumSubarray2(int K, ArrayList<Integer> arr,int N){
        if(N<K){
            return -1; //Because there won't be any window to check as K is greater than number of elements
        }

        int max = 0;
        for(int i=0;i<N-K+1;i++){
            int subSum = 0;
            for(int j=i; j<i+K;j++){
                subSum += arr.get(j);
            }
            max = Math.max(max, subSum);
            subSum = 0;
        }
        return max;
    }

    //Using Sliding Window
    static int maximumSumSubarray(int K, ArrayList<Integer> arr, int N){

        if(N<K){
            return -1; //Because there won't be any window to check as K is greater than number of elements
        }

        int i=0;
        int j=0;
        int max = 0;
        int sum = 0;

        while(j<N){
            sum += arr.get(j);
            if(j+1-i<K){
                j++;
            }else if(j+1-i==K){
                max = Math.max(max, sum);
                sum -= arr.get(i);
                i++;
                j++;
            }
        }

        return max;
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * [This is a HARD problem and below logic will work for array with only positive number. For array with negative number this will oyt work]
 * Question - https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/
 *
 * Blog - https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 *
 */
public class MinimumSubsetProblem {
    public int minDifference(int arr[], int n) {
        int range=0;
        for(int num: arr){
            range += num;
        }

        boolean[][] helper = isSubsetSumPresent(arr, range);
        int min = Integer.MAX_VALUE;
        for (int j = range / 2; j >= 0; j--) {
            if (helper[arr.length][j] == true) {
                min = Math.min(min, Math.abs(range-2*j));
                break;
            }
        }

        return min;
    }

    public boolean[][] isSubsetSumPresent(int[] arr,int sum){
        int n = arr.length;
        boolean[][] strg = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0&&j==0){
                    strg[i][j] = true;
                }else if(j==0){
                    strg[i][j] = true;
                }else if(i==0){
                    strg[i][j] = false;
                }else{
                    boolean res1 = strg[i-1][j];
                    boolean res2 = false;
                    int previous = arr[i-1];
                    if(previous<=j){
                        res2 = strg[i-1][j-previous];
                    }

                    strg[i][j] = res1||res2;
                }
            }
        }

        return strg;
    }
}

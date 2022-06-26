package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

/**
 * Question - https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
 *
 * Blog - https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 */
public class FrogJump {

    /*
    For below :-

    public static int frogJump(int n, int heights[]) {
        return frogJumpHelper(n, heights, 0);
    }
 */
    private static int frogJumpHelper2(int n, int[] heights, int index) {
        if(index==(n-1)){
            return 0;
        }

        int ans1 = frogJumpHelper2(n, heights, index+1) + Math.abs(heights[index] - heights[index+1]);
        int ans2=Integer.MAX_VALUE;
        if(index+2<n){
            ans2 = frogJumpHelper2(n ,heights, index+2) + Math.abs(heights[index] - heights[index+2]);
        }
        return Math.min(ans1, ans2);
    }

    //1. Using Recursion
    public static int frogJump(int n, int heights[]) {
        return frogJumpHelper(heights, n-1);
    }

    private static int frogJumpHelper(int[] heights, int index) {
        if(index==0) return 0;

        int ans1 = frogJumpHelper(heights, index-1) + Math.abs(heights[index] - heights[index-1]);
        int ans2 = Integer.MAX_VALUE;

        if(index-2>=0){
            ans2 = frogJumpHelper(heights, index-2) + Math.abs(heights[index] - heights[index-2]);
        }
        return Math.min(ans1, ans2);
    }

    //Using memoization
    public static int frogJump2(int n, int heights[]) {
        return frogJumpHelperMemo(n, heights, n-1, new Integer[n]);
    }

    private static int frogJumpHelperMemo(int n, int[] heights, int index, Integer[] dp) {
        if(index==0) return 0;

        if(dp[index]!=null) return dp[index];

        int ans1 = frogJumpHelperMemo(n, heights, index-1,dp) + Math.abs(heights[index] - heights[index-1]);
        int ans2 = Integer.MAX_VALUE;

        if(index-2>=0){
            ans2 = frogJumpHelperMemo(n ,heights, index-2,dp) + Math.abs(heights[index] - heights[index-2]);
        }
        dp[index] = Math.min(ans1, ans2);
        return dp[index];
    }

    //Tabulation
    public int frogJump3(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i=1; i<n; i++){
            int ans1 = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ans2 = Integer.MAX_VALUE;

            if(i-2>=0){
                ans2 = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(ans1, ans2);
        }
        return dp[n-1];
    }

    //Tabulation Optimised
    public int frogJump4(int n, int heights[]) {
        int prev1 = 0, prev2=0;
        for(int i=1; i<n; i++){
            int ans1 = prev1 + Math.abs(heights[i] - heights[i-1]);
            int ans2 = Integer.MAX_VALUE;

            if(i-2>=0){
                ans2 = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
            int curr = Math.min(ans1, ans2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}

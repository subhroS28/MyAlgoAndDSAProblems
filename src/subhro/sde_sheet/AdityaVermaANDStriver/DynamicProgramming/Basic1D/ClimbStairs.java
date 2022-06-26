package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

/**
 * This question is very similar to Fibonacci
 *
 * Question - https://leetcode.com/problems/climbing-stairs/
 *
 * Video - Striver
 *
 * Blog - https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
 */
public class ClimbStairs {
    //1. Using Recursion
    public int climbStairs3(int n) {
        if(n<=1) return 1;
        return climbStairs3(n-1) + climbStairs3(n-2);
    }

    //2. Using Memoization
    public int climbStairs2(int n) {
        return climbStairs2Helper(n, new Integer[n+1]);
    }

    private int climbStairs2Helper(int n, Integer[] dp) {
        if(n<=1) return 1;
        if(dp[n]!=null) return dp[n];
        dp[n] = climbStairs2Helper(n-1, dp) + climbStairs2Helper(n-2, dp);
        return dp[n];
    }

    //3rd Using Tabulation
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //4rd Using Tabulation SPACE OPTIMISED
    public int climbStairsBEST(int n) {
        int prev2=1, prev1=1;
        for(int i=2; i<n+1; i++){
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

public class FrogKJump {
    public static int frogJumpKJumps(int n, int heights[], int k) {
        return frogJumpKJumpsHelper(n, heights, k, n-1);
    }

    private static int frogJumpKJumpsHelper(int n, int[] heights, int k, int index) {
        if (index == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int val = frogJumpKJumpsHelper(n, heights, k, index - i) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(min, val);
            }
        }

        return min;
    }

    public static int frogJumpKJumps2(int n, int heights[], int k) {
        int[] dp = new int[n];
        dp[0] = 1;

        for(int index=1; index<n; index++){
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                if (index - i >= 0) {
                    int val = dp[index-i] + Math.abs(heights[index] - heights[index - i]);
                    min = Math.min(min, val);
                }
            }
            dp[index] = min;
        }
        return dp[n-1];
    }
}

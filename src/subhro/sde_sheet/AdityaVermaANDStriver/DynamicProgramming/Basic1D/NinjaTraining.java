package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

/**
 * Question - https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 *
 */
public class NinjaTraining {
    //Recursion
    public static int ninjaTraining(int n, int points[][]) {
        return ninjaTrainingHelper(n-1, points, points[0].length);
    }

    private static int ninjaTrainingHelper(int day, int[][] points, int prev) {
        if(day==0){
            int max = 0;
            for(int i=0; i<points[0].length; i++){
                if(i!=prev){
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }

        int max = 0;
        for(int i=0; i<points[0].length; i++){
            if(i!=prev){
                max = Math.max(max, points[day][i] + ninjaTrainingHelper(day-1, points, i));
            }
        }

        return max;
    }

    //Memoization
    public static int ninjaTraining2(int n, int points[][]) {
        return ninjaTrainingHelper2(n-1, points, points[0].length, new Integer[n][points[0].length+1]);
    }

    private static int ninjaTrainingHelper2(int day, int[][] points, int prev, Integer[][] dp) {
        if(dp[day][prev]!=null) return dp[day][prev];

        if(day==0){
            int max = 0;
            for(int i=0; i<points[0].length; i++){
                if(i!=prev){
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }

        int max = 0;
        for(int i=0; i<points[0].length; i++){
            if(i!=prev){
                max = Math.max(max, points[day][i] + ninjaTrainingHelper2(day-1, points, i, dp));
            }
        }

        dp[day][prev] = max;
        return dp[day][prev];
    }

    //Tabulation
    public static int ninjaTraining3(int n, int points[][]) {
        int days = n;
        int tasks = points[0].length;
        int[][] dp = new int[n][tasks+1];

        //Base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day<days; day++){
            for(int prev=0; prev<tasks+1; prev++){
                int max = 0;
                for(int task=0; task<tasks; task++){
                    if(task!=prev){
                        max = Math.max(max, points[day][task] + dp[day-1][task]);
                    }
                }
                dp[day][prev] = max;
            }
        }
        return dp[n-1][tasks];
    }

    //Tabulation + Space Optimised
    public static int ninjaTrainingBEST(int n, int points[][]) {
        int days = n;
        int tasks = points[0].length;
        int[] dp = new int[tasks+1];

        //Base case
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][1], points[0][0]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day<days; day++){
            int[] temp = new int[tasks+1];
            for(int prev=0; prev<tasks+1; prev++){
                int max = 0;
                for(int task=0; task<tasks; task++){
                    if(task!=prev){
                        max = Math.max(max, points[day][task] + dp[task]);
                    }
                }
                temp[prev] = max;
            }

            dp = temp;
        }
        return dp[tasks];
    }
}

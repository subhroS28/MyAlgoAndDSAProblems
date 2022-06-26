package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.UnboundedKnapsack;

public class CoinToTargetTotalWays {
    //Memoization
    public int change(int amount, int[] coins) {
        return changeHelper(coins, amount, coins.length-1, new Integer[coins.length][amount+1]);
    }

    private int changeHelper(int[] coins, int amount, int index, Integer[][] dp) {
        if(amount==0) return 1;

        /* Below base condition is wrong
        if(index==0){
            if(coins[0]==amount){
                return 1;
            }else{
                return Integer.MAX_VALUE;
            }
        }*/

        //Rather then using Integer.MAX_VALUE use (int)1e9 as adding 1 in Integer.MAX_VALUE will make the value overflow
        if(index==0){
            if(amount%coins[0]==0){
                return 1;
            }
            return 0;
        }

        if(dp[index][amount]!=null) return dp[index][amount];

        int notPick = changeHelper(coins, amount, index-1, dp);
        int pick = 0;
        if(coins[index]<=amount){
            pick = changeHelper(coins, amount - coins[index], index, dp);
        }

        dp[index][amount] = pick +notPick;
        return dp[index][amount];
    }

    //Tabulation
    public int change2(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];

        //Base Case
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int i=1; i<coins.length; i++){
            for(int j=0; j<amount+1; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(coins[i]<=j){
                    pick = dp[i][j-coins[i]];
                }

                dp[i][j] = pick + notPick;
            }
        }

        return dp[coins.length-1][amount];
    }

    //Tabulation + Space Optimised
    public int change3(int[] coins, int amount) {
        int[] prev = new int[amount+1];

        //Base Case
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) prev[i] = 1;
            else prev[i] = 0;
        }

        for(int i=1; i<coins.length; i++){
            int[] curr = new int[amount+1];
            for(int j=0; j<amount+1; j++){
                int notPick = prev[j];
                int pick = 0;
                if(coins[i]<=j){
                    pick = curr[j-coins[i]];
                }

                curr[j] = pick + notPick;
            }
            prev = curr;
        }

        return prev[amount];
    }
}

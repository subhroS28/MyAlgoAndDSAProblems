package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.UnboundedKnapsack;

/**
 * Question - https://leetcode.com/problems/coin-change/
 *            https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class CoinsToTargetMinCoinsReq {
    public int coinChange(int[] coins, int amount) {
        int val = coinChangeHelper(coins, amount, coins.length-1, new Integer[coins.length][amount+1]);

        if(val>=(int)1e9) return -1;
        return val;
    }

    private int coinChangeHelper(int[] coins, int amount, int index, Integer[][] dp) {
        if(amount==0) return 0;

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
                return amount/coins[0];
            }
            return (int)1e9;
        }

        if(dp[index][amount]!=null) return dp[index][amount];

        int notPick = 0 + coinChangeHelper(coins, amount, index-1, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[index]<=amount){
            pick = 1 + coinChangeHelper(coins, amount - coins[index], index, dp);
        }

        dp[index][amount] = Math.min(pick, notPick);
        return dp[index][amount];
    }

    //Tabulation
    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];

        //Base condition
        /* This is wrong as it should not be amount
        for(int i=1; i<amount+1; i++){
            if(amount%i==0) dp[0][i] = amount/i;
            else dp[0][i] = (int)1e9;
        }
        dp[0][0] = (int)1e9;
        */

        //Base condition
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int)1e9;
        }

        for(int i=1; i<coins.length; i++){
            for(int j=0; j<amount+1; j++){
                int notPick = 0 + dp[i-1][j];
                int pick = Integer.MAX_VALUE;
                if(coins[i]<=j){
                    pick = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(pick, notPick);
            }
        }

        int val = dp[coins.length-1][amount];

        if(val>=(int)1e9) return -1;
        return val;
    }

    //Tabulation + Space Optimisation
    public int coinChange3(int[] coins, int amount) {
        int[] prev = new int[amount+1];

        //Base condition
        /* This is wrong as it should not be amount
        for(int i=1; i<amount+1; i++){
            if(amount%i==0) dp[0][i] = amount/i;
            else dp[0][i] = (int)1e9;
        }
        dp[0][0] = (int)1e9;
        */

        //Base condition
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) prev[i] = i/coins[0];
            else prev[i] = (int)1e9;
        }

        for(int i=1; i<coins.length; i++){
            int[] curr = new int[amount+1];
            for(int j=0; j<amount+1; j++){
                int notPick = 0 + prev[j];
                int pick = Integer.MAX_VALUE;
                if(coins[i]<=j){
                    //This is unique, I thought to use prev[j-coins[i]] but correct was to use curr[j-coins[i]]
                    pick = 1 + curr[j-coins[i]];
                }

                curr[j] = Math.min(pick, notPick);
            }
            prev = curr;
        }

        int val = prev[amount];

        if(val>=(int)1e9) return -1;
        return val;
    }
}

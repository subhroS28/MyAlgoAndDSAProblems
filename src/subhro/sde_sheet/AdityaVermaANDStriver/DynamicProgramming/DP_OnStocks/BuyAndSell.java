package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStocks;

/**
 * Question - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuyAndSell {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        BuyAndSell bestTimeToBuyAndSell = new BuyAndSell();
        System.out.print(bestTimeToBuyAndSell.maxProfit(prices));
    }

    // Iteratively
    public int maxProfitIteratively(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int required = 0;

        for(int i=0; i<len; i++){
            min = Math.min(min, prices[i]);

            required = Math.max(required, prices[i] - min);
        }

        return required;
    }

    //Recursively
    public int maxProfit(int[] prices) {
        return maxProfitHelper(prices, 0, Integer.MAX_VALUE);
    }

    private int maxProfitHelper(int[] prices, int index, int min) {
        if(index==prices.length-1){
            if(prices[index]<min){
                min = prices[index];
            }
            return prices[index] - min;
        }

        if(prices[index]<min){
            min = prices[index];
        }

        return Math.max(prices[index] - min, maxProfitHelper(prices, index+1, min));
    }

}

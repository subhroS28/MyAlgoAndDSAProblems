package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.UnboundedKnapsack.LeetCode;

public class TotalBuys {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if(cost1==cost2){
            if(cost1>total) return 1; //That is nothing will be selected
        }

        return waysToBuyPensPencilsHelper(total, cost1, cost2, 0, new Integer[total+1][2]);
    }

    private int waysToBuyPensPencilsHelper(int total, int cost1, int cost2, int index, Integer[][] dp){
        if(index==2) return 1;
        if(total<=0) return 1;

        if(dp[total][index]!=null) return dp[total][index];
        // int way1 = 0;
        // if(index<1){
        //     way1 = waysToBuyPensPencilsHelper(total, cost1, cost2, index+1, dp);
        // }else if(index+1==2){
        //     way1 = 1;
        // }

        int way1 = waysToBuyPensPencilsHelper(total, cost1, cost2, index+1, dp);
        int way2 = 0;
        if(index==0 && total>=cost1){
            way2 = waysToBuyPensPencilsHelper(total-cost1, cost1, cost2, index, dp);
        }

        if(index==1 && total>=cost2){
            way2 = waysToBuyPensPencilsHelper(total-cost2, cost1, cost2, index, dp);
        }

        dp[total][index] = way1 + way2;
        return dp[total][index];
    }

    public long waysToBuyPensPencils2(int totalCost, int cost1, int cost2) {
        if(cost1==cost2){
            if(cost1>totalCost) return 1; //That is nothing will be selected
        }

        int[][] dp = new int[totalCost+1][2];

        //Base condtion
//        for(int i=0; i<=totalCost; i++){
//            dp[i][2] = 1;
//        }

        for(int i=0; i<2; i++)
            dp[0][i] = 1;

        for(int total=1; total<=totalCost; total++){
            for(int index=0; index<2; index++){
                int way1 = dp[total][index+1];
                int way2 = 0;
                if(index==0 && total>=cost1){
                    way2 = dp[total-cost1][index+1];
                }

                if(index==1 && total>=cost2){
                    way2 = dp[total-cost2][index+1];
                }

                dp[total][index] = way1 + way2;
            }
        }
        return dp[totalCost][2];
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

/**
 * Question - https://leetcode.com/contest/biweekly-contest-75/problems/number-of-ways-to-select-buildings/
 */
public class NumOfWaysLEETCODEQ3 {
    //Recursion
    public long numberOfWays(String s) {
        return numberOfWaysHelper(s, s.length()-1, -1, 0);
    }

    private long numberOfWaysHelper(String s, int index, int lastVal, int selected){
        if(selected==3){
            return 1;
        }

        if(index==0){
            if(selected<2){
                return 0;
            }

            int currVal = s.charAt(0) - '0';
            if(lastVal == currVal){
                return 0;
            }else{
                return 1;
            }
        }

        long req = 0;
        for(int i=index; i>=0; i--){
            int currVal = s.charAt(i) - '0';
            if(lastVal != currVal){
                req += numberOfWaysHelper(s, i, currVal, selected+1);
            }
        }

        return req;
    }

    //Memoization - THis is not working
    public long numberOfWays2(String s) {
        int len = s.length();
        return numberOfWaysHelper(s, len-1, 2, 0, new Long[len][3][3]);
    }

    private long numberOfWaysHelper(String s, int index, int lastVal, int selected, Long[][][] dp){
        if(selected==3){
            return 1;
        }

        if(index==0){
            if(selected<2){
                return 0;
            }
            int currVal = s.charAt(0) - '0';
            if(lastVal == currVal){
                return 0;
            }else{
                return 1;
            }
        }

        if(dp[index][selected][lastVal]!=null) return dp[index][selected][lastVal];

        long req = 0;
        for(int i=index; i>=0; i--){
            int currVal = s.charAt(i) - '0';
            if(lastVal != currVal){
                req += numberOfWaysHelper(s, i, currVal, selected+1, dp);
            }
        }

        dp[index][selected][lastVal] = req;
        return dp[index][selected][lastVal];
    }

    //Tabulation
    public long numberOfWays3(String s) {
        int len = s.length();
        long[][][] req = new long[len][3][3];

        for(int i=0; i<len; i++){
            for(int j=0; j<3; j++){
                for (int k=0; k<3; k++){
                    if(k==2){
                        req[i][j][k]=0;
                    }else if(i==0){
                        if(j<2){
                            return 0;
                        }
                        int currVal = s.charAt(i) - '0';
                        if(k == currVal){
                            return 0;
                        }else{
                            return 1;
                        }
                    }else{
                        long res = 0;
                        for(int l=0; l<i; l++){
                            int currVal = s.charAt(l) - '0';
                            if(k != currVal){
                                res += req[i][j+1][k];
                            }
                        }

                        req[i][j][k] = res;
                    }
                }
            }
        }

        return req[len-1][2][2];
    }

    public static void main(String[] args) {
        NumOfWaysLEETCODEQ3 numOfWaysLEETCODEQ3 = new NumOfWaysLEETCODEQ3();
        String s = "001101";
        System.out.println("From Recursion is "+numOfWaysLEETCODEQ3.numberOfWays(s));
        System.out.println("From Memoization is "+numOfWaysLEETCODEQ3.numberOfWays2(s));
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.*;
/**
 * Question - https://leetcode.com/problems/maximal-rectangle/
 *            https://practice.geeksforgeeks.org/problems/max-rectangle/1/
 *
 * Blog - https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 *        https://leetcode.com/problems/maximal-rectangle/discuss/1603593/Java-or-Detailed-Explanation-or-Easy-Approach-or-O(row*col)
 *        https://leetcode.com/problems/maximal-rectangle/discuss/29055/My-java-solution-based-on-Maximum-Rectangle-in-Histogram-with-explanation
 *        https://leetcode.com/problems/maximal-rectangle/discuss/1519263/Java-or-TC%3A-O(RC)-or-SC%3A-O(min(RC))-or-Optimal-Stack-solution
 *        https://leetcode.com/problems/maximal-rectangle/discuss/29127/O(n2)-dp-java-solution
 */
public class MaximalRectangle {
    //GFG
    class Pair{
        int number;
        int index;
        Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    public int maxArea(int matrix[][], int n, int m) {
        int ans = Integer.MIN_VALUE;

        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==0){
                    height[j] = 0;
                }else{
                    height[j]++;
                }
            }

            ans = Math.max(ans, maxArea(height));
        }

        return ans;
    }

    private int maxArea(int[] height){
        int len = height.length;
        int[] right = new int[len];
        int[] left = new int[len];
        Stack<Pair> stack = new Stack<>();

        setNSR(height, right, len, stack);
        setNSL(height, left, len, stack);

        return maxAreaHelper(right, left, height);
    }

    private int maxAreaHelper(int[] right, int[] left, int[] height){
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<height.length; i++){
            int width = right[i] - left[i] - 1;
            int currArea = height[i]*width;
            ans = Math.max(ans, currArea);
        }
        return ans;
    }

    private void setNSL(int[] heights, int[] nsl, int len, Stack<Pair> stack){
        int defaultVal = -1;
        for(int i=0; i<len; i++){
            while(stack.size()>0 && stack.peek().number>=heights[i]){
                stack.pop();
            }

            if(stack.size()==0){
                nsl[i] = defaultVal;
            }else{
                nsl[i] = stack.peek().index;
            }

            stack.push(new Pair(heights[i], i));
        }
        stack.clear();
    }

    private void setNSR(int[] heights, int[] nsr, int len, Stack<Pair> stack){
        int defaultVal = len;
        for(int i=len-1; i>=0; i--){
            while(stack.size()>0 && stack.peek().number>=heights[i]){
                stack.pop();
            }

            if(stack.size()==0){
                nsr[i] = defaultVal;
            }else{
                nsr[i] = stack.peek().index;
            }

            stack.push(new Pair(heights[i], i));
        }
        stack.clear();
    }

    //LEETCODE
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] height = new int[columns];
        int maxArea = Integer.MIN_VALUE;

        for(int row=0; row<rows; row++){
            //Setting up height array values
            if(row==0){
                for(int col=0; col<columns; col++){
                    if(matrix[row][col]=='1'){
                        height[col] = 1;
                    }
                }
            }else{
                for(int col=0; col<columns; col++){
                    if(matrix[row][col]=='0'){
                        height[col] = 0;
                    }else{
                        height[col]++;
                    }
                }
            }

            //Setting up nsl and nsr
            int[] nsl = setupNSL(height, columns);
            int[] nsr = setupNSR(height, columns);

            //Final work for getting the max area
            for(int col=0; col<columns; col++){
                int width = nsr[col] - nsl[col] - 1;
                int area = width * height[col];
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

//    class Pair{
//        int number;
//        int index;
//        Pair(int number, int index){
//            this.number = number;
//            this.index = index;
//        }
//    }

    private int[] setupNSL(int[] height, int len){
        int defaultVal = -1;
        int[] req = new int[len];
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<len; i++){
            while(stack.size()>0 && stack.peek().number>=height[i]){
                stack.pop();
            }

            if(stack.size()==0){
                req[i] = defaultVal;
            }else{
                req[i] = stack.peek().index;
            }
            stack.push(new Pair(height[i], i));
        }

        return req;
    }

    private int[] setupNSR(int[] height, int len){
        int defaultVal = len;
        int[] req = new int[len];
        Stack<Pair> stack = new Stack<>();
        for(int i=len-1; i>=0; i--){
            while(stack.size()>0 && stack.peek().number>=height[i]){
                stack.pop();
            }

            if(stack.size()==0){
                req[i] = defaultVal;
            }else{
                req[i] = stack.peek().index;
            }
            stack.push(new Pair(height[i], i));
        }

        return req;
    }


    //gfg
    public int maxArea2(int matrix[][], int n, int m) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] height = new int[columns];
        int maxArea = Integer.MIN_VALUE;

        for(int row=0; row<rows; row++){
            //Setting up height array values
            if(row==0){
                height = matrix[row];
            }else{
                for(int col=0; col<columns; col++){
                    if(matrix[row][col]==0){
                        height[col] = 0;
                    }else{
                        height[col]++;
                    }
                }
            }

            //Setting up nsl and nsr
            int[] nsl = setupNSL(height, columns);
            int[] nsr = setupNSR(height, columns);

            //Final work for getting the max area
            for(int col=0; col<columns; col++){
                int width = nsr[col] - nsl[col] - 1;
                int area = width * height[col];
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}

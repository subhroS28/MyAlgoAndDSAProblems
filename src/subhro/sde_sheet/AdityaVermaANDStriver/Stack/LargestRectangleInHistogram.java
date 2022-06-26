package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.Stack;

/**
 * Question - https://leetcode.com/problems/largest-rectangle-in-histogram/
 *            https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
 *
 * Blog - https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 *        https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
 *        https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/1741986/Max-Area-Histogram-C%2B%2B-solution-or-Aditya-Verma-Code
 *        https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/1770702/JAVA-COde
 *        https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/1727776/JavaC%2B%2B-Explanation-going-from-Brute-to-Optimal-Approach
 *        https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
 *        https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
 *        https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/29010/My-modified-answer-from-GeeksforGeeks-in-JAVA
 *
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
//        int[] heights = new int[]{2,1,5,6,2,3};
        int[] heights = new int[]{6, 2, 5, 4, 5, 1, 6};
//        int[] heights = new int[]{2, 4};
        System.out.print(largestRectangleInHistogram.largestRectangleArea(heights));
    }

    class Pair{
        int number;
        int index;
        Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nsl = new int[len];
        int[] nsr = new int[len];
        Stack<Pair> stack = new Stack<>();

        setNSL(heights, nsl, len, stack);
        setNSR(heights, nsr, len, stack);

        return largestArea(heights, nsr, nsl, len);
    }

    private int largestArea(int[] heights, int[] nsr, int[] nsl, int len){
        int largestArea = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            int width = nsr[i] - nsl[i] - 1;
            int currArea = heights[i] * width;
            largestArea = Math.max(largestArea, currArea);
        }
        return largestArea;
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
}

package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.*;

/**
 * NOTE: - For sorted array use binary search and 2 pointer for unsorted use Heap/Priority Queue
 *
 * Question - https://leetcode.com/problems/find-k-closest-elements/
 *            https://practice.geeksforgeeks.org/problems/20b8ec4db3f8da0697acdd3d54d9af9f76405443/1/#
 *
 * Video - for heap solution - Aditya Verma
 *         for binary search solution - https://www.youtube.com/watch?v=bhPQq7vqLEA&ab_channel=EricProgramming
 *
 * Approach - 1. Brute Force :- Sort the array and then iterate through the element and have a sepearte array/Arraylist
 *                              where save the (Math.abs(arr[i]-x) and then print the k numbers with lowest diff.
 *
 *            2. Using Heap -
 *               https://leetcode.com/problems/find-k-closest-elements/discuss/1236137/Java-O(nlogK)-solution-!!-Used-Priority-Queue-!!-Java-accepted-solution
 *
 *            3. Using 2 pointer approach
 *               https://leetcode.com/problems/find-k-closest-elements/discuss/1854364/O(n)-or-constant-space-or-Java-or-with-image
 *               https://leetcode.com/problems/find-k-closest-elements/discuss/1316003/Java-O(n)-Solution-oror-Two-Pointers-oror-97-Faster
 *
 *            3. Binary Search and 2 point approach - FASTEST
 *               https://leetcode.com/problems/find-k-closest-elements/discuss/106451/Binary-Search-and-Two-Pointers-18-ms
 *               https://leetcode.com/problems/find-k-closest-elements/discuss/1271169/2-Minute-Read-Binary-Search-and-Two-Pointer
 *               https://leetcode.com/problems/find-k-closest-elements/discuss/1628844/Java-or-log(n)-%2B-k-or-Binary-Search-%2B-Two-Pointers
 *
 * Blog - https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 *        https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/
 *
 */
public class N4KthClosestElements {

    class Pair{
        int diff;
        int num;

        Pair(int diff, int num){
            this.diff = diff;
            this.num = num;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(
            (p1, p2) -> {
                if(p1.diff == p2.diff){
                    return p2.num - p1.num;
                }
                return p2.diff-p1.diff;
            }
        );

        int counter=0;
        for(int num : arr){
            queue.add(new Pair(Math.abs(num-x), num));
            counter++;

            if(counter>k){
                queue.poll();
                counter--;
            }
        }

        while(!queue.isEmpty()){
            ans.add(queue.poll().num);
        }

        Collections.sort(ans);
        return ans;
    }

    //Approach2
    //Blog - https://leetcode.com/problems/find-k-closest-elements/discuss/1854364/O(n)-or-constant-space-or-Java-or-with-image
    //Blog - https://leetcode.com/problems/find-k-closest-elements/discuss/1316003/Java-O(n)-Solution-oror-Two-Pointers-oror-97-Faster
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();         // A list to store the resultant subarray
        int low = 0;                                    // A var to point at the left half of the array
        int high = arr.length - 1;                      // A var to point at the right half of the array

        while(high - low >= k){                         // Traverse till the difference between 'high' and 'low' is not less than 'k'
            int distLow = Math.abs(arr[low] - x);       // Get the difference between 'x' and the element at index 'low' in 'distLow'
            int distHigh = Math.abs(arr[high] - x);     // Get the difference between 'x' and the element at index 'high' in 'distHigh'

            if(distLow <= distHigh)                     // Now, check if 'distLow' less than or equal 'distHigh' or not
                high--;                                 // If Yes, then move the right pointer i.e., decrease the value of 'high'
            else                                        // Else,
                low++;                                  // Move the left pointer i.e., increase the value of 'low'
        }
        while(low <= high)                              // After traversing the array, traverse another loop to get the resultant values
            list.add(arr[low++]);                       // And, keep adding those values to the resultant list

        return list;                                    // Finally, return the resultant list
    }
}

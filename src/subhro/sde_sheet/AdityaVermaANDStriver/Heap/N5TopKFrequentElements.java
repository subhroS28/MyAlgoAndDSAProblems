package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.*;

/**
 * Question - https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1/
 *            https://leetcode.com/problems/top-k-frequent-elements/
 *
 *  approach - 1. Using HashMap and then storing hashmap into arraylist/array and then sorting this and returning k elements
 *                 Time Complexity: O(d log d), where d is the count of distinct elements in the array. To sort the array O(d log d) time is needed.
 *                 Auxiliary Space: O(d), where d is the count of distinct elements in the array. To store the elements in HashMap O(d) space complexity is needed.
 *
 *             2. Using HashMap and then using Heap.
 *                 Time Complexity: O(k log d + d), where d is the count of distinct elements in the array.
 *                 To remove the top of priority queue O(log d) time is required, so if k elements are removed then O(k log d) time is required and to traverse the distinct elements O(d) time is required.
 *                 Auxiliary Space: O(d), where d is the count of distinct elements in the array.
 *                 To store the elements in HashMap O(d) space complexity is needed.
 *
 *  blog - https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 */
public class N5TopKFrequentElements {

    class Pair{
        int count;
        int num;
        Pair(int count, int num){
            this.count = count;
            this.num = num;
        }
    }

    //Using Priority Queue [Without Pair class]
    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> map.get(b) - map.get(a));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(entry.getKey());
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=queue.poll();
        }

        return ans;
    }

    //Using Priority Queue [Using Pair class]
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)-> b.count - a.count);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(new Pair(entry.getValue(), entry.getKey()));
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=queue.poll().num;
        }

        return ans;
    }

    //Sorting HashMap
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        Collections.sort(mapList, (m1, m2)-> m2.getValue()-m1.getValue());

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=mapList.get(i).getKey();
        }

        return ans;
    }
}

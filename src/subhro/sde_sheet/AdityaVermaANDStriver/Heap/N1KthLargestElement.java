package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.PriorityQueue;

/**
 * Question - https://leetcode.com/problems/kth-largest-element-in-an-array/
 *            https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/
 *            https://classroom.codingninjas.com/app/classroom/me/7995/content/121164/offering/1414614/problem/1638
 *
 * Blog - https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 *
 * Video - Adidya Verma/ Coding Ninja
 *
 * Approach - 1. Brute Force
 *             Take one element and compare with other elements and look for an element which is kth largest.
 *             TC - O(N^2) and SC - O(1)
 *
 *            2. Sorting the array and then searching the kth element.
 *             TC - O(NlogN) and SC - O(1)
 *
 *            3. [BEST OPTION] Using Heap/Priority Queue
 *              TC - O(NlogK) and SC - O(K)
 *
 *            NOTE - O(NlogK) is better than O(NlogN) as logK means here we are going for k depth but N means all the element
 */
public class N1KthLargestElement {

    //Using single loop
    int[] kLargest2(int[] arr, int n, int k) {
        PriorityQueue<Integer> helper = new PriorityQueue<>();

        int counter=0;
        for(int num : arr){
            counter++;
            helper.add(num);

            if(counter>k){
                helper.poll();
            }
        }

        int[] ans = new int[k];
        counter=k-1;
        while(!helper.isEmpty()){
            ans[counter--] = helper.poll();
        }

        return ans;
    }

    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> helper = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            helper.add(arr[i]);
        }

        for(int i=k;i<n;i++){
            if(helper.peek()<arr[i]){
                helper.poll();
                helper.add(arr[i]);
            }
        }

        int[] ans = new int[k];
        int counter=k-1;
        while(!helper.isEmpty()){
            ans[counter--] = helper.poll();
        }

        return ans;
    }
}

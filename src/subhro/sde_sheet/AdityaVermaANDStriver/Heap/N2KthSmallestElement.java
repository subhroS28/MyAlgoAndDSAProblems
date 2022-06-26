package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Question - https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1/
 */
public class N2KthSmallestElement {
    //Using single loop
    public static int kthSmallest2(int[] arr, int l, int r, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int counter=0;
        for(int num : arr){
            counter++;
            heap.add(num);

            if(counter>k){
                heap.poll();
            }
        }

        return heap.peek();
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<k;i++){
            heap.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i]<heap.peek()){
                heap.poll();
                heap.add(arr[i]);
            }
        }

        return heap.peek();
    }
}

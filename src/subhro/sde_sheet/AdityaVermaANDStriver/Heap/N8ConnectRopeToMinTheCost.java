package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Question - https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 */
public class N8ConnectRopeToMinTheCost {

    long minCost(long arr[], int n)
    {
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

        long minCost = 0;
        for(long num : arr){
            queue.add(num);
        }

        int size = queue.size();
        while(size>1){
            long cost = queue.poll() + queue.poll();
            queue.add(cost);
            minCost += cost;
        }
        return minCost;
    }

}

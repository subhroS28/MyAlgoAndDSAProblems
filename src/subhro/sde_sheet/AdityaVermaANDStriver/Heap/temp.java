package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class temp {
    public static void main(String[] args) {
        temp temp = new temp();
//        int[] arr = new int[]{5,19,8,1};
        int[] arr = new int[]{32,98,23,14,67,40,26,9,96,96,91,76,4,40,42,2,31,13,16,37,62,2,27,25,100,94,14,3,48,56,64,59,33,10,74,47,73,72,89,69,15,79,22,18,53,62,20,9,76,64};
        int i = temp.halveArray(arr);
        System.out.println("i is "+i);
    }
    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        double sum=0;
        for(int num : nums){
            sum += num;
            queue.add((double)num);
        }

        double reqSum = sum/2;

        int counter=0;
        while(sum>reqSum){
            counter++;
            double num = queue.poll();
            sum -= num/2;
            queue.add(num/2);
        }

        return counter;
    }
}

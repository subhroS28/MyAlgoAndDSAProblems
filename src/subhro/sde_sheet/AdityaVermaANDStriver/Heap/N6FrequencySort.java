package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Question - https://leetcode.com/problems/sort-array-by-increasing-frequency/
 *            https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
 *
 * Blog - https://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
public class N6FrequencySort {
    class Pair{
        int count;
        int num;
        Pair(int count, int num){
            this.count = count;
            this.num = num;
        }
    }

    //Without using Pair class
    public static int[] frequencySort2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> {
                    if(Objects.equals(map.get(a), map.get(b))){
                        return a - b;
                    }
                    return map.get(b) - map.get(a);
                }
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(entry.getKey());
        }

        int len = nums.length;
        int size = map.size();
        int[] ans = new int[len];
        int counter=len-1;
        for(int j=0; j<size; j++){
            int num = queue.poll();
            int count = map.get(num);
            for(int i=0; i<count; i++){
                ans[counter--] = num;
            }
        }
        return ans;
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)->{
            if(b.count==a.count){
                return b.num-a.num;
            }
            return a.count - b.count;
        });
        for(Map.Entry entry : map.entrySet()){
            queue.add(new Pair((int)entry.getValue(), (int)entry.getKey()));
        }

        int len = nums.length;
        int[] ans = new int[nums.length];
        int counter=0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int i=0;i<pair.count;i++){
                ans[counter++] = pair.num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3};

        frequencySort2(arr);
    }
}

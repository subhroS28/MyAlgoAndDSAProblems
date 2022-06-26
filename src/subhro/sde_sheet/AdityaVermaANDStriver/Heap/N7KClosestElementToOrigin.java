package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Question - https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Blog - https://www.geeksforgeeks.org/find-the-k-closest-points-to-origin-using-priority-queue/?ref=lbp
 *
 */
public class N7KClosestElementToOrigin {
    class Pair{
        int dist;
        int num;
        Pair(int dist, int num){
            this.dist = dist;
            this.num = num;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter=0;
        for(int[] point : points){
            map.put(counter++, getDistance(point));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)-> b.dist-a.dist);

        counter=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(new Pair(entry.getValue(), entry.getKey()));
            counter++;

            if(counter>k){
                queue.poll();
            }
        }

        int[][] ans = new int[k][];

        counter=0;
        while(!queue.isEmpty()){
            ans[counter++] = points[queue.poll().num];
        }

        return ans;
    }

    private int getDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }

    //Without using Pair class
    public int[][] kClosest2(int[][] points, int k) {
        int len = points.length;
        if(len<k){
            return new int[0][0];
        }

        int[][] ans = new int[k][];
        HashMap<int[], Integer> map = new HashMap<>();
        for(int[] point : points){
            int distanceFromOrigin = getDistance(point);
            map.put(point, distanceFromOrigin);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>( (a, b) -> map.get(b) - map.get(a));

        int counter=0;
        for(int[] point : points){
            counter++;
            queue.add(point);

            if(counter>k){
                queue.poll();
            }
        }

        counter=k-1;
        while (!queue.isEmpty()){
            ans[counter--] = queue.poll();
        }

        return ans;
    }
}

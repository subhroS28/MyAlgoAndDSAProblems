package subhro.sde_sheet.day23_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question - https://leetcode.com/problems/course-schedule/
 *
 * In this question we have to detect cycle in Directed graph. So, try solving using:-
 *      a. DFS
 *      b. BFS - KHAN's Algorithm. This will use Toposort
 *                i. Toposort using DFS
 *                ii. Toposort using BFS
 *
 * Video [For understanding question] - https://www.youtube.com/watch?v=EgI5nU9etnU&ab_channel=NeetCode
 */
public class MOSTIMP {
    public static void main(String[] args) {
        MOSTIMP mostimp =  new MOSTIMP();
//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1,0},{0,1}}; //False
        int numCourses = 20;
        int[][] prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}; //False
        System.out.print(mostimp.canFinish(numCourses, prerequisites));
        System.out.print(mostimp.canFinish2(numCourses, prerequisites));
    }

    //Using DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = formAdjacentList(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfsDetectCycle(i, visited, dfsVisited, adj)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfsDetectCycle(int vertex, boolean[] visited, boolean[] dfsVisited, ArrayList<ArrayList<Integer>> adj){
        visited[vertex] = true;
        dfsVisited[vertex] = true;

        for(int v : adj.get(vertex)){
            if(!visited[v]){
                if(dfsDetectCycle(v, visited, dfsVisited, adj)){
                    return true;
                }
            }else if(dfsVisited[v]){
                return true;
            }
        }
        dfsVisited[vertex] = false;
        return false;
    }

    //Using BFS - Khan's Algorithm
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = formAdjacentList(numCourses, prerequisites);

        for(ArrayList<Integer> edges :  adj){
            for(int v : edges){
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int counter=0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            counter++;

            for(int v : adj.get(curr)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.add(v);
                }
            }
        }

        return counter==numCourses;
    }


    private ArrayList<ArrayList<Integer>> formAdjacentList(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>(numCourses);

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] subList : prerequisites){
            adj.get(subList[0]).add(subList[1]);
        }
        return adj;
    }
}

package subhro.sde_sheet.day23_graph;

import java.util.*;
/**
 * Question - https://leetcode.com/problems/course-schedule-ii/submissions/
 *
 * Video [For understanding] - https://www.youtube.com/watch?v=Akt3glAwyfY&ab_channel=NeetCode
 */
public class MostImp2 {

    //Using Cycle detection and toposort using DFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = formAdjacentList(numCourses, prerequisites);
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];


        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfsCycleDetect(i, visited, stack, adj, dfsVisited)){
                    //That is cycle is detected
                    return new int[0];
                }
            }
        }

        int[] order = new int[numCourses];
        int counter = numCourses-1;
        while(!stack.isEmpty()){
            order[counter--] = stack.pop();
        }

        return order;
    }

    private boolean dfsCycleDetect(int vertex, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, boolean[] dfsVisited){
        visited[vertex] = true;
        dfsVisited[vertex] = true;

        for(int ev : adj.get(vertex)){
            if(!visited[ev]){
                if(dfsCycleDetect(ev, visited, stack, adj, dfsVisited)){
                    return true;
                }
            }else if(dfsVisited[ev]){
                return true;
            }
        }

        dfsVisited[vertex] = false;
        stack.add(vertex);

        return false;
    }

    //Using BFS
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = formAdjacentList(numCourses, prerequisites);
        int[] indegree = new int[numCourses];

        for(ArrayList<Integer> edges :  adj){
            for(int v : edges){
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0)
                queue.add(i);
        }

        int counter=0;
        int index = numCourses-1;
        int[] toposort = new int[numCourses];
        while (!queue.isEmpty()){
            int curr = queue.poll();
            toposort[index--] = curr;
            counter++;

            for(int v : adj.get(curr)){
                indegree[v]--;
                if (indegree[v]==0){
                    queue.add(v);
                }
            }
        }

        if(counter!=numCourses){
            return new int[0];
        }else{
            return toposort;
        }
    }


    private ArrayList<ArrayList<Integer>> formAdjacentList(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>(numCourses);

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        //As it is directed so only one direction will be there
        for(int[] subList : prerequisites){
            adj.get(subList[0]).add(subList[1]);
        }
        return adj;
    }
}

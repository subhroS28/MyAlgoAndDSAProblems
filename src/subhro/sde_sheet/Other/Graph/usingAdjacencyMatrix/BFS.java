package subhro.sde_sheet.Other.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question - Adjacency List - https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/
 *            Adjacency Matrix - https://classroom.codingninjas.com/app/classroom/me/7995/content/121170/offering/1414711/problem/1699
 *
 * TC FOR Adjacency List WILL BE O(V + 2E)
 * TC for Adjacency Matrix will be O(V^2)
 */
public class BFS {
    //Adjacency List
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> helper = new LinkedList<>();
        boolean[] isVisisted = new boolean[adj.size()];
        ArrayList<Integer> req = new ArrayList<>();
        isVisisted[0] = true;
        helper.add(0);

        while(!helper.isEmpty()){
            int currentNode = helper.poll();
            req.add(currentNode);

            ArrayList<Integer> edges = adj.get(currentNode);
            for(int i=0;i<edges.size();i++){
                if(!isVisisted[edges.get(i)]){
                    isVisisted[edges.get(i)] = true;
                    helper.add(edges.get(i));
                }
            }
        }

        return req;
    }

    //Adjacency Matrix
    public static ArrayList<Integer> printBFS(int[][] strg){
        boolean[] unVisited = new boolean[strg.length];
        ArrayList<Integer> req = new ArrayList<>();
        Queue<Integer> helper = new LinkedList<>();
        helper.add(0);

        while(!helper.isEmpty()){
            int currentNode = helper.poll();
            unVisited[currentNode] = true;
            req.add(currentNode);

            for(int i=0;i<strg[currentNode].length;i++){
                int node = strg[currentNode][i];
                if(node==1 && !unVisited[i]){
                    helper.add(i);
                }
            }
        }

        return req;
    }
}

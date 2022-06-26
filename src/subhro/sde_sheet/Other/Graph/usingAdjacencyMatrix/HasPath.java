package subhro.sde_sheet.Other.Graph;

/**
 * Question - https://leetcode.com/problems/find-if-path-exists-in-graph/
 *            https://classroom.codingninjas.com/app/classroom/me/7995/content/121170/offering/1414716/problem/1693
 *
 * Approach - Using BFS OR DFS
 *
 */

import java.util.LinkedList;
import java.util.Queue;
public class HasPath {

    public static boolean checkPathExists(int vertice1, int vertice2, int[][] strg){
        int len = strg.length;
        Queue<Integer> unVisited = new LinkedList<>();
        boolean[] visited = new boolean[len];
        unVisited.add(vertice1);

        while(!unVisited.isEmpty()){
            int currentNode = unVisited.poll();
            if(!visited[currentNode]){
                visited[currentNode] = true;

                for(int i=0;i<len;i++){
                    if(strg[currentNode][i]==1&&!visited[i]){
                        if(i==vertice2){
                            return true;
                        }
                        unVisited.add(i);
                    }
                }
            }
        }

        return false;
    }
}

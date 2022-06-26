package subhro.sde_sheet.Other.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GetPathBFS {
    public static ArrayList<Integer> getPathBFS(int[][] strg, int start, int end){
        boolean[] isVisited = new boolean[strg.length];
        Queue<Integer> pendingV = new LinkedList<>();
        HashMap<Integer, Integer> parentV = new HashMap<>();
        pendingV.add(start);
        isVisited[start] = true;
        parentV.put(start, -1);

        ArrayList<Integer> req = new ArrayList<>();
        while(!pendingV.isEmpty()){
            int curr = pendingV.poll();

            for(int i=0; i<strg[curr].length; i++){
                if(strg[curr][i]==1 && !isVisited[i]){
                    parentV.put(i, curr);
                    pendingV.add(i);
                    isVisited[i] = true;

                    if(i==end){
                        req.add(i);

                        int child = i;
                        while(parentV.containsKey(child)){
                            int parent = parentV.get(child);
                            if(parent==-1) break;
                            req.add(parent);
                            child = parent;
                        }
                        return req;
                    }
                }
            }
        }

        return null;
    }
}

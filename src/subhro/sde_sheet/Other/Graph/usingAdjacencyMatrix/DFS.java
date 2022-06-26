package subhro.sde_sheet.Other.Graph;

import java.util.ArrayList;

public class DFS {

    public static ArrayList<Integer> printDFS(int[][] strg){
        int len = strg.length;
        if(len==0) return new ArrayList<>();

        boolean[] isVisited = new boolean[len];
        return printDFSHelper(strg, isVisited, 0);
    }

    private static ArrayList<Integer> printDFSHelper(int[][] strg, boolean[] isVisited, int currentNode) {
        isVisited[currentNode] = true;
        ArrayList<Integer> req = new ArrayList<>();
        if(!isVisited[currentNode]){
            for(int i=0; i<strg[currentNode].length;i++){
                int val = strg[currentNode][i];

                if(val==1&&!isVisited[i]){
                    req.addAll(printDFSHelper(strg, isVisited, i));
                }
            }
        }

        return req;
    }

}

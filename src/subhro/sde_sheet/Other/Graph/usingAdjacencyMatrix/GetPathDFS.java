package subhro.sde_sheet.Other.Graph;

import java.util.ArrayList;

public class GetPathDFS {
    public static ArrayList<Integer> getPathDFS(int[][] strg, int start, int end, boolean[] isVisisted){
       if(start==end){
           ArrayList<Integer> req = new ArrayList<>();
           req.add(end);
           return req;
       }

       isVisisted[start] = true;
       for(int i=0;i<strg[start].length; i++){
           if(strg[start][i] ==1 && !isVisisted[i]){
               ArrayList<Integer> pathDFS = getPathDFS(strg, i, end, isVisisted);
               if(pathDFS!=null){
                   pathDFS.add(start);
                   return pathDFS;
               }
           }
       }

       return null;
    }
}

package subhro.sde_sheet.Other.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BFSAdjacencyMatrix {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
        String[] numbers = br.readLine().split("\\s");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        if(num1==0){
            return;
        }
        
        int[][] strg = new int[num1][num1];
        for(int i=0;i<num2;i++){
            String[] numbers2 = br.readLine().split("\\s");
            int num12 = Integer.parseInt(numbers2[0]);
            int num22 = Integer.parseInt(numbers2[1]);
            strg[num12][num22] = 1;
            strg[num22][num12] = 1;
        }
        printBFS(strg);
	}
    
    public static void printBFS(int[][] strg){
        boolean[] unVisited = new boolean[strg.length];

        //For traversing through all the connected graphs in this graph
        for(int i=0;i<strg.length;i++){
            if(!unVisited[i]){
                printBFSHelper(strg, i, unVisited);
            }
        }
    }
    
    public static void printBFSHelper(int[][] strg, int node, boolean[] unVisited){
        Queue<Integer> helper = new LinkedList<>();
        helper.add(node);
        
        while(!helper.isEmpty()){
            int currentNode = helper.poll();
            if(!unVisited[currentNode]){
                unVisited[currentNode] = true;
                System.out.print(currentNode+" ");
                for(int i=0;i<strg.length;i++){
                    if(strg[currentNode][i]==1){
                        helper.add(i);
                    }
                }
            }
        }
    }
    
}
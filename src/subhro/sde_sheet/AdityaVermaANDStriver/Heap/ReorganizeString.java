package subhro.sde_sheet.AdityaVermaANDStriver.Heap;

import java.util.*;

/**
 * Question - https://leetcode.com/problems/reorganize-string/
 */
public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.print(reorganizeString.reorganizeString("aab"));
    }
    public String reorganizeString(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int counter=0;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        // PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.add(entry.getKey());
        }

        StringBuilder req = new StringBuilder();
        char prev = queue.poll();
        req.append(prev);
        map.put(prev, map.get(prev)-1);
        // if(map.get(prev)==1){
        //     map.remove(prev);
        // }
        len--;
        while(!queue.isEmpty()){
            char ch = queue.poll();
            req.append(ch);
            len--;
            queue.add(prev);
            if(map.get(ch)==1){
                map.remove(ch);
                prev = ch;
                if(map.size()==1){
                    if(len>1)
                        return "";
                    else if(len==0)
                        return req.toString();
                }
            }else{
                map.put(ch, map.get(ch)-1);
                prev = ch;
            }
        }

        return req.toString();
    }
}

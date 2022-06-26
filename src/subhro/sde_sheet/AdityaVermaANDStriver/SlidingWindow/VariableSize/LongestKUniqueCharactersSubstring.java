package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.VariableSize;

import java.util.HashMap;

/**
 * Question - https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 *
 * Approach - Best Approach -> Use HashMap with Sliding window
 */
public class LongestKUniqueCharactersSubstring {
    public static void main(String[] args) {
//        String S = "aabacbebebe"; int K = 3; //out=7
//        String S = "aaaa"; int K = 2; //out=-1;
        String S = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        int K=5;
        int len = longestkSubstr(S, K);
        int len2 = longestkSubstr2(S, K);
        System.out.println("len is "+len+ " len2 is "+len2);
    }
    public static int longestkSubstr(String s, int k) {
        int len = s.length();
        if(len<k || k<=0){
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int res=-1;

        while (j<len){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else {
                map.put(ch, 1);
            }

            if(map.size()==k){
                res = Math.max(res, j-i+1);
            }else if(map.size()>k){
                char sChar = s.charAt(i);
                while(map.size()>k){
                    map.put(sChar, map.get(sChar)-1);
                    if(map.get(sChar)==0){
                        map.remove(sChar);
                    }
                    i++;
                    sChar=s.charAt(i);
                }
            }
            j++;
        }

        return res;
    }

    public static int longestkSubstr2(String s, int k) {
        int len = s.length();
        if(len<k){
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int uniqueChar = 0;
        int longest = -1;
        int i=0, j=0;
        while(j<len){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)){
                uniqueChar++;
            }

            map.put(ch, map.getOrDefault(ch, 0)+1);

            if(uniqueChar==k){
                longest = Math.max(longest, j-i+1);
            }else if(uniqueChar>k){
                char charAti = s.charAt(i);
                while(uniqueChar>k){
                    map.put(charAti, map.get(charAti)-1);
                    if(map.get(charAti)==0){
                        map.remove(charAti);
                        uniqueChar--;
                    }
                    i++;
                    charAti = s.charAt(i);
                }
            }
            j++;
        }

        return longest;
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.VariableSize;

import java.util.HashMap;

/**
 * Question - https://leetcode.com/problems/minimum-window-substring/
 *
 * Blog -  https://leetcode.com/problems/minimum-window-substring/discuss/1697870/Aditya-verma-java-solution
 *         https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 *
 * Video - https://www.youtube.com/watch?v=e1HlptlipB0&ab_channel=Pepcoding
 */
public class MinimumWindowSubstring {
    public static String minWindow(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();
        if(len1<len2){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<len2; i++){
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int uniqueChar = map.size();
        int i=0;
        int j=0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(j<len1){
            char ch = str.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    uniqueChar--;
                }
            }

            while(uniqueChar==0){
                int subStringLen = j-i+1;
                if(subStringLen<minLen){
                    minLen = subStringLen;
                    start = i;
                    end = j;
                }

                //Now we will remove those characters that can be removed
                char charAti = str.charAt(i);
                if(map.containsKey(charAti)){
                    int count = map.get(charAti);
                    map.put(charAti, count+1);
                    if(count==0){
                        uniqueChar++;
                    }
                }
                i++;
            }
            j++;
        }

        if(minLen!=0 && minLen!=Integer.MAX_VALUE){
            return str.substring(start, end+1);
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Minimum Window Substring for string "+s+" and "+"t is "+minWindow(s, t));
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.VariableSize;

import java.util.HashMap;

/**
 * Question - https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *            https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1/
 *
 * Approach - Best is using hashMap with sliding window
 *
 * Blog - https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 *        https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1500874/Java-or-TC%3A-O(N)-or-SC%3A-O(1)-or-Sliding-Window-using-HashMap-and-Two-Pointers
 *        https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet
 */
public class LongestSubstringWithoutRepeatingCharacters {
    static int longestSubstrDistinctChars(String s){
        int len=s.length();
        if (len <= 1) {
            return len;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, res=0;
        while(j<len){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                res = Math.max(res, map.size());

                //Now reseting the map
                //Clearing whole map is wrong
                //map.clear();

                //We should delete the previous instance of the duplicate char instead
                char charAti = s.charAt(i);
                while(charAti!=ch){
                    map.put(charAti, map.get(charAti)-1);
                    if(map.get(charAti)==0){
                        map.remove(charAti);
                    }
                    i++;
                    charAti = s.charAt(i);
                }
                map.put(charAti, map.get(charAti)-1);
                i++;
            }
            map.put(ch, 1);
            j++;
        }

        res = Math.max(res, map.size());

        return res;
    }
}

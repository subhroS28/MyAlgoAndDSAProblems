package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.Imp;

import java.util.HashMap;

/**
 * Blog - https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
 *
 * Question - https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 *            https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Video - https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5&ab_channel=AdityaVerma
 */
public class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
//        String txt = "forxxorfxdofr";
//        String pat = "for";
//        int output = 3;
        String txt = "aabaabaa";
        String pat = "aaba";
//        int output = 4;

        System.out.println("No. of anagram are : "+search(pat, txt));
    }

    static int search(String pat, String txt) {
        HashMap<Character, Integer> helper = new HashMap<>();
        int diffChar = 0;
        for(char ch : pat.toCharArray()){
            if(helper.containsKey(ch)){
                helper.put(ch, helper.get(ch)+1);
            }else{
                diffChar++;
                helper.put(ch, 1);
            }
        }

        int ans=0;
        int i=0;
        int j=0;
        while(j<txt.length()){
            char ch = txt.charAt(j);
            if(helper.containsKey(ch)){
                helper.put(ch, helper.get(ch)-1);

                if(helper.get(ch)==0){
                    diffChar--;
                }
            }

            if(j-i+1<pat.length()){
                j++;
            }else{
                if(diffChar==0){
                    ans++;
                }

                char ch2 = txt.charAt(i);
                if(helper.containsKey(ch2)){
                    int previousVal = helper.get(ch2);
                    helper.put(ch2, previousVal+1);

                    if(previousVal==0){
                        diffChar++;
                    }
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}

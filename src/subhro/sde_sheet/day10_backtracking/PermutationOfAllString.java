package subhro.sde_sheet.day10_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question - https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1/
 *
 * [Same question as that of N1Permutations]
 *
 * Blog - https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *
 */
public class N1PermutationOfAllString {
    //With extra space
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>();
        find_permutationHelper(S, S.length(), ans, "", new boolean[S.length()]);
        Collections.sort(ans);
        return ans;
    }

    private void find_permutationHelper(String s, int len, List<String> ans, String subRes, boolean[] path){
        if(subRes.length()==len){
            ans.add(subRes);
            return;
        }

        for(int i=0;i<len;i++){
            if(!path[i]) {
                path[i]=true;
                find_permutationHelper(s, len, ans, subRes + s.charAt(i), path);
                path[i]=false;
            }
        }
    }
}

package subhro.sde_sheet.day15_string;

/**
 * Question - https://leetcode.com/problems/implement-strstr/
 *            https://practice.geeksforgeeks.org/problems/implement-strstr/1
 *
 * Approach - 1. Naive - checking all the possible matching between 2 strings.
 *            Video - https://www.youtube.com/watch?v=TsxFvVy_5m0&ab_channel=AmellPeralta
 *                  or https://www.youtube.com/watch?v=H6_8wrk6lEw&ab_channel=CodeTree
 *            TC - O(N*M) and SC - O(1)
 *
 *            2. Using KMP Algorithm
 *            Video - https://www.youtube.com/watch?v=V5-7GzOfADQ&ab_channel=AbdulBari
 *                    https://www.youtube.com/watch?v=BXCEFAzhxGY&ab_channel=BackToBackSWE
 *                    [with solution] - https://www.youtube.com/watch?v=EL4ZbRF587g&ab_channel=StableSort
 *            TC - O(N+M) and SC - O(M). This is required to save the lookup table.
 *
 *            Blog - http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 *
 * Solution Blog - https://leetcode.com/problems/implement-strstr/discuss/1545167/Java-or-BruteForce-greater-TC%3AO(M*N)-SC%3A-O(1)-or-KMP-greater-TC%3A-O(M%2BN)-SC%3AO(N)or-Two-Solutions
 *
 */
public class KMPAlgoImplementStrStr {

    //Using KMP Algorithm
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2>len1) return -1;
        if(len1==0 || len2==0){
            return len2==0 ? 0 : -1;
        }

        int[] helper = prefixLen(needle);
        int i=0;
        int j=0;
        while(i<len1){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==len2){
                    return i-j;
                }
            }else{
                j=helper[j];
                if(j<0){
                    i++;
                    j++;
                }
            }
        }

        return -1;
    }

    private int[] prefixLen(String s){
        int[] helper = new int[s.length()+1];
        helper[0] = -1;
        helper[1] = 0;

        int prefixLen = 0;
        int index=1;
        while(index<s.length()){
            if(s.charAt(index)==s.charAt(prefixLen)){
                prefixLen++;
                index++;
                helper[index] = prefixLen;
            }else {
                if(prefixLen>0){
                    prefixLen = helper[prefixLen];
                }else{
                    index++;
                    helper[index]=0;
                }
            }
        }

        return helper;
    }

    //Naive Approach
    public int strStr1(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2>len1) return -1;
        if(len1==0 || len2==0){
            return len2==0 ? 0 : -1;
        }

        for(int i=0;i<=len1-len2;i++){
            int j;
            for(j=0;j<len2 && (i+j)<len1;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }

            if(j==len2){
                return i;
            }
        }

        return -1;
    }

}

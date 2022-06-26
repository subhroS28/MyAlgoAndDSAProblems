package subhro.sde_sheet.day15_string;

/**
 * Question - https://leetcode.com/problems/repeated-substring-pattern/
 *            https://practice.geeksforgeeks.org/problems/string-formation-from-substring2734/1#
 *
 * Video - https://www.youtube.com/watch?v=p92_kEjyJAo&t=387s&ab_channel=KnowledgeCenter
 *
 * Blog - https://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 */
public class KMPAlgoRepeatedSubstringPattern {
    public static void main(String[] args) {
        KMPAlgoRepeatedSubstringPattern rabinKarp = new KMPAlgoRepeatedSubstringPattern();
        System.out.println("Boolean value is "+rabinKarp.repeatedSubstringPattern("abaabaabaabaabaaba"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len==1){
            return false;
        }

        int[] lps = prefixLen(s);
        //If there is always a repetition or if one substring is repeated multiple time then
        //lps = (length of string)-(length of common substring)
        int lpsVal = lps[len];
        //Thus if lpsVal==0 that means last word is not of common substring thus false
        //2nd case means the (length of string) should be a multiple of (length of common substring) and if not then false
        return (lpsVal!=0)&&(len%(len-lpsVal)==0);
    }

    private int[] prefixLen(String s) {
        int len = s.length();
        int[] lps = new int[len+1];
        lps[0] = -1;
        lps[1] = 0;

        int i=1;
        int prefixLen=0;
        while(i<len){
            if(s.charAt(i)==s.charAt(prefixLen)){
                i++;
                prefixLen++;
                lps[i] = prefixLen;
            }else{
                if(prefixLen>0){
                    prefixLen = lps[prefixLen];
                }else{
                    i++;
                    lps[i] = 0;
                }
            }
        }

        return lps;
    }
}

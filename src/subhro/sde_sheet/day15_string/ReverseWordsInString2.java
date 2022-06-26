package subhro.sde_sheet.day15_string;

/**
 * Question - https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 *
 * Video - https://www.youtube.com/watch?v=tNNJWsVo748&ab_channel=ApniKaksha
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("After reversing -->"+reverseWords(s));
    }

    public static String reverseWords(String s) {
        int len = s.length();
        if(len==0){
            return s;
        }

        int i=len-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ') i--;

            if(i<0) break;

            int j=i;

            while(i>=0 && s.charAt(i)!=' ') i--;

            if(sb.length()==0){
                sb.append(s.substring(i+1, j+1));
            }else{
                sb.append(" "+s.substring(i+1, j+1));
            }
        }

        return sb.toString();
    }
}

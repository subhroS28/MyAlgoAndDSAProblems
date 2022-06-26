package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.Leetcode;

/**
 * Question - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Blog - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/517459/Easy-Sliding-window-Java-O(n)-beats-100
 */
public class NumOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println("Total is "+numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {
        int len = s.length();
        int j=0;
        int i=0;

        int[] arr = new int[3];
        int count=0;
        int res=0;

        while(i<len&&j<=len-3){
            char ch = s.charAt(i);
            arr[ch - 'a']++;

            if(arr[ch - 'a']==1){
                count++;
            }
            while(count==3){
                System.out.println("res is "+res);
                res += len - i;
                char preCh = s.charAt(j);
                arr[s.charAt(j) - 'a']--;
                if(arr[s.charAt(j) - 'a']==0){
                    count--;
                }
                j++;
            }
            i++;
            System.out.println("Main res is "+res+ " and i is "+i +" and j is "+j);

        }

        return res;
    }
}

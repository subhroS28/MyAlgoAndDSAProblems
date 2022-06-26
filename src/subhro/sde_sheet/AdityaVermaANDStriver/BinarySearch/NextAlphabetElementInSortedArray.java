package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Question12
 * Question - https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * Blog - https://www.geeksforgeeks.org/smallest-alphabet-greater-than-a-given-character/
 */
public class NextAlphabetElementInSortedArray {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int i=0;
        int j= len-1;
        int pos=0;
        while(i<=j){
            int mid = i + (j-i)/2;
            char ch = letters[mid];

            if(ch>target){
                pos = mid;
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return letters[pos];
    }

    public char nextGreatestLetter3(char[] letters, char target) {
        int len = letters.length;
        int i=0;
        int j= len-1;

        //Initializing is very important else it will give wrong answer
        char req = letters[0];
        while(i<=j){
            int mid = i+(j-i)/2;
            if(letters[mid]>target){
                req=letters[mid];
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return req;
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int len = letters.length;
        int i=0;
        int j= len-1;

        char req = letters[0];
        int charIndex = -1;
        while(i<=j){
            int mid = i+(j-i)/2;

            if(letters[mid]==target){
                //This below line would have worked if array does not contain duplicates
                //return letters[(mid+1)%len];
                i=mid+1;
            }else if(letters[mid]>target){
                if(charIndex==-1){
                    charIndex=mid;
                    req = letters[mid];
                    continue;
                }

                if(letters[mid]<req){
                    req = letters[mid];
                }
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return req;
    }
}

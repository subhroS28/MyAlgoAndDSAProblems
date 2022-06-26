package subhro.sde_sheet.AdityaVermaANDStriver.BinarySearch;

/**
 * Last question and the most interesting question
 *
 * Question - https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/
 *
 * Approach - [Note: - This approach will work for sorted as well as unsorted array.]
 *
 * Blog - https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 *
 */
public class AllocateMinNumberOfPages {

    public static int findPages(int[]A,int N,int M)
    {
        int sum=0;
        int max=0;
        for(int i : A){
            max=Math.max(max, i);
            sum += i;
        }

        int i=max;
        int j=sum;
        int ans=-1;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(isValid(A, N, M, mid)){
                ans = mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return ans;
    }

    static boolean isValid(int[]A,int N,int M, int val){
        int num=1;
        int sum=0;
        for(int i=0; i<N; i++){
            if(sum+A[i]<=val){
                sum += A[i];
            }else{
                num++;
                sum=A[i];
            }
        }

        if(num>M){
            return false;
        }else{
            return true;
        }
    }
}

package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.Imp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question - https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
 *
 * Blog - https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 *
 * Video - https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4&ab_channel=AdityaVerma
 */
public class FirstNegativeNumberInEveryWindowSizeK {
    public long[] printFirstNegativeInteger2(long arr[], int N, int k)
    {
        int len = arr.length;
        if(len==0){
            return arr;
        }

        long[] res = new long[N-k+1];
        Queue<Long> helper = new LinkedList<>();
        int i=0;
        int j=0;
        while(j<N){
            if(arr[j]<0){
                helper.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }else{
                if(helper.isEmpty()){
                    res[i]=0;
                }else{
                    long numb = helper.peek();
                    res[i]=numb;
                    //Remove element in queue if element is not needed
                    if(arr[i]==numb){
                        helper.poll();
                    }
                }
                i++;
                j++;
            }
        }

        return res;
    }


    //Using While Loop
    public long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        int len = arr.length;
        if(len==0){
            return arr;
        }

        long[] res = new long[arr.length-k+1];
        Deque<Long> helper = new LinkedList<>();
        int counter=0;

        int i=0;
        int j=0;
        while(j<N){
            if(arr[j]<0){
                helper.addLast(arr[j]);
            }

            if(j+1-i<k){
                j++;
            }else if(j+1-i==k){
                if(helper.isEmpty()){
                    res[counter++] = 0;
                }else{
                    long num = helper.getFirst();
                    res[counter++] = num;

                    //Now removing the ith number in helper
                    if(num == arr[i]){
                        helper.removeFirst();
                    }
                }

                i++;
                j++;
            }
        }

        return res;
    }

    //Using forLoop
    public long[] printFirstNegativeInteger1(long arr[], int N, int k)
    {
        if(arr.length==0){
            return arr;
        }

        Deque<Integer> helper = new LinkedList<>();
        long[] res = new long[arr.length-k+1];
        int count=0;

        int i=0;
        for(;i<k;i++){
            if(arr[i]<0){
                helper.addLast(i);
            }
        }

        for(;i<arr.length;i++){
            if(helper.isEmpty()){
                res[count++] = 0;
            }else{
                res[count++]=arr[helper.getFirst()];
            }

            while(!helper.isEmpty()&&helper.getFirst()<i-k+1){
                helper.removeFirst();
            }

            if(arr[i]<0){
                helper.addLast(i);
            }
        }

        if(helper.isEmpty()){
            res[count++] = 0;
        }else{
            res[count++]=arr[helper.getFirst()];
        }

        return res;
    }
}

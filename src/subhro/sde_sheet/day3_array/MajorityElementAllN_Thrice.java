package subhro.sde_sheet.Other.Array.MajorityElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Question - Print all the elements with occurrence more than n/3
 *
 * Question - https://leetcode.com/problems/majority-element-ii/
 *
 * Video - https://www.youtube.com/watch?v=1QybAZMCYhA&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=6&ab_channel=Pepcoding
 */
public class MajorityElementAllN_Thrice {

    /*
        Best Approach - Moris Voting Algo.
     */
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int num1 = -1;
        int num2 = -1;

        int len = nums.length;

        for(int i=0; i<len; i++){
            if(nums[i]==num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }else{
                if(count1==0){
                    count1 = 1;
                    num1 = nums[i];
                }else if(count2==0){
                    count2 = 1;
                    num2 = nums[i];
                }else{
                    count1--;
                    count2--;
                }
            }
        }

        //Now checking if frequency of num is more then len/3
        List<Integer> res = new ArrayList<>();
        // if(num1==-1&&num2==-1){
        //     return res;
        // }

        count1 = 0;
        count2 = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }
        }

        if(count1 > len/3){
            res.add(num1);
        }

        if(count2 > len/3){
            res.add(num2);
        }

        return res;
    }
}

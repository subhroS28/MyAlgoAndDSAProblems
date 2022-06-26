package subhro.sde_sheet.day4_hashing;

import java.util.*;

/*
    Question - https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1 or
               https://leetcode.com/problems/3sum/

    Approaches - a. Brute Force/ Naive Approach --> TC- O(N^3*logN) O(logN) for set to store unique value and SC- 0(1)
                 b. HashMap --> 0(N^2*logN) and SC - O(N) for HashMap
                    - https://leetcode.com/problems/3sum/discuss/1178326/Simple-Java-HashMap-Solution
                 c. Sorting + 2 pointer --> O(NlogN) + 0(N^2) = O(N^2) and SC - O(1)
                    - https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
                    - https://leetcode.com/problems/3sum/discuss/7399/Easiest-Java-Solution

     Video - https://www.youtube.com/watch?v=onLoX6Nhvmg&t=1s&ab_channel=takeUforward or
             https://www.youtube.com/watch?v=1IBgYGJqKP8&ab_channel=Pepcoding
     Blog - https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class ThreeSum {

    public static void main(String[] args) {
//        int a[] = new int[]{1, 2, 4, 3, 6};
//        int X = 10;
//        System.out.print(find3Numbers(a, a.length, 10));

//        int a[] = new int[]{1, 4, 45, 6, 10, 8};
//        int X = 13;

        int a[] = new int[]{-1,0,1,2,-1,-4};
        System.out.print(twoPointerApproach(a, 0));

//        List<List<Integer>> lists = threeSum2(a, 0);
//
//        for (List<Integer> list : lists){
//            System.out.println(list.toString());
//        }
    }

    //Brute Force
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;

        List<List<Integer>> helper = new ArrayList<>();
        if(length==0){
            return helper;
        }

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> subList = new ArrayList<>();
        int a = Integer.MIN_VALUE+1;
        for(int i=0; i<length-2;i++){
            if(nums[i]==a){
                continue;
            }
            for(int j=i+1;j<length-1;j++){
                for(int k=j+1; k<length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        a = nums[i];

                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        set.add(subList);

                        subList = new ArrayList<>();
                    }
                }
            }
        }

        for(List<Integer> list: set){
            helper.add(list);
        }

        return helper;
    }

    //Little Better
    //Using HashMap
    public static List<List<Integer>> threeSum2(int[] nums, int X) {
        int length = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        if(length==0){
            return result;
        }

        HashMap<Integer, Integer> helper = new HashMap<>();
        List<Integer> subList = new ArrayList<>();

        for(int i : nums){
            if(helper.containsKey(i)){
                helper.put(i, helper.get(i)+1);
            }else{
                helper.put(i, 1);
            }
        }

        for(int i=0;i<length-1;i++){
            int requiredSum = X - nums[i];
            helper.put(nums[i], helper.get(nums[i])-1);

            for(int j=i+1;j<length;j++){
                helper.put(nums[j], helper.get(nums[j])-1);
                if(helper.containsKey(requiredSum-nums[j])){
                    if(helper.get(requiredSum-nums[j])<1){
                        continue;
                    }
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(requiredSum-nums[j]);

                    result.add(subList);
                    subList = new ArrayList<>();
                    continue;
                }
                helper.put(nums[j], helper.get(nums[j])+1);
            }
            helper.put(nums[i], helper.get(nums[i])+1);
        }

        return result;
    }

    //Using 2 pointer approach
    public static List<List<Integer>> threeSum3(int[] A, int X) {
        int len = A.length;
        List<List<Integer>> required = new ArrayList<>();

        if(A.length<=2){
            return required;
        }

        Arrays.sort(A);
        for(int i=0;i<len-2;i++){
            if(i!=0 && A[i]==A[i-1]){
                continue;
            }

            int val = A[i];
            List<List<Integer>> subList = twoSum(A, i+1, len-1, X-val);
            for(List<Integer> innerList: subList){
                innerList.add(0, val);
                required.add(innerList);
            }
        }

        return required;
    }

    private static List<List<Integer>> twoSum(int[] arr, int start,int end, int target) {
        int i=start;
        int j=end;
        int currentSum=0;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();

        while(i<j){
            if(res.size()>0 && arr[i]==arr[i-1]){
                i++;
                continue;
            }

            currentSum = arr[i];
            if(target-currentSum>arr[j]){
                i++;
            }else if(target-currentSum<arr[j]){
                j--;
            }else{
                subRes.add(arr[i]);
                subRes.add(arr[j]);
                res.add(subRes);
                subRes = new ArrayList<>();

                i++;
                j--;
            }
        }

        return res;
    }


    //Below are other question variations

    //This will return number of triplets
    public static int tripletSum(int[] arr, int num) {
        int res = 0;
        Arrays.sort(arr);
        res = twoPointerApproach(arr, num);
        return res;
    }

    public static int twoPointerApproach(int[] arr, int num) {
        int res=0;

        //Here we are setting boundary to len-2 because as 3 elements are there so first Element can go
        // till 3rd last position
        for(int i=0;i<arr.length-2;i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int requiredDiff = num-arr[i];
                if(arr[j]+arr[k]==requiredDiff){
                    if(arr[k-1]==arr[k]&&j<k){
                        if(arr[j]==arr[k]){
                            int m = k-j+1;
                            res += (m*(m-1))/2;
                            break;
                        }

                        int start = j+1;
                        int end = k-1;

                        while(start<=end && arr[j]==arr[start]){
                            start++;
                        }

                        while(end>=start && arr[k]==arr[end]){
                            end--;
                        }

                        int f1=start-j;
                        int f2=k-end;
                        res += f1*f2;
                        j=start;
                        k=end;

                    }else if(arr[j+1]==arr[j]&&j<k){
                        j++;
                        res++;
                    }else{
                        j++;
                        res++;
                    }
                }else if(arr[j]+arr[k]>requiredDiff){
                    k--;
                }else if(arr[j]+arr[k]<requiredDiff){
                    j++;
                }
            }
        }

        return res;
    }

    //Question - https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
    //In this we have to check if any 3sum number exists or not
    public static boolean find3Numbers(int A[], int n, int X) {
        Arrays.sort(A);

        int len = A.length;
        for(int i=0; i<len-2; i++){
            int req = X - A[i];

            if(req<0){
                //Because values will always be from 1 to 10^5 as mentioned in constraints
                break;
            }

            int j = i+1;
            int k= len-1;

            while(j<k){
                if(req-A[j]<0){
                    break;
                }

                if(A[k]<(req-A[j])){
                    j++;
                }else if(A[k]>(req-A[j])){
                    k--;
                }else{
                    return true;
                }
            }
        }

        return false;
    }

}

class Solution {
    public int lowerB(int[] arr , int n ){
         int st= 0, end = arr.length-1;
         int ans = arr.length;

         while( st<=end){
            int mid = (st+end)/2;

            if(arr[mid] >= n ){
                ans = mid;
                end = mid - 1;
            }else {
                st = mid+1;
            }
        }
        return ans;
    }
    public int upperB(int[] arr , int n ){
         int st= 0, end = arr.length-1;
         int ans = arr.length;

         while( st<=end){
            int mid = (st+end)/2;

            if(arr[mid] > n ){
                ans = mid;
                end = mid - 1;
            }else {
                st = mid+1;
            }
        }
        return ans;
    }
    public int maximumCount(int[] nums) {
       int FirstNonNeg = lowerB(nums, 0);  //>=0
       int FirPos = upperB(nums,0);      //>0
        
        int neg = FirstNonNeg;
        int pos = nums.length - FirPos;

        return Math.max(neg,pos);

        
    }

}
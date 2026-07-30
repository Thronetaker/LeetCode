class Solution {
    public int robUtil(int[] nums, int st , int end){
        long prev2 = 0;
        long prev  = 0;
         for(int i = st ;i<= end ; i++){
            long curr = Math.max( nums[i] + prev2 ,prev );
            prev2 = prev;
            prev = curr;

        }
        return (int)prev;

    }
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        return (int)Math.max( robUtil(nums, 0,n-2), robUtil(nums, 1,n-1));
    }
}
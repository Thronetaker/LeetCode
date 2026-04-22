class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return sub(nums, k ) - sub(nums, k-1);
    }
    private int sub(int[] nums, int k) {
        int  n = nums.length;

        int left  = 0 , cnt = 0 ;
        Map<Integer , Integer > freq = new HashMap<>();

        for(int r = 0 ; r<n ;r++ ){
            freq.put( nums[r], freq.getOrDefault( nums[r], 0)+1);

            while( freq.size() > k ){
                freq.put( nums[left] , freq.get( nums[left]) - 1 );
                if( freq.get( nums[left]) == 0) freq.remove( nums[left]);
                left++;
            }

            cnt+= r- left + 1;


        }
        return cnt;
    }
}
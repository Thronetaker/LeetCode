class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0 , zerocnt = 0, n = nums.length,maxLen = 0;

        for(int r = 0 ; r < n ; r++){

            if(nums[r]==0)  zerocnt++;

            if(zerocnt > k){
                if( nums[l] == 0) zerocnt--;
                l++;
            }

            maxLen = Math.max( maxLen, r-l+1);
        }

        return maxLen;
    }
}
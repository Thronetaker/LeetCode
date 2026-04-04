class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n==0) return 0;
        int x ,cnt=0;
        int longest = Integer.MIN_VALUE;

        Set<Integer> st = new HashSet<>();
          for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        for(int it : st){
            
            if(!st.contains(it-1)){
                cnt = 1 ;
                x = it;

                while( st.contains(x+1)){
                    x++;
                    cnt++;
                }

                longest = Math.max(longest,cnt);

            }
        }

        return longest ;
    }
}
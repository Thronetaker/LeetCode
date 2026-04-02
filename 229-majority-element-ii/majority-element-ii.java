class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = Integer.MIN_VALUE ,ele2 = Integer.MIN_VALUE;
        int cnt1 = 0,cnt2 = 0;
        int n = nums.length;

        for(int  i = 0;i< n ;i++){
            if( cnt1 == 0 && ele2!= nums[i]){
                ele1 = nums[i];
                cnt1++;
            }else if( cnt2 == 0 && ele1 != nums[i]){
                ele2 = nums[i];
                cnt2++;
            }else if(  nums[i]==ele2){
                cnt2++;
            }else if(  nums[i]==ele1){
                cnt1++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

         cnt1 = 0 ;
         cnt2 = 0;
        int app = n/3+1;

        for(int i = 0;i<n ;i++){
            if(nums[i]==ele1)  cnt1++;
            if( nums[i]==ele2)  cnt2++;
        }

        List<Integer> l = new ArrayList<>();
        if(cnt1 >= app){
            l.add(ele1);
        }
        if(cnt2 >= app && ele1!=ele2) l.add(ele2);

        return l;

    }
}
class Solution {
    public int last(int[] nums, int target, int n ){
        int endIdx = -1;
        int st = 0 , end = n-1;

        while(st<= end){
            int mid = st +(end-st)/2;
            if (nums[mid] == target ){
                endIdx = mid;
                st = mid+1;
            }else if( nums[mid] > target ){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return endIdx;
    }
     public int first(int[] nums, int target, int n ){
        int stIdx = -1 ;
        int st = 0 , end = n-1;

        while(st<= end){
            int mid =  st +(end-st)/2;
            if (nums[mid] == target ){
                stIdx = mid;
                end = mid-1;;
            }else if( nums[mid] > target ){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return stIdx;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        return new int[]{first(nums, target , n ), last(nums, target , n )};
    }
}
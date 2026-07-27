class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        for(int num : nums){
            if( temp.isEmpty() || num > temp.get( temp.size()-1)){
                temp.add(num);
            }else{
                int idx = lowerBound(temp, num);
                temp.set( idx, num);
            }
        }

        return temp.size();
    }

    public int lowerBound(List<Integer> temp, int target){
        int l = 0, r = temp.size() -1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(temp.get(mid) < target){
                l = mid + 1;
            }else{
                r = mid ;
            }
        }
        return l;
    }
}
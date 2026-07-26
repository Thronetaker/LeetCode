class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++){
            map.put( nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        List<Integer> bucket[] = new List[nums.length+1];
        //bucket[i] i is the number , & itsvalue is freq
        for( Map.Entry<Integer, Integer> set : map.entrySet()){
            int freq = set.getValue();
            if( bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add( set.getKey());
        }

        int idx = 0;
        int res[] = new int[k];
        for(int i = bucket.length - 1; i>=0 && idx < k ;i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[idx++] = num;
                    if( idx == k ) break;
                }
            }
        }
   
        return res;
        
    }
}
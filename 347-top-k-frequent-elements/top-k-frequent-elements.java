class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++){
            map.put( nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for( Map.Entry<Integer, Integer> set : map.entrySet()){
            minheap.offer(new int[]{ set.getKey(), set.getValue() });
            if(minheap.size() > k){
                minheap.poll();
            }
        }

        int res[] = new int[k];
        for( int i = k-1; i>=0;i--){
            res[i] = minheap.poll()[0];
        }
        return res;
        
    }
}
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap =  new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones){
            maxheap.add(n);
        }

        while( maxheap.size() > 1){
            int x = maxheap.poll();
            int y = maxheap.poll();
            if(x!=y) maxheap.add( x-y);
            
        }

        return maxheap.size() == 0 ? 0: maxheap.poll();

    }
}
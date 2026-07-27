class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put( ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
        for(int x  : map.values()){
            heap.offer(x);
        }
        
        int time = 0 ;
        while( !heap.isEmpty() ){
            

            List<Integer> temp = new ArrayList<>();
            int i = 0;     //no . of taskks
            int cycle = n+1;  
            while( i< cycle && !heap.isEmpty() ){
                int cnt = heap.poll();

                cnt-- ;
                if(cnt > 0) temp.add(cnt);

                time++;
                i++;
            }

            for(int num : temp){
                heap.offer(num);
            }

            if (!heap.isEmpty()) {
                time += (cycle - i);
            }
        }

        return time;


    }
}
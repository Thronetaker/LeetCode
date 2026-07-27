class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for( char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<int []> heap = new PriorityQueue<>( (a,b) -> b[1] - a[1]); //maxheap
        for( Map.Entry<Character, Integer> entry : map.entrySet() ){
            int freq = entry.getValue();
            char c =  entry.getKey();
            heap.offer(new int[]{c,freq});
        }
        if(heap.peek()[1] > (s.length()+1)/2) return  "";
        StringBuilder ans = new StringBuilder();

        while ( !heap.isEmpty()){
            int[] curr = heap.poll(); 
            if( ans.length() == 0 || ans.charAt( ans.length() -1 ) != (char)curr[0]){
                    ans.append((char)curr[0]);
                    curr[1]--;
                    if( curr[1] > 0) heap.offer(curr);
            }else{
                if(heap.isEmpty()) return "";

                int[] next = heap.poll();
                ans.append((char)next[0]);
                next[1]--;
                if( next[1] > 0) heap.offer(next);
                heap.offer(curr);
            }
            
        }

        return ans.toString();

    }
}
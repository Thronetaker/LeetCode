class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for( char ch : s.toCharArray()){
            freq.put( ch, freq.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<int []> maxHeap = new PriorityQueue<>( (a,b) -> b[1]-a[1]);
        // char , freq
        for( Map.Entry<Character,Integer>  entry : freq.entrySet()){
            maxHeap.add( new int[]{ entry.getKey(), entry.getValue()});
        }

        StringBuilder sb = new StringBuilder();
        while( !maxHeap.isEmpty()){
            int curr[] = maxHeap.poll();
            for(int i = 0 ; i< curr[1]; i++) sb.append((char) curr[0]);

        }

        return sb.toString();

    }
}
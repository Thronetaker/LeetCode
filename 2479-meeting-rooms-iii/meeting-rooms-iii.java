class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>(); //minheap
        //( endTime, roomnumber)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])); //minheap
        Arrays.sort(meetings, (a, b )-> a[0] - b[0]);

        int cnt[] = new int[n];
        for(int i  = 0 ; i< n ; i++){
            availableRooms.offer(i);
        }
        
        int lstTime = -1;
        for(int meeting[] : meetings){
             long start = meeting[0], end = meeting[1];

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                cnt[room]++;
                busyRooms.offer(new long[]{end, room});
            } else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + (end - start);
                int room = (int) earliest[1];
                cnt[room]++;
                busyRooms.offer(new long[]{newEnd, room});
            }
            
        }
        int maxroom = 0;
        for(int i = 1 ;i<n ;i++){
            if( cnt[i] > cnt[maxroom]) maxroom = i;
        }
        return maxroom;

    }
}
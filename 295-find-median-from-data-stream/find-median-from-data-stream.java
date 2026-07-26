class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if( maxHeap.size() > minHeap.size()) return (double)maxHeap.peek();
        return ( maxHeap.peek() + (double)minHeap.peek()) /2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int row  = matrix.length,col  = matrix[0].length;
        for(int i = 0 ; i< row ;i++){
            for(int j = 0 ; j < col ;j++){
                minHeap.offer(matrix[i][j]);
                if(minHeap.size() > k) minHeap.poll();
            }
        }

        return minHeap.peek();


    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int  n = numCourses;
        List<Integer>[] adj = new ArrayList[n];
        int inDegree[] =  new int[n];

        for(int i = 0 ; i<n ; i++){
            adj[i] =  new ArrayList<>();
        }
        for( int arr[] : prerequisites) {
            int dest = arr[0];
            int src = arr[1];
            inDegree[dest]++;
            adj[src].add(dest);
        }
       
       Queue<Integer> q = new LinkedList<>();
       int cnt = 0 ;
        for( int i = 0 ;i< n ; i++){
            if( inDegree[i] == 0 ) q.add(i);
        }

        while( !q.isEmpty()){
            int v = q.peek();
            q.remove();
            cnt++;
            for(int i = 0 ; i < adj[v].size() ; i++){
                int neigh = adj[v].get(i);
                inDegree[neigh]--;
                if( inDegree[neigh] == 0 ) q.add(neigh);
            }
        }

        return cnt == n ;
    }
}
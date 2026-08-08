class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
       ArrayList<Integer> res = new ArrayList<>();
        for( int i = 0 ;i< n ; i++){
            if( inDegree[i] == 0 ) q.add(i);
        }

        while( !q.isEmpty()){
            int v = q.peek();
            q.remove();
            res.add(v);
            for(int i = 0 ; i < adj[v].size() ; i++){
                int neigh = adj[v].get(i);
                inDegree[neigh]--;
                if( inDegree[neigh] == 0 ) q.add(neigh);
            }
        }

        if (res.size() == n){
            return res.stream().mapToInt(Integer::intValue).toArray();
        }else{
            return new int[0];
        }
    }
}
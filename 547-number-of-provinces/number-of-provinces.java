class Solution {

    private void dfs( List<List<Integer>> adj, boolean vis[] , int curr){
        vis[curr] = true;

        for( int neigh : adj.get(curr)){ //get() -> is geting an arrayList to loop on
              if(!vis[neigh]) {
                dfs( adj, vis, neigh);
              }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = isConnected.length;
        for(int i = 0  ;  i< isConnected.length ; i++){
            adj.add(new ArrayList<>() );
        }

        for(int i  = 0; i < V ;i++){
            for(int j = 0 ; j< V ; j++){
                if( isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[V];
        int cnt = 0 ;
        for(int i = 0 ; i< V ; i++){
            if(!vis[i]){
                cnt++;
              dfs( adj, vis, i)  ;
            }
        }

        return cnt;
    }
}
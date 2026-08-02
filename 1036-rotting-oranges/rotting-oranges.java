class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair( int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }

    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int frshCnt = 0;
        for(int i = 0; i< m ; i++){
            for(int j =0 ; j<n ;j++){
                if( grid[i][j] == 2){
                    q.add( new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                if( grid[i][j] == 1) frshCnt++;
            }
        }

        int currT = 0;
        int cnt = 0 ;

        while( !q.isEmpty() ){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            currT = Math.max( t , currT);
            q.remove();
            int rx[] = { 0, 0, 1,-1};
            int cy[] = { 1,-1, 0,0};

            for(int i = 0; i< 4 ;i++){
                int nr = r + rx[i];
                int nc = c + cy[i];

                if( nr <0 || nc < 0  || nr > m-1 || nc > n-1 || vis[nr][nc] ==2 || grid[nr][nc]!=1) continue;

                q.add( new Pair(nr, nc , t + 1));
                vis[nr][nc] = 2;
                cnt++;

            } 

        }

        if(cnt!= frshCnt) return -1;
        return currT;

    }
}
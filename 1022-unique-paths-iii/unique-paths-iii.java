class Solution {
    int paths = 0;
    int row ,cols;
    public int uniquePathsIII(int[][] grid) {
        row = grid.length;
         cols = grid[0].length;
        int stR =0, stC = 0,empty = 0 ;

        for(int  i = 0 ; i< row ; i++){
            for(int j = 0 ; j< cols ;j++){
                if(grid[i][j] == 0) empty++;
                else if( grid[i][j] == 1){
                    stR = i;
                    stC = j;
                }
            }
        }

        dfs( grid, stR, stC, empty + 1);
        return paths;
        
    }

    public void dfs(int grid[][], int r, int c, int rem){
        if( r <0 || r >= row || c < 0 || c >= cols || grid[r][c]==-1) return;

        if( grid[r][c] == 2){ ///reached end
           if(rem == 0 ){  // all empty path walked
             paths++;

           }
           return;

        }

        int temp = grid[r][c];
        grid[r][c] = -1 ; //to mark it visited or it cant be visited again in the path


        //possibl paths
        dfs(grid, r + 1, c,rem -1);
        dfs(grid, r - 1, c,rem -1);
        dfs(grid, r , c+1,rem -1);
        dfs(grid, r , c -1,rem -1);

        // on returning . unvisit the current cell
        grid[r][c] = temp;
    }
}
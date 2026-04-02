class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean first_cell = false;

        // I use the first row and first column as markers to track which rows and columns need to be set  to zero. Since matrix[0][0] is shared, I use a separate variable to track the first column. Then I traverse the matrix in reverse order to avoid overwriting the markers before using them

        for(int i = 0 ;i < row; i++){
            if( matrix[i][0] == 0)  first_cell = true;
            // j starting from 1 becoz we r skipping Oth colm 
            // n using it as marker 

            for(int j  = 1 ;j< col ;j++){
                if(matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for(int i = row-1 ; i>=0;i--){
            for(int j = col-1 ; j>=1; j--){
                if(matrix[i][0]== 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }

            if(first_cell) matrix[i][0] =0 ;
        }
    }
}
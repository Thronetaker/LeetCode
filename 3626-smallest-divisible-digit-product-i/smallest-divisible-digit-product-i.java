class Solution {
    public int smallestNumber(int n, int t) {
        int x = n, ans = n;
        

        while(true){
            double p = 1;
            while(x>0 ){
                int rem = x%10;
                x = x/10;
                p*= rem;
            }

            if( p % t == 0) break;
            x = ++ans;

        }

        return ans;
    }
}
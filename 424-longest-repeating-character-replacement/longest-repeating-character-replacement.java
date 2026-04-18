class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0 , r =0, maxcnt =0, maxlen = 0;

        int hash[] = new int[26];

        while( r< s.length()){

            hash[ s.charAt(r) - 'A']++;

            maxcnt = Math.max( maxcnt ,hash[ s.charAt(r) - 'A'] );

            if( (r-l+1 - maxcnt) > k  ){
                hash[ s.charAt(l) - 'A']--;
                l++;
            }

            maxlen = Math.max( maxlen, r-l+1);
            r++;

        }

        return maxlen;
    }
}
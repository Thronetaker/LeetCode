class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // stu wants
        Arrays.sort(s); // coookie size

        int gIdx = 0 ;
        int sIdx = 0;

        while( gIdx < g.length && sIdx < s.length){

            if(  s[sIdx] >= g[gIdx] ){ //stu satisfied
                  gIdx++;        //move to next stu
            }

            sIdx++;
        }

        return gIdx;
    }
}
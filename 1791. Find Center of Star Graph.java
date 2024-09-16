class Solution {
    public int findCenter(int[][] edges) {
        int x1,x2,x3,x4;
        x1 = edges[0][0];
        x2 = edges[0][1];
        x3 = edges[1][0];
        x4 = edges[1][1];
        if(x1==x3 || x1==x4){
            return x1;
        }
        return x2;
    }
}
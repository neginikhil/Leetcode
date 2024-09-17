class tuple {
    public int first;
    public int second;
    public int third;

    public tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n==1){
            if(grid[0][0] == 1){
                return -1;
            }
            return 1;
        }
        if(grid[0][0] == 1){
                return -1;
        }
        Queue<tuple> q = new LinkedList<>();
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 1;
        q.add(new tuple(1, 0,0));
        int dr[] = {1,-1,0,0,-1,1,-1,1};
        int dc[] = {0,0,1,-1,1,1,-1,-1};
        while(!q.isEmpty()){
            tuple it = q.peek();
            q.remove();
            int distance = it.first;
            int r = it.second;
            int c = it.third;
            for(int i=0;i<8;i++){
                int newr = r+dr[i];
                int newc = c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc] == 0 && distance+1 < dist[newr][newc]){
                    dist[newr][newc] = distance + 1;
                    q.add(new tuple(1+distance, newr, newc));
                }
            }
        }
        if(dist[n-1][m-1] != Integer.MAX_VALUE){
            return dist[n-1][m-1];
        }
        return -1;
    }
}
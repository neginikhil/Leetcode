// DFS Solution

class Solution {
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        return;
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid == null || rows == 0){
            return 0;
        }
        int cnt = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
}




// BFS Solution

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid == null || rows == 0){
            return 0;
        }
        int cnt = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        int x = temp[0];
                        int y = temp[1];
                        if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y] == '0'){
                            continue;
                        }
                        grid[x][y] = '0';
                        for(int[] dir : directions){
                            int dx = x + dir[0];
                            int dy = y + dir[1];
                            if(dx>=0 || dx<rows || dy>=0 || dy<cols || grid[x][y] == '1'){
                                q.add(new int[]{dx,dy});
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
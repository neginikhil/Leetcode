class Solution {    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        if(q.isEmpty()){
            return -1;
        }
        int mins = -1;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size --> 0){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int[] dir : direction){
                int i = x + dir[0];
                int j = y + dir[1];
                if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==1){
                    grid[i][j]=2;
                    fresh--;
                    q.add(new int[]{i,j});
                }
            }
            }
            mins++;
        }
        if(fresh == 0){
            return mins;
        }
        return -1;
    }
}
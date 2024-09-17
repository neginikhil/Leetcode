class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(Integer x : adj.get(node)){
            if(vis[x] == 0){
                dfs(x,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis = new int[isConnected.length];
        int cnt = 0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
}
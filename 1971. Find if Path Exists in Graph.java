class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, int[] vis){
        if(src == dest){
            return true;
        }
        vis[src] = 1;
        for(int nbr : adj.get(src)){
            if(vis[nbr] == 0){
                if(dfs(adj, nbr, dest, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
       for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] vis = new int[n];
        return dfs(adj, source, destination, vis);
    }
}
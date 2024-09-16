class Solution {
    public void helper(int numCourses, List<Integer>[] adj, List<Integer> ans, int[] indegree){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            ans.add(temp);
            if(adj[temp] != null){
                for(int next : adj[temp]){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        q.add(next);
                    }
                }
            }
        }
        return;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            if(adj[v] == null){
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
            indegree[u]++;
        }
        List<Integer> ans = new ArrayList<>();
        helper(numCourses, adj, ans, indegree);
        if (ans.size() == numCourses) {
            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }
            return result;
        }

        return new int[0]; 
    }
}
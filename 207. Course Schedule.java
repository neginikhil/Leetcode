class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for(int[] i : prerequisites){
            int u = i[0];
            int v = i[1];
            if(adj[v] == null){
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
            indegree[u]++;
        }
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
        return (ans.size() == numCourses);
    }
}
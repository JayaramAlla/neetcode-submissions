class Solution {
    public boolean validTree(int n, int[][] edges1) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0;i< n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] edge: edges1){
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[n];
        if(!dfs(edges,0, -1,isVisited)){
            return false;
        }

        for(int i = 0;i< n; i++){
            if(!isVisited[i]){
                return false;
            }
        }
        return true;

    }

    boolean dfs(List<List<Integer>> edges,int current , int parent, boolean[] isVisited ){
        if(isVisited[current]){
            return false;
        }
        isVisited[current] = true;
        for(int edge : edges.get(current)){
            if(edge == parent){
                continue;
            }
            if(!dfs(edges,edge,current,isVisited)){
                return false;
            }
        }
        return true;
    }
}

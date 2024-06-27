class Solution {
    public int findCenter(int[][] edges) {
        if(edges == null || edges.length == 0){
            return -1;
        }
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            if(map.containsKey(edges[i][0])){
                return edges[i][0];
            } else if(map.containsKey(edges[i][1])){
                return edges[i][1];
            }
            
            map.put(edges[i][0], new ArrayList<>());
            map.put(edges[i][1], new ArrayList<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        return -1;
    }
}
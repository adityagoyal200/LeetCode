class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited = new int[numCourses];

        for (int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            map.putIfAbsent(course, new ArrayList<>());
            map.get(course).add(prereq);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(i, map, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] visited) {
        if (visited[course] == 1) {
            return false;
        }

        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;

        if (map.containsKey(course)) {
            for (int prereq : map.get(course)) {
                if (!dfs(prereq, map, visited)) {
                    return false;
                }
            }
        }

        visited[course] = 2;

        return true;
    }
}
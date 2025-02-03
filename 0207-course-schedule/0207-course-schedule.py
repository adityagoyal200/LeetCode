class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        graph = {}
        visited = [0] * numCourses

        for course, prereq in prerequisites:
            if course not in graph:
                graph[course] = []
            graph[course].append(prereq)

        def dfs(course):
            if visited[course] == 1:
                return False
            if visited[course] == 2:
                return True

            visited[course] = 1

            if course in graph:
                for prereq in graph[course]:
                    if not dfs(prereq):
                        return False

            visited[course] = 2
            return True

        for i in range(numCourses):
            if visited[i] == 0 and not dfs(i):
                return False

        return True

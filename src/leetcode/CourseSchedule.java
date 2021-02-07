package leetcode;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> sortedArray = new ArrayList();

        if(prerequisites.length == 0) {
            return false;
        }

        Map<Integer, Integer> nonSourceMap = new HashMap();
        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < numCourses; i++) {
            nonSourceMap.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++ ) {
            int parent = prerequisites[i][0]; int child = prerequisites[i][1];
            nonSourceMap.put(child, nonSourceMap.get(child) + 1);
            graph.get(parent).add(child);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : nonSourceMap.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while(!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedArray.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                nonSourceMap.put(child, nonSourceMap.get(child) - 1);
                if (nonSourceMap.get(child) == 0)
                    sources.add(child);
            }
        }

        if(sortedArray.size() != numCourses) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule schedule = new CourseSchedule();

        boolean canFinish = schedule.canFinish(2, new int[][]{{1, 0}});

        System.out.println(canFinish);
    }
}

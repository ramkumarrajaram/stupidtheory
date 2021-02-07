package leetcode;

import java.util.*;

class TopologicalSortString {

    public static List<String> sort(String[][] edges) {
        Set<String> stringSet = new HashSet<>();
        for (String[] edge : edges) {
            stringSet.addAll(Arrays.asList(edge));
        }

        int vertices = stringSet.size();

        List<String> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        HashMap<String, Integer> childrenMap = new HashMap<>();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        for (String vertex : stringSet) {
            childrenMap.put(vertex, 0);
            graph.put(vertex, new ArrayList<>());
        }

        for (String[] edge : edges) {
            String parent = edge[0], child = edge[1];
            childrenMap.put(child, childrenMap.get(child) + 1);
            graph.get(parent).add(child);
        }

        Queue<String> sources = new LinkedList<>();
        for (String vertex : childrenMap.keySet()) {
            if (childrenMap.get(vertex) == 0) {
                sources.add(vertex);
            }
        }

        while (!sources.isEmpty()) {
            String parent = sources.poll();
            sortedOrder.add(parent);
            List<String> children = graph.get(parent);
            for (String child : children) {
                childrenMap.put(child, childrenMap.get(child) - 1);
                if (childrenMap.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        String ram = "Ram";
        String sindhu = "Sindhu";
        String kuttiPaps = "kutti pappa";
        List<String> result = TopologicalSortString.sort(
                new String[][]{new String[]{ram, sindhu}, new String[]{ram, kuttiPaps}, new String[]{sindhu, kuttiPaps}});
        System.out.println(result);

//    List<Integer> result = TopologicalSortString.sort(4,
//            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
//    System.out.println(result);
//
//    result = TopologicalSortString.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
//        new int[] { 2, 1 }, new int[] { 3, 1 } });
//    System.out.println(result);
//
//    result = TopologicalSortString.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
//        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
//    System.out.println(result);
    }
}
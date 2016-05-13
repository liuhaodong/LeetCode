package leetcode;

import java.util.*;

/**
 * Created by haodongl on 3/1/16.
 * n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 */
public class MinHeightTree {
    public static void main(String[] args){
        MinHeightTree test = new MinHeightTree();
        int[][] edges = new int[5000][2];
        for(int i=0; i<4999; i++){
            edges[i][0] = i;
            edges[i][1] = i+1;
        }
        int[][] edges_2 = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        System.out.println(test.findMinHeightTrees(5000, edges));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if(n == 0) return result;
        if(n == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, List<Integer>> graph2 = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<n; i++){
            graph2.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i < edges.length; i++){
            graph2.get(edges[i][0]).add(edges[i][1]);
            graph2.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> farthestList = findFarthestVertex2(graph2, 0);
        Set<Integer> resultSet = new HashSet<Integer>();
        // for each farthest vertex, do a dfs and find longest pathes
        for(int start : farthestList){
            resultSet.addAll(bfsUtil(graph2, start));
        }
        for(int tmp : resultSet){
            result.add(tmp);
        }
        return result;
    }

    private List<Integer> bfsUtil(Map<Integer, List<Integer>> graph, int start){
        int[] predecessor = new int[graph.size()];
        int[] depth = new int[graph.size()];
        Arrays.fill(depth, -1);
        Arrays.fill(predecessor, -1);
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(start);
        int level = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int current = queue.removeFirst();
                depth[current] = level;
                for(int next : graph.get(current)){
                    if(depth[next] == -1) {
                        queue.add(next);
                        predecessor[next] = current;
                    }
                }
            }
        }
        int max = 0;
        for(int i=0; i<depth.length; i++){
            if(depth[i] > max) max = depth[i];
        }

        for(int i=0; i<depth.length; i++){
            if(depth[i] == max){
                int current = i;
                for(int j=0; j<(max -1)/2; j++){
                    current = predecessor[current];
                }
                result.add(current);
                if(max%2==0) result.add(predecessor[current]);
            }
        }
        return result;
    }

    private List<Integer> findFarthestVertex2(Map<Integer, List<Integer>> graph, int start){
        List<Integer> resultList = new ArrayList<Integer>();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(start);
        int[] depth = new int[graph.size()];
        Arrays.fill(depth, -1);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            for(int i=0; i<queue.size(); i++){
                int current = queue.removeFirst();
                depth[current] = level;
                for(int next : graph.get(current)){
                    if(depth[next] == -1) queue.add(next);
                }
            }
        }

        int max = 0;
        for(int i=0; i<depth.length; i++){
            if(depth[i] > max) max = depth[i];
        }
        for(int i=0; i<depth.length; i++){
            if(depth[i] == max) resultList.add(i);
        }
        return resultList;
    }
}

package leetcode;

import java.util.*;

/**
 * Created by haodongl on 2/13/16.
 */
public class LongestIncreasingPathMatrix {

//    public static void main(String[] args) {
////        int[] a1 = {7,6,1,1};
////        int[] a2 = {2,7,6,0};
////        int[] a3 = {1,3,5,1};
////        int[] a4 = {6,6,3,2};
//
//        int[] a1 = {3,4,5};
//        int[] a2 = {3,2,6};
//        int[] a3 = {2,2,1};
////        int[] a4 = {6,6,3,2};
//        int[][] test = {a1, a2, a3};
//        System.out.println(new LongestIncreasingPathMatrix().longestIncreasingPath(test));
//    }

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        if (matrix[0].length == 0) return 0;

        Map<Vertex, List<Vertex>> graph = new HashMap<Vertex, List<Vertex>>();
        int width = matrix[0].length;
        int length = matrix.length;

        Set<Vertex> sources = new HashSet<Vertex>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < width; j++) {
                Vertex vertex = new Vertex(i, j, matrix[i][j]);
                int currentValue = matrix[i][j];
                List<Vertex> neighbors = new ArrayList<Vertex>();
                boolean flag = true;
                if (i - 1 >= 0) {
                    if (matrix[i - 1][j] > currentValue) {
                        Vertex tmp = new Vertex(i - 1, j, matrix[i - 1][j]);
                        neighbors.add(tmp);
                    } else if (matrix[i - 1][j] < currentValue) {
                        flag = false;
                    }
                }
                if (i + 1 < matrix.length) {
                    if (matrix[i + 1][j] > currentValue) {
                        Vertex tmp = new Vertex(i + 1, j, matrix[i + 1][j]);
                        neighbors.add(tmp);
                    } else if (matrix[i + 1][j] < currentValue) {
                        flag = false;
                    }
                }
                if (j + 1 < matrix[0].length) {
                    if (matrix[i][j + 1] > currentValue) {
                        Vertex tmp = new Vertex(i, j + 1, matrix[i][j + 1]);
                        neighbors.add(tmp);
                    } else if (matrix[i][j + 1] < currentValue) {
                        flag = false;
                    }
                }
                if (j - 1 >= 0) {
                    if (matrix[i][j - 1] > currentValue) {
                        Vertex tmp = new Vertex(i, j - 1, matrix[i][j - 1]);
                        neighbors.add(tmp);
                    } else if (matrix[i][j - 1] < currentValue) {
                        flag = false;
                    }
                }
                if (flag) {
                    sources.add(vertex);
                }
                graph.put(vertex, neighbors);
            }
        }

        int max = 0;

        for (Vertex v : sources) {
            int tmp = findLongestPath(graph, v);
            if (max < tmp + 1) {
                max = tmp + 1;
            }
        }

        return max ;
    }

    public int findLongestPath(Map<Vertex, List<Vertex>> graph, Vertex start) {
        if (graph.get(start).size() == 0) {
            return 0;
        }

        Map<Vertex, Integer> depth = new HashMap<Vertex, Integer>();

        depth.put(start,0);
        List<Vertex> queue = new LinkedList<Vertex>();

        queue.add(start);
        int max = 0;
        while (queue.size()!=0){
            Vertex current = queue.remove(0);
            for(Vertex v : graph.get(current)){
                if(depth.containsKey(v) && depth.get(v) > depth.get(current) + 1){
                    continue;
                }else {

                    depth.put(v, depth.get(current)+1);
                    if(depth.get(v) > max){
                        max = depth.get(v);
                    }
                    queue.add(v);
                }
            }
        }
        return max;
    }

    class Vertex {
        int value;
        int i;
        int j;

        public Vertex(int i, int j, int value) {
            this.value = value;
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return 11 * i + 13 * j + 17 * value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Vertex) {
                Vertex cmp = (Vertex) obj;
                if (cmp.value == this.value && cmp.i == this.i && cmp.j == this.j) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

}

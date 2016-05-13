package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haodongl on 2/29/16.
 * 10
 [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
 */
public class CourseSchedule {
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        if(numCourses == 1) return new int[]{0};
        int[] isStartCourse = new int[numCourses];
        boolean[] isCourseTaken = new boolean[numCourses];
        Arrays.fill(isCourseTaken, false);

        // use adjacency matrix
        boolean[][] coursesGraph = new boolean[numCourses][numCourses];

        // find all start courses and construct a graph
        for(int i=0; i < prerequisites.length; i++){

            int startVertex = prerequisites[i][1];
            int endVertex = prerequisites[i][0];
            if(coursesGraph[startVertex][endVertex]) continue;
            coursesGraph[startVertex][endVertex] = true;
            isStartCourse[prerequisites[i][0]]++;
        }

        List<Integer> startVertexQueue = new LinkedList<Integer>();

        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<numCourses;i++){
            if(isStartCourse[i] == 0){
                startVertexQueue.add(i);
            }
        }

        // iterate through all possible start until the queue is empty
        while(!startVertexQueue.isEmpty()){
            int start = startVertexQueue.remove(0);
            result.add(start);
            dfsUtil(start, coursesGraph, isCourseTaken, isStartCourse, startVertexQueue);
        }

        int[] resultArray = new int[result.size()];

        for(int i=0; i< result.size() ; i ++){
            resultArray[i] = result.get(i);
        }

        // if all courses are taken, then can finish
        for(int i = 0; i < isCourseTaken.length; i++){
            if(!isCourseTaken[i]) return new int[0];
        }
        return resultArray;
    }

    private void dfsUtil(int start, boolean[][] graph, boolean[] visited, int[] isStartCourse, List<Integer> startVertexQueue){
        if(!visited[start]){
            visited[start] = true;

            // update edge count
            for(int j=0; j < graph[start].length; j++){
                if(graph[start][j] && !visited[j]){
                    isStartCourse[j]--;
                    if(isStartCourse[j] == 0){
                        startVertexQueue.add(j);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] test = { {5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        for(int i : new CourseSchedule().canFinish(10, test)){
            System.out.println(i);
        }
//        System.out.println(new CourseSchedule().canFinish(10, test));
    }
}

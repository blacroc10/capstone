//Q Course Schedular Order (Simple DAG)
//Real: Planning course completion order in a university
import java.util.*;
//Problem: given a course (0 to n-1) and prerequisites, return a valid order
public class SIT_401 {
    public static void main(String[] args) {

        //n---> number of nodes( 0 to n-1 )
        int n=4;
        
        //prerequisites---> edges (dependencies)
        //meaning: 0-->1, 0-->2, 1-->3, 2-->3
        int[][] prereq = {{1,0}, {2,0}, {3,1}, {3,2}}; 

        System.out.println(topoSort(n, prereq));

    }
    //function to perform topological sort using Kahn's algorithm (BFS)
    static List<Integer> topoSort(int n, int[][] prereq){
        //create graph using adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        //we create a graph like --> graph [[], [], [], []]

        //each index represents a node
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        //build graph + calculate in-degrees
        //for each pair {a,b}
        //b ---> a
        int[] inDegree = new int[n];
        for(int[] p : prereq){
            graph.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
            }

        //for input: n=4, prereq={{1,0}, {2,0}, {3,1}, {3,2}}
        //graph becomes: 0---[1,2}, 1---[3], 2---[3], 3---[]
        //inDegree becomes: [0,1,1,2]

        //queue for BFS
        Queue<Integer> q = new LinkedList<>();
        //add nodes with in-degree 0 to the queue
        for(int i=0; i<n; i++){
            //nodes with zero dependencies can be taken first
            if(inDegree[i] == 0){
                q.add(i);
                //queue initially --> 0
            }
        }

        //Result set to store the topological order
        List<Integer> topoOrder = new ArrayList<>();

        //main BFS loop
        while(!q.isEmpty()){ //run until all nodes are processed
            int node = q.poll();
            
            //add to result: this is valid next node in order
            topoOrder.add(node);

            //process neighbors, go through all nodes dependent on current node
            for(int nei : graph.get(node)){
                //reduce in-degree of neighbors
                inDegree[nei]--;
                //add new independent nodes
                // if no dependency left, add to queue
                if(inDegree[nei] == 0){
                    q.add(nei);
                }
            }

        }
        return topoOrder;

    }
}

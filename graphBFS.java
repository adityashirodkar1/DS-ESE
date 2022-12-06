import java.util.*;
class Graph{

    void addEdge(LinkedList<LinkedList<Integer>> grp,int u,int v){
        grp.get(u).add(v);
        grp.get(v).add(u);
    }

    void dfsSearch(int source,LinkedList<LinkedList<Integer>> grp){
        int count = 0;
        String dfsString = "";
        boolean visited[] = new boolean[grp.size()];
        int parent[] = new int[grp.size()];
        java.util.Stack<Integer> stk = new java.util.Stack<>();
        stk.add(source);

        System.out.println();
        visited[source] = true;
        parent[source] = -1;
        while(!stk.isEmpty()){
            int p = stk.pop();
            count++;
            dfsString += p;
            System.out.print("DFS - "+p+" ("+count+"|");
            for(int i: grp.get(p)){
                if(visited[i]!=true){
                    visited[i] = true;
                    stk.add(i);
                    parent[i] = p;
                    break;
                }
            }
            System.out.print(((2*grp.size())-(count)+1)+")");
            System.out.println();
        }
        System.out.println("DFS: "+dfsString);
    }

    void bfsSearch(int source, LinkedList<LinkedList<Integer>> grp){
        boolean[] visited = new boolean[grp.size()];
        // int[] parent = new int[grp.size()];
        int level = 0;
        String bfs = "";
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int p = queue.poll();
            if(visited[p]!=true){
                bfs += p;
                System.out.println("BFS: "+p+" level - "+level);
            }
            visited[source] = true;
            level++;
            for(int i: grp.get(p)){
                if(visited[i]!=true){
                    visited[i] = true;
                    System.out.println();
                    bfs += i;
                    System.out.println("BFS: "+i+" level - "+level);
                    queue.add(i);
                }
            }
        }
        System.out.println("BFS: "+bfs);
    }

    void displayGraph(LinkedList<LinkedList<Integer>> grp){
        System.out.println("Graph Representation in Adjacency List:");
        for(int i=0;i<grp.size();i++){
            System.out.print(i+"->");
            for(int v: grp.get(i)){
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }

}
public class graphBFS {
    public static void main(String[] args) {
        Graph dfs = new Graph();
        LinkedList<LinkedList<Integer>> grp = new LinkedList<LinkedList<Integer>>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vertices");
        int v = sc.nextInt();
        for(int i=0;i<v;i++){
            grp.add(new LinkedList<Integer>());
        }
        //int flag = 0;
        // while(flag==0){
            System.out.println("Enter edges:");
            int e = sc.nextInt();
            for(int i=0;i<e;i++){
                System.out.println("Enter source:");
                int s = sc.nextInt();
                System.out.println("Enter destination:");
                int d = sc.nextInt();
                dfs.addEdge(grp, s, d);
            }
            dfs.displayGraph(grp);
            System.out.println("What to do?\n1 - DFS\n2 - BFS");
            int key = sc.nextInt();
            if(key==1){
                System.out.println("Enter source for DFS Traversal:");
                int source = sc.nextInt();
                dfs.dfsSearch(source, grp);
            }
            else{
                System.out.println("Enter source for BFS Traversal:");
                int source = sc.nextInt();
                dfs.bfsSearch(source, grp);
            }
        // }
        sc.close();
    }
}

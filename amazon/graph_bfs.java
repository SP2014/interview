import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class GraphBFS{

    static void bfs(Graph g, int v, int s){
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int t = queue.poll();
            System.out.print(t+" ");
            Iterator<Integer> it = g.getAdj(t).listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
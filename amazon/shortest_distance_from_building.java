import java.util.Deque;
import java.util.LinkedList;

class ShortestDistanceFromBuilding{

    static int getShortestDistance(int[][] grid){
        int[][] distances = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];

        int numBuilding = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    helper(grid, distances, reach, i, j);
                    numBuilding+=1;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i< grid.length; i++)
          for(int j=0; j<grid[0].length; j++) if(grid[i][j] == 0 && reach[i][j] == numBuilding) result = Math.min(result, distances[i][j]);

        return result;  
    }

    static void helper(int[][] grid, int[][] distances, int[][] reach, int i, int j){
        int[][] dis = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        LinkedList<int[]> q = new LinkedList<int[]>();
        LinkedList<Integer> qDist = new LinkedList<Integer>();
        q.offer(new int[]{i,j});
        qDist.offer(1);
        while(!q.isEmpty()){
            int[] head = q.poll();
            int dist = qDist.poll();

            for(int k=0; k<4;k++){
                int r = head[0] + dis[k][0];
                int c = head[1] + dis[k][1];

                if(r >=0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c]==0){
                    grid[r][c] = -1;
                    q.offer(new int[]{r,c});
                    qDist.offer(dist+1);

                    reach[r][c]+=1;
                    distances[r][c]+=dist;
                }
            }
        }

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y< grid[0].length; y++){
                if(grid[x][y] == -1) grid[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(getShortestDistance(grid));
    }
}
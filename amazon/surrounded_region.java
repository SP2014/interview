import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Input: X X X X
 *        X O O X
 *        X X O X
 *        X O X X
 * Output: X X X X
 *         X X X X
 *         X X X X
 *         X O X X
 */
class SurroundedRegion{

    static void solve(char[][] board){
        if(board==null || board.length==0 || board[0].length==0) return;
        Queue<Integer> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    boolean surrounded = true;
                    List<Integer> pointsToChange = new ArrayList<>();
                    q.add(i*n+j);
                    while(!q.isEmpty()){
                        int point = q.poll();
                        pointsToChange.add(point);
                        int x = point/n;
                        int y = point%n;
                        for(int k=0; k < dir.length;++j){
                            int nextX = x + dir[j][0];
                            int nextY = y + dir[j][1];
                            if(nextX > 0 && nextX < m && nextY > 0 && nextY< n){
                                q.add(nextX*n+nextY);
                                visited[nextX][nextY] = true;
                            }else{
                                surrounded=false;
                            }

                        }
                    }

                    if(surrounded){
                        for(int p: pointsToChange){
                            board[p/n][p%n] = 'X';
                        }
                    }


                }
            }
        }
    }

}
import java.util.Arrays;

class RangeAddition {


    static int[] raddition(int n, int[][]updates){
        int[] res = new int[n];
        Arrays.fill(res, 0);
        for(int[] up: updates){
            int s = up[0];
            int e = up[1];
            int v = up[2];
            res[s]+=v;
            if(e+1 < n){
                res[e+1]-=v;
            }
        }

        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=res[i];
            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = raddition(5, new int[][]{{1,3,2},{2,4,3},{0,2,-2}});
        for(int r: res){
            System.out.print(r+" ");
        }
    }
}
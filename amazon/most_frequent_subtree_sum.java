import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MostFrequentSubtreeSum{

    static Integer val = new Integer(0);
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int solve(TreeNode root){
        if(root==null) return 0;
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        int s = root.val+leftSum+rightSum;
        int count = map.containsKey(s)? map.get(s) : 0;
        if(count==0){
            map.put(s, 1);
        }
        else{
            map.put(s, count+1);
        }

        val = Math.max(val, map.get(s));
        return s;
    }
    
    static int[] frequentSum(TreeNode root){
        if(root==null) return new int[0];
        solve(root);
        List<Integer> res = new ArrayList<>();
        for(Integer k: map.keySet()){
            if(map.get(k)==val){
                res.add(k);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0; i< res.size();++i){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        int[] res = frequentSum(root);
        for(int i=0; i< res.length;++i){
            System.out.print(res[i]+" ");
        }
    }
}
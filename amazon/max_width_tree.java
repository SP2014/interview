import java.util.HashMap;
import java.util.Map;

class MaxWidthTree{

    static int wmax = 0;
    static int maxWidth(TreeNode root){
        Map<Integer, Integer> record = new HashMap<>();
        travel(root, record, 0, 0);
        return wmax;
    }

    static void travel(TreeNode root, Map<Integer, Integer> record, int depth, int id){
        if(root==null) return;
        travel(root.left, record, depth+1, id*2);
        travel(root.right, record, depth+1, id*2+1);

        if(!record.containsKey(depth)) record.put(depth, id);
        wmax = Math.max(wmax, id - record.get(depth)+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(maxWidth(root));
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class BinaryTreeRightView {
    static List<Integer> rightSideView(TreeNode root){
        List<Integer> rightView = new ArrayList<>();

        Map<Integer, Integer> rightMostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        nodeQueue.add(root);
        depthQueue.add(0);

        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if(node!=null){
                max_depth = Math.max(max_depth, depth);

                rightMostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        for(int i=0; i<= max_depth;i++){
            rightView.add(rightMostValueAtDepth.get(i));
        }

        return rightView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> result = rightSideView(root);
        for(int a: result){
            System.out.print(a+" ");
        }
    }
}
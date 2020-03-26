import java.util.Stack;

class BSTtoGreaterTree{

    static int sum = 0;

    TreeNode GreaterTreeIterative(TreeNode root){
        int s = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || node!=null){
            while(node!=null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            s+= node.val;
            node.val=s;
            node = node.left;
        }
        return root;
    }

    TreeNode GreaterTree(TreeNode root){
        if(root!=null){
            GreaterTree(root.right);
            sum+= root.val;
            root.val = sum;
            GreaterTree(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);    
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
    }
}
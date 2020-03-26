import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class StringFromTree{

    static String treeToString(TreeNode root){
        if(root==null) return "";
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.add(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            TreeNode t = stack.peek();
            if(visited.contains(t)){
                stack.pop();
                sb.append(")");
            }else{
                visited.add(t);
                sb.append(t.val+"(");
                if(t.left==null && t.right!=null){
                    sb.append("()");
                }
                if(t.right!=null) stack.push(t.right);
                if(t.left!=null) stack.push(t.left);
            }

        }
        return sb.substring(1, sb.length()-1);
    }

    static String preorder(TreeNode root){
        if(root==null) return "";

        if(root.left==null && root.right==null) return root.val + "";
        if(root.right==null){
            return root.val+"("+preorder(root.left)+")";
        }
        return root.val+"("+preorder(root.left)+")("+preorder(root.right)+")";

        
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        String res = preorder(root);
        System.out.println(res);
    }
}
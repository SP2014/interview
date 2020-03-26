class ValidBST{

    static long prev = (long)Integer.MIN_VALUE-1;
    // Logic: Do an inorder traversal of the binary tree
    static boolean isValid(TreeNode root){
        if(root==null) return true;

        if(!isValid(root.left)) return false;

        if(!(prev < root.val)) return false;

        prev = root.val;

        return isValid(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValid(root));
    }
}
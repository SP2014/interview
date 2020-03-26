class LCABinarySearchTree{

    static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        while(root!=null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else{
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(LCA(root, new TreeNode(2), new TreeNode(7)).val);
    }

}
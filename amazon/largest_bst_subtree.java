class LargestBstSubtree{

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            this.val = v;
            this.left = null;
            this.right = null;
        }
    }

    static class Wrapper{
        int size;
        int lower, upper;
        boolean isBst;
        
        Wrapper(){
            this.size = 0;
            this.lower = Integer.MAX_VALUE;
            this.upper = Integer.MIN_VALUE;
            this.isBst = false;
        }
    }

    static int largestBst(TreeNode root) {
        return helper(root).size;
    }

    static Wrapper helper(TreeNode root){
        Wrapper curr = new Wrapper();
        if(root == null){
            curr.isBst = true;
            return curr;
        }

        Wrapper l = helper(root.left);
        Wrapper r = helper(root.right);

        curr.lower = Math.min(root.val, l.lower);
        curr.upper = Math.max(root.val, r.upper);

        if(l.isBst && r.isBst && l.upper <= root.val && r.lower>= root.val){
            curr.size = l.size + 1 + r.size;
            curr.isBst = true;
        }else{
            curr.size = Math.max(l.size, r.size);
            curr.isBst = false;
        }
        return curr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        int s = largestBst(root);
        System.out.println(s);
    }
}
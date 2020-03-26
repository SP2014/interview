import java.util.TreeMap;
import java.util.Vector;

class BinaryTreeVerticalTraversal{

    static int min = 0;
    static int max = 0;

    static void printVertical(TreeNode root, int hd, TreeMap<Integer, Vector<Integer>> map){
        if(root==null) return;

        Vector<Integer> g = map.get(hd);
        if(g==null){
            g = new Vector<>();
            g.add(root.val);
        }
        else{
            g.add(root.val);
        }
        map.put(hd, g);
        if(root.left!=null){
            min = Math.min(min, hd-1);
            printVertical(root.left, hd-1, map);
        }
        if(root.right!=null){
            max = Math.max(max, hd+1);
            printVertical(root.right, hd+1, map);
        }  

    }

    static void verticalTraversal(TreeNode root){
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        printVertical(root, 0, map);
        for(int i = min; i <= max; i++){
            System.out.println(map.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        verticalTraversal(root);
    }
}
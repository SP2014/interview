import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SerializeBinaryTree {

    // Dserialization
    static TreeNode rdeserialize(List<String> data){
        if(data.get(0).equals("null")){
            data.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = rdeserialize(data);
        root.right = rdeserialize(data);

        return root;
    }

    static TreeNode deserialize(String str){
        String[] sarr=  str.split(",");
        List<String> data = new LinkedList<String>(Arrays.asList(sarr));
        return rdeserialize(data);
    }

    
    // Serialization
    static String rserialize(TreeNode root, String str){
        if(root==null){
            str+="null,";
        }
        else{
            str+= String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    static String serialize(TreeNode root){
        return rserialize(root, "");
    }

    static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized: "+ serialized);
        System.out.println("Deserialized: ");
        TreeNode newRoot = deserialize(serialized);
        inorder(newRoot);
    }
}
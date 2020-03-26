import java.util.Arrays;
import java.util.List;

class CountSmallerSelf {

    static class Node{
        int val;
        Node left;
        Node right;
        int size;
        int dup = 1;

        Node(int v, int s){
            this.val = v;
            this.size = s;
        }
    }

    static List<Integer> countSmaller(int[] arr){
        Integer[] res = new Integer[arr.length];
        Node root = null;
        for(int i = arr.length-1; i >= 0; i--){
           root = insert(arr[i], root, res, i, 0);
        }

        return Arrays.asList(res);
    }

    static Node insert(int num, Node node, Integer[] res, int i, int preSum){
        if(node==null){
            node = new Node(num, 0);
            res[i] = preSum;
        }
        else if(node.val == num){
            node.dup+=1;
            res[i] = preSum + node.size;
        }
        else if(node.val > num){
           node.size+=1;
           node.left = insert(num, node.left, res, i, preSum);
        }
        else{
            node.right = insert(num, node.right, res, i, preSum + node.dup + node.size);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,6,1};
        List<Integer> res = countSmaller(arr);
        for(int r: res) {
            System.out.println(r + " ");
        }
        
    }
}
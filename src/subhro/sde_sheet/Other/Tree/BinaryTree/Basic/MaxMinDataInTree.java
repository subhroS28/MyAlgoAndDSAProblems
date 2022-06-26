package subhro.sde_sheet.Other.Tree.BinaryTree.Basic;

/**
 * Question -https://practice.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1/
 */
public class MaxDataInTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }
    
    public static int findMax(Node node){
        return findMaxHelper(node, Integer.MIN_VALUE);
    }

    public static int findMaxHelper(Node root, int ans){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        ans = Math.max(ans, root.data);
        ans = Math.max(ans, findMaxHelper(root.left, ans));
        ans = Math.max(ans, findMaxHelper(root.right, ans));

        return ans;
    }

    public static int findMin(Node node){
        return findMinHelper(node, Integer.MAX_VALUE);
    }

    public static int findMinHelper(Node root, int ans){
        if(root==null){
            return Integer.MAX_VALUE;
        }

        ans = Math.min(ans, root.data);
        ans = Math.min(ans,findMinHelper(root.left, ans));
        ans = Math.min(ans,findMinHelper(root.right, ans));

        return ans;
    }
}

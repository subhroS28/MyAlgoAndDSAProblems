package subhro.sde_sheet.A_DSAByFraz.Tree.Easy;

/**
 * Question - https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Merge2BinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode req = new TreeNode();
        if(root1==null || root2==null){
            return root1==null? root2 : root1;
        }

        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right =mergeTrees(root1.right, root2.right);

        req.val = root1.val + root2.val;
        req.left = left;
        req.right = right;

        return req;
    }
}

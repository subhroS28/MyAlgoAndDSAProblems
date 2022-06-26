package subhro.sde_sheet.A_DSAByFraz.Tree;

/**
 * Question - https://leetcode.com/problems/subtree-of-another-tree/
 *            https://practice.geeksforgeeks.org/problems/check-if-subtree/1/#
 *
 *  Blog - https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 *         https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 *
 * Video - https://www.youtube.com/watch?v=4DuOrXWjQT0&ab_channel=JavaCodingInsightInterviewPreparation
 */
public class isSubtree2 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return root==null;
        }

        if(root==null){
            return false;
        }

        if(root.val==subRoot.val && isSubNodeEqual(root, subRoot)){
            return true;
        }else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSubNodeEqual(TreeNode root, TreeNode subRoot){
        if(subRoot==null){
            return root==null;
        }

        if(root==null){
            return false;
        }

        if(root.val!=subRoot.val){
            return false;
        }

        return isSubNodeEqual(root.left, subRoot.left) && isSubNodeEqual(root.right, subRoot.right);
    }

}

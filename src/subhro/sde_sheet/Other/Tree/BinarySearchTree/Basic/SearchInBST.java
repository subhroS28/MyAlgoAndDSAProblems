package subhro.sde_sheet.Other.Tree.BinarySearchTree;

/**
 * Question - https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val){
            return root;
        }else if(root.val>val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
}

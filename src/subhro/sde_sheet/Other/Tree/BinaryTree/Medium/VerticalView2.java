package subhro.sde_sheet.Other.Tree.BinaryTree.Medium;

/**
 * Question -  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *             https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1/#
 */
import java.util.*;
import subhro.sde_sheet.Other.Tree.BinaryTree.TRAVERSAL.TreeNode;
public class VerticalView {

    static class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    //GFG
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(TreeNode root) {
        ArrayList<Integer> req = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int minH = 0, maxH = 0;
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode currNode = curr.node;
            int level = curr.level;
            minH = Math.min(minH, level);
            maxH = Math.max(maxH, level);
            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(currNode.val);

            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, level - 1));
            }

            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, level + 1));
            }
        }

        for (int i = minH; i <= maxH; i++) {
            req.addAll(map.get(i));
        }
        return req;
    }
}

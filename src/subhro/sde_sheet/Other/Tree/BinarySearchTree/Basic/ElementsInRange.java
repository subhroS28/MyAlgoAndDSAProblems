package subhro.sde_sheet.Other.Tree.BinarySearchTree;

import subhro.sde_sheet.Other.Tree.BinaryTree.Medium.CheckTreeIsBalanced;

import java.util.ArrayList;

public class ElementsInRange {
    class Node
    {
        int data;
        Node left,right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> req = new ArrayList<Integer>();
        if(root==null){
            return req;
        }

        req.addAll(printNearNodes(root.left, low, high));

        if(root.data>=low && root.data<=high){
            req.add(root.data);
        }

        req.addAll(printNearNodes(root.right, low, high));
        return req;
    }
}

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();

        TreeNode node = tree.buildMainTreeNode();

        TreeNode treeNode = tree.invertTree(node);

        System.out.println(treeNode);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    private  TreeNode buildMainTreeNode() {
        TreeNode nineNode = buildTreeNode(9, null, null);
        TreeNode sixNode = buildTreeNode(6, null, null);
        TreeNode threeNode = buildTreeNode(3, null, null);
        TreeNode oneNode = buildTreeNode(1, null, null);
        TreeNode sevenNode = buildTreeNode(7, nineNode, sixNode);
        TreeNode twoNode = buildTreeNode(2, threeNode, oneNode);
        return buildTreeNode(4, sevenNode, twoNode);
    }

    private  TreeNode buildTreeNode(int val, TreeNode left, TreeNode right) {
        TreeNode node = new TreeNode();
        node.val = val;
        node.left = left;
        node.right = right;
        return node;
    }


}

class TreeNode {
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
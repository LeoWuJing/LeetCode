package tree;

public class FlattenToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode node = root.left; //寻找左子树的尾节点
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
            //右子树接到左子树尾部，左子树换到右子树
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}

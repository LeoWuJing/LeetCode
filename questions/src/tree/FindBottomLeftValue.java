package tree;

public class FindBottomLeftValue {
    int maxDeep = -1;
    int value;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        dfs(root, 0);
        return value;
    }

    public void dfs(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > maxDeep) {
                value = root.val;
                maxDeep = deep;
            }
        }
        //先遍历左子树即可(中序后序都可) 确保保留的是左节点
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }
}

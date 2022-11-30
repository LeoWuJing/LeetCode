package tree;

//getHeight会重复调用
/*
public class BalancedTree {
    public boolean isBalanced(TreeNode root){
        if(root==null) return true;
        if(Math.abs(getHeight(root.left)-getHeight(root.right))>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHeight(TreeNode root){
        if (root==null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
}
*/
//后序遍历
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if (l == -1 || r == -1 || Math.abs(l - 1) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
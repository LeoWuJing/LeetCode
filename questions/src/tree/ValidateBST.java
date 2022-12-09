package tree;

public class ValidateBST {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max){
        if(node==null) return true;
        if(node.val<=min||node.val>=max) return false;
        //父节点的值作为左子树的最大值，右子树的最小值
        return isValidBST(node.left, min, node.val)&&isValidBST(node.right,node.val,max);
    }
}

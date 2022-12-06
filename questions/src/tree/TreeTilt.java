package tree;

public class TreeTilt {
    int res=0;
    public int findTile(TreeNode root){
        sum(root);
        return res;
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        int left=sum(root.left);
        int right=sum(root.right);
        res+=Math.abs(left-right);
        return left+right+root.val;
    }
}

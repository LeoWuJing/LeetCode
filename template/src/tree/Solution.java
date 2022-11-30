package tree;

public class Solution {
    public static void main(String[] args) {
        TreeNode l=new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode root=new TreeNode(3,new TreeNode(9),l);
        int res=sumOfLeftLeaves(root);
        System.out.println(res);
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int leftSum=sumOfLeftLeaves(root.left);
        int rightSum=sumOfLeftLeaves(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            return root.left.val;
        }
        return leftSum+rightSum;
    }
}

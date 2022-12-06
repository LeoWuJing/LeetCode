package tree;

public class MaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    public TreeNode construct(int[] nums, int l, int r){
        if(l>r) return null;
        int index=-1, max=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            if(max<nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node=new TreeNode(max);
        node.left=construct(nums, l, index-1);
        node.right=construct(nums, index+1, r);
        return node;
    }
}
